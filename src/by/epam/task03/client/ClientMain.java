package by.epam.task03.client;

import by.epam.task03.client.controller.ClientController;

/**
 * The type Client main.
 */
public class ClientMain {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ClientController client = new ClientController();
        client.start();
    }
}
