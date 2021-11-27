package by.epam.task03.server.controller;

import by.epam.task03.server.command.Command;
import by.epam.task03.server.command.CommandProvider;
import by.epam.task03.server.command.exception.CommandException;
import by.epam.task03.server.command.impl.DisconnectCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

/**
 * The type Server client controller.
 */
public class ServerClientController extends Thread {
    private final Socket socket;
    private final ServerController serverController;

    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * Instantiates a new Server client controller.
     *
     * @param socket           the socket
     * @param serverController the server controller
     */
    public ServerClientController(Socket socket, ServerController serverController) {
        this.socket = socket;
        this.serverController = serverController;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendMessage("Available commands:\n " +
                "AUTH USER/MANAGER\n " +
                "DISCONNECT\n " +
                "VIEW\n " +
                "CREATE (firstname) (lastname)\n " +
                "EDIT (id) (firstname) (lastname)");

        boolean running = true;
        do {
            try {
                String request = readMessage();
                if (request == null) {
                    break;
                }

                Command command = CommandProvider.getInstance().getCommand(request);
                String response = command.execute(this, request);
                sendMessage(response);

                if (command instanceof DisconnectCommand) {
                    running = false;
                }
            } catch (CommandException e) {
                e.printStackTrace();
                sendMessage(e.getMessage());
            }
        } while (running);

        serverController.disconnect(this);
    }

    private String readMessage() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Send message.
     *
     * @param message the message
     */
    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    /**
     * Gets socket.
     *
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerClientController that = (ServerClientController) o;
        return socket.equals(that.socket) && serverController.equals(that.serverController);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, serverController);
    }
}
