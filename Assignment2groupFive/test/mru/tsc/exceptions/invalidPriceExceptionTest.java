package mru.tsc.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidPriceExceptionTest {

    @Test
    void testExceptionMessage() {

        String message = "Price cannot be negative.";

        InvalidPriceException exception =
                new InvalidPriceException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void testExceptionCreation() {

        InvalidPriceException exception =
                new InvalidPriceException("Invalid price");

        assertNotNull(exception);
    }

    @Test
    void testExceptionInheritance() {

        InvalidPriceException exception =
                new InvalidPriceException("Invalid price");

        assertTrue(exception instanceof Exception);
    }

}
