package by.epam.task03.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Client input controller.
 */
public class ClientInputController extends Thread {
    private final ClientController client;

    /**
     * Instantiates a new Client input controller.
     *
     * @param client the client
     */
    public ClientInputController(ClientController client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (client.isRunning()) {
                String response = reader.readLine();
                client.sendMessage(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
