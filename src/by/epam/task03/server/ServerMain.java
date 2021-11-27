package by.epam.task03.server;

import by.epam.task03.server.controller.ServerController;

/**
 * The type Server main.
 */
public class ServerMain {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ServerController server = new ServerController();
        server.start();
    }
}
