package mru.tsc.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidPlayersExceptionTest {

    @Test
    void testExceptionMessage() {
        InvalidPlayersException exception =
                new InvalidPlayersException("Invalid number of players");

        assertEquals("Invalid number of players", exception.getMessage());
    }

    @Test
    void testExceptionIsThrown() {
        assertThrows(InvalidPlayersException.class, () -> {
            throw new InvalidPlayersException("Minimum players cannot be greater than maximum players.");
        });
    }

}

class invalidPlayerExceptionTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
