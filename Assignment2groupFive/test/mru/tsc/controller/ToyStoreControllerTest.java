package mru.tsc.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.exceptions.InvalidPriceException;
import mru.tsc.exceptions.InvalidPlayersException;

class ToyStoreControllerTest {

    private ToyStoreController controller;

    @BeforeEach
    void setUp() {
        controller = new ToyStoreController();
    }

    // Test 1: Valid serial number
    @Test
    void testValidSerialNumber() {
        assertTrue(controller.isValidSerialNumber("1234567890"));
    }

    // Test 2: Serial number with less than 10 digits
    @Test
    void testInvalidSerialNumberLength() {
        assertFalse(controller.isValidSerialNumber("12345"));
    }

    // Test 3: Serial number containing letters
    @Test
    void testSerialNumberWithLetters() {
        assertFalse(controller.isValidSerialNumber("12345ABCDE"));
    }

    // Test 4: Valid price
    @Test
    void testValidPrice() {
        assertDoesNotThrow(() -> controller.validatePrice(25.99));
    }

    // Test 5: Negative price
    @Test
    void testInvalidPrice() {
        assertThrows(InvalidPriceException.class,
                () -> controller.validatePrice(-10.00));
    }

    // Test 6: Valid number of players
    @Test
    void testValidPlayers() {
        assertDoesNotThrow(() -> controller.validatePlayers(2, 4));
    }

    // Test 7: Invalid number of players
    @Test
    void testInvalidPlayers() {
        assertThrows(InvalidPlayersException.class,
                () -> controller.validatePlayers(5, 2));
    }

}
