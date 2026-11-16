package mru.tsc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToyTest {

    private Toy toy;

    @BeforeEach
    void setUp() {
        // Use Figure as a concrete implementation of Toy
        toy = new Figure(
                "1000000001",
                "Spider-Man",
                "Marvel",
                29.99,
                20,
                "8+",
                "Action"
        );
    }

    // Test 1: Check serial number
    @Test
    void testGetSerialNumber() {
        assertEquals("1000000001", toy.getSerialNumber());
    }

    // Test 2: Check name
    @Test
    void testGetName() {
        assertEquals("Spider-Man", toy.getName());
    }

    // Test 3: Check brand
    @Test
    void testGetBrand() {
        assertEquals("Marvel", toy.getBrand());
    }

    // Test 4: Check price
    @Test
    void testGetPrice() {
        assertEquals(29.99, toy.getPrice(), 0.001);
    }

    // Test 5: Check available count
    @Test
    void testGetAvailableCount() {
        assertEquals(20, toy.getAvailableCount());
    }

    // Test 6: Check appropriate age
    @Test
    void testGetAppropriateAge() {
        assertEquals("8+", toy.getAppropriateAge());
    }

    // Test 7: Check setAvailableCount
    @Test
    void testSetAvailableCount() {
        toy.setAvailableCount(10);

        assertEquals(10, toy.getAvailableCount());
    }

    // Test 8: Check setting available count to zero
    @Test
    void testSetAvailableCountToZero() {
        toy.setAvailableCount(0);

        assertEquals(0, toy.getAvailableCount());
    }

}
