package mru.tsc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FigureTest {

    private Figure figure;

    @BeforeEach
    void setUp() {
        figure = new Figure(
                "1000000001",
                "Spider-Man",
                "Marvel",
                29.99,
                20,
                "8+",
                "Action"
        );
    }

    // Test 1: Check classification
    @Test
    void testGetClassification() {
        assertEquals("Action", figure.getClassification());
    }

    // Test 2: Check the second classification getter
    @Test
    void testGetClassifcation() {
        assertEquals("Action", figure.getClassifcation());
    }

    // Test 3: Check inherited serial number
    @Test
    void testGetSerialNumber() {
        assertEquals("1000000001", figure.getSerialNumber());
    }

    // Test 4: Check inherited name
    @Test
    void testGetName() {
        assertEquals("Spider-Man", figure.getName());
    }

    // Test 5: Check inherited brand
    @Test
    void testGetBrand() {
        assertEquals("Marvel", figure.getBrand());
    }

    // Test 6: Check inherited price
    @Test
    void testGetPrice() {
        assertEquals(29.99, figure.getPrice(), 0.001);
    }

    // Test 7: Check inherited available count
    @Test
    void testGetAvailableCount() {
        assertEquals(20, figure.getAvailableCount());
    }

    // Test 8: Check inherited appropriate age
    @Test
    void testGetAppropriateAge() {
        assertEquals("8+", figure.getAppropriateAge());
    }

    // Test 9: Check toString method
    @Test
    void testToString() {
        String result = figure.toString();

        assertTrue(result.contains("Category: Figure"));
        assertTrue(result.contains("Serial Number: 1000000001"));
        assertTrue(result.contains("Name: Spider-Man"));
        assertTrue(result.contains("Brand: Marvel"));
        assertTrue(result.contains("Price: 29.99"));
        assertTrue(result.contains("Available Count: 20"));
        assertTrue(result.contains("Age Appropriate: 8+"));
        assertTrue(result.contains("Classification: Action"));
    }

}
