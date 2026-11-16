package mru.tsc.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.ToyStoreController;
import mru.tsc.model.Figure;

class ToyStoreMenuTest {

    private ToyStoreController controller;
    private ToyStoreMenu menu;

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        originalOut = System.out;

        controller = new ToyStoreController();
        output = new ByteArrayOutputStream();
    }

    // Helper method to provide input to the menu
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(output));

        menu = new ToyStoreMenu(controller);
    }

    // Restore original system input and output
    private void restoreSystemStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testDisplayMainMenu() {
        setInput("1\n");

        try {
            int option = menu.displayMainMenu();

            assertEquals(1, option);
            assertTrue(output.toString().contains("WELCOME TO TOY STORE COMPANY"));
            assertTrue(output.toString().contains("Search Inventory and Purchase Toy"));
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplaySearchMenu() {
        setInput("2\n");

        try {
            int option = menu.displaySearchMenu();

            assertEquals(2, option);
            assertTrue(output.toString().contains("Toy Name"));
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplayTypeMenu() {
        setInput("3\n");

        try {
            int type = menu.displayTypeMenu();

            assertEquals(3, type);
            assertTrue(output.toString().contains("Puzzle"));
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplayMainMenuInvalidInput() {
        setInput("abc\n");

        try {
            int option = menu.displayMainMenu();

            assertEquals(0, option);
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplaySearchMenuInvalidInput() {
        setInput("abc\n");

        try {
            int option = menu.displaySearchMenu();

            assertEquals(0, option);
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplayTypeMenuInvalidInput() {
        setInput("abc\n");

        try {
            int type = menu.displayTypeMenu();

            assertEquals(0, type);
        } finally {
            restoreSystemStreams();
        }
    }

    @Test
    void testDisplayResults() {
        setInput("");

        try {
            Figure figure = new Figure(
                "1000000001",
                "Spider-Man",
                "Marvel",
                29.99,
                20,
                "8+",
                "Action"
            );

            controller.addToy(figure);

            menu.displayResults(controller.getToys());

            assertTrue(output.toString().contains("Found 1 toy(s)"));
            assertTrue(output.toString().contains("Spider-Man"));
        } finally {
            restoreSystemStreams();
        }
    }

		
		@Test
		void testCompletePurchase() {
		    setInput("\n\n");
		
		    try {
		        Figure figure = new Figure(
		                "1000000001",
		                "Spider-Man",
		                "Marvel",
		                29.99,
		                20,
		                "8+",
		                "Action"
		        );
		
		        controller.addToy(figure);
		
		        menu.completePurchase(figure);
		
		        // Check that one toy was purchased
		        assertEquals(19, figure.getAvailableCount());
		
		        // Check the success message
		        assertTrue(output.toString().contains(
		                "The transaction was completed successfully."
		        ));
		
		        // Check the remaining inventory message
		        assertTrue(output.toString().contains(
		                "Remaining Available Count: 19"
		        ));
		
		    } finally {
		        restoreSystemStreams();
		    }
		
		
		    }
		}
