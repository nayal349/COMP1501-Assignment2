package mru.tsc.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidPriceExceptionTest {

    @Test
    void testExceptionMessage() {
        InvalidPriceException exception =
                new InvalidPriceException("Price cannot be negative.");

        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    void testExceptionIsThrown() {
        assertThrows(InvalidPriceException.class, () -> {
            throw new InvalidPriceException("Price cannot be negative.");
        });
    }

}
