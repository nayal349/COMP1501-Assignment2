package mru.tsc.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class InvalidPriceExceptionTest {

    @Test
    void testConstructor() {
        String message = "Invalid toy price";

        InvalidPriceException exception =
                new InvalidPriceException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}