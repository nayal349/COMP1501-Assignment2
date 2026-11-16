package mru.tsc.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class InvalidPlayersExceptionTest {

    @Test
    void testConstructor() {
        String message = "Invalid number of players";

        InvalidPlayersException exception =
                new InvalidPlayersException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}


