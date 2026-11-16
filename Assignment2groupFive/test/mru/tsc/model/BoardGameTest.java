package mru.tsc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardGameTest {

    private BoardGame boardGame;

    @BeforeEach
    void setUp() {
        boardGame = new BoardGame(
                "7000000001",
                "Monopoly",
                "Hasbro",
                39.99,
                15,
                "8+",
                2,
                6,
                "Elizabeth Magie"
        );
    }

    // Test 1: Check minimum players
    @Test
    void testGetMinPlayers() {
        assertEquals(2, boardGame.getMinPlayers());
    }

    // Test 2: Check maximum players
    @Test
    void testGetMaxPlayers() {
        assertEquals(6, boardGame.getMaxPlayers());
    }

    // Test 3: Check designers
    @Test
    void testGetDesigners() {
        assertEquals("Elizabeth Magie", boardGame.getDesigners());
    }

    // Test 4: Check inherited serial number
    @Test
    void testGetSerialNumber() {
        assertEquals("7000000001", boardGame.getSerialNumber());
    }

    // Test 5: Check inherited name
    @Test
    void testGetName() {
        assertEquals("Monopoly", boardGame.getName());
    }

    // Test 6: Check inherited brand
    @Test
    void testGetBrand() {
        assertEquals("Hasbro", boardGame.getBrand());
    }

    // Test 7: Check inherited price
    @Test
    void testGetPrice() {
        assertEquals(39.99, boardGame.getPrice(), 0.001);
    }

    // Test 8: Check inherited available count
    @Test
    void testGetAvailableCount() {
        assertEquals(15, boardGame.getAvailableCount());
    }

    // Test 9: Check inherited appropriate age
    @Test
    void testGetAppropriateAge() {
        assertEquals("8+", boardGame.getAppropriateAge());
    }

    // Test 10: Check toString method
    @Test
    void testToString() {
        String result = boardGame.toString();

        assertTrue(result.contains("Category: BoardGame"));
        assertTrue(result.contains("Serial Number: 7000000001"));
        assertTrue(result.contains("Name: Monopoly"));
        assertTrue(result.contains("Brand: Hasbro"));
        assertTrue(result.contains("Price: 39.99"));
        assertTrue(result.contains("Available Count: 15"));
        assertTrue(result.contains("Age Appropriate: 8+"));
        assertTrue(result.contains("Players: 2-6"));
        assertTrue(result.contains("Designers: Elizabeth Magie"));
    }

}
