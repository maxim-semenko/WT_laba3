package by.epam.task03.server.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server controller.
 */
public class ServerController extends Thread {
    /**
     * The constant PORT.
     */
    public static final int PORT = 25565;
    private static final int BACKLOG = 50;

    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT, BACKLOG, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server is running");

        while (true) {
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                ServerClientController client = new ServerClientController(clientSocket, this);
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Disconnect.
     *
     * @param client the client
     */
    public void disconnect(ServerClientController client) {
        try {
            client.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client disconnected");
    }
}
