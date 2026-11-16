package mru.tsc.exceptions;

/**
 * Represents an exception that occurs when a toy is assigned
 * a negative price.
 */
public class InvalidPriceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates an InvalidPriceException with an error message
     * @param message explains why the price is invalid
     */
    public InvalidPriceException(String message) {

        // passes the error message to the parent Exception class.
        super(message);
    }

}
