package mru.tsc.exceptions;

/**
 * Represents an exception that occurs when a board game's
 * minimum number of players is greater than its maximum.
 */
public class InvalidPlayersException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates an InvalidPlayersException with an error message.
     *
     * @param message explains why the player count is invalid
     */
	   public InvalidPlayersException(String message) {
	        super(message);
    }
}

