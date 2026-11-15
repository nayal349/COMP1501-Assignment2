package mru.tsc.exceptions;

/**
 * Represents an exception that occurs when a board game's
 * minimum number of players is greater than its maximum.
 *
 * 
 */
public class InvalidPlayersException extends Exception {

    /**
     * creates an InvalidPlayerCountException with an error message.
     * @param message explains why the player count is invalid
     */
    public InvalidPlayersException(String message) {

        // Passes the error message to the parent Exception class.
        super(message);
    }

}
