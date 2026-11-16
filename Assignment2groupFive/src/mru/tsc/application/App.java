package mru.tsc.application;

import mru.tsc.controller.ToyStoreController;
import mru.tsc.view.ToyStoreMenu;

/**
 * Main application class for the Toy Store Company.
 * Starts the program and connects the controller and view.
 */
public class App {

    /**
     * Main method that starts the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        startApplication();

    }

    /**
     * Initializes the controller, loads inventory,
     * creates the menu, and starts the application.
     */
    public static void startApplication() {

        // Create the controller.
        ToyStoreController controller = new ToyStoreController();

        // Load the inventory.
        controller.loadInventory();

        // Create the menu and connect it to the controller.
        ToyStoreMenu menu = new ToyStoreMenu(controller);

        // Start the application.
        menu.start();

    }

}
