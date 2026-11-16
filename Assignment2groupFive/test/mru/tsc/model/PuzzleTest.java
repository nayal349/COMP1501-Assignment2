package mru.tsc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuzzleTest {

    private Puzzle puzzle;

    @BeforeEach
    void setUp() {
        puzzle = new Puzzle(
            "3000000001",
            "Rubik's Cube",
            "Rubik's",
            19.99,
            12,
            "8+",
            "Mechanical"
        );
    }

    @Test
    void testGetPuzzleType() {
        assertEquals("Mechanical", puzzle.getPuzzleType());
    }

    @Test
    void testGetSerialNumber() {
        assertEquals("3000000001", puzzle.getSerialNumber());
    }

    @Test
    void testGetName() {
        assertEquals("Rubik's Cube", puzzle.getName());
    }

    @Test
    void testGetBrand() {
        assertEquals("Rubik's", puzzle.getBrand());
    }

    @Test
    void testGetPrice() {
        assertEquals(19.99, puzzle.getPrice(), 0.001);
    }

    @Test
    void testGetAvailableCount() {
        assertEquals(12, puzzle.getAvailableCount());
    }

    @Test
    void testGetAppropriateAge() {
        assertEquals("8+", puzzle.getAppropriateAge());
    }

    @Test
    void testToString() {
        String result = puzzle.toString();

        assertTrue(result.contains("Category: Puzzle"));
        assertTrue(result.contains("Serial Number: 3000000001"));
        assertTrue(result.contains("Name: Rubik's Cube"));
        assertTrue(result.contains("Brand: Rubik's"));
        assertTrue(result.contains("Price: 19.99"));
        assertTrue(result.contains("Available Count: 12"));
        assertTrue(result.contains("Age Appropriate: 8+"));
        assertTrue(result.contains("Puzzle Type: Mechanical"));
    }
}