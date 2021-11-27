package by.epam.task03.server.command.exception;

/**
 * The type Command exception.
 */
public class CommandException extends Exception{
    /**
     * Instantiates a new Command exception.
     */
    public CommandException() {
        super();
    }

    /**
     * Instantiates a new Command exception.
     *
     * @param message the message
     */
    public CommandException(String message) {
        super(message);
    }
}
