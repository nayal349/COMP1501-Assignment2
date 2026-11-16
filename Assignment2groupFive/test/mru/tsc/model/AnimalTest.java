package mru.tsc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnimalTest {

    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal(
                "2000000001",
                "Teddy Bear",
                "Lego",
                25.99,
                10,
                "3+",
                "Cotton",
                "Large"
        );
    }

    // Test 1: Check the animal's material
    @Test
    void testGetMaterial() {
        assertEquals("Cotton", animal.getMaterial());
    }

    // Test 2: Check the animal's size
    @Test
    void testGetSize() {
        assertEquals("Large", animal.getSize());
    }

    // Test 3: Check the inherited serial number
    @Test
    void testGetSerialNumber() {
        assertEquals("2000000001", animal.getSerialNumber());
    }

    // Test 4: Check the inherited name
    @Test
    void testGetName() {
        assertEquals("Teddy Bear", animal.getName());
    }

    // Test 5: Check the inherited brand
    @Test
    void testGetBrand() {
        assertEquals("Lego", animal.getBrand());
    }

    // Test 6: Check the inherited price
    @Test
    void testGetPrice() {
        assertEquals(25.99, animal.getPrice(), 0.001);
    }

    // Test 7: Check the inherited available count
    @Test
    void testGetAvailableCount() {
        assertEquals(10, animal.getAvailableCount());
    }

    // Test 8: Check the inherited appropriate age
    @Test
    void testGetAppropriateAge() {
        assertEquals("3+", animal.getAppropriateAge());
    }

    // Test 9: Check the toString method
    @Test
    void testToString() {
        String result = animal.toString();

        assertTrue(result.contains("Category: Animal"));
        assertTrue(result.contains("Serial Number: 2000000001"));
        assertTrue(result.contains("Name: Teddy Bear"));
        assertTrue(result.contains("Brand: Lego"));
        assertTrue(result.contains("Price: 25.99"));
        assertTrue(result.contains("Available Count: 10"));
        assertTrue(result.contains("Age Appropriate: 3+"));
        assertTrue(result.contains("Size: Large"));
        assertTrue(result.contains("Material: Cotton"));
    }
}
