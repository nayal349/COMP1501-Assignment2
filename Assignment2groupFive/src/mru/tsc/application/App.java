package mru.tsc.application;

import mru.tsc.controller.ToyStoreController;
import mru.tsc.view.ToyStoreMenu;

/**
 * Main class of the Toy Store Company.
 * Runs the application.
 */
public class App {

    /**
     * Main method that starts the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        startApplication();
    }

    /**
     * Starts the application by loading the inventory
     * and displaying the menu.
     */
    public static void startApplication() {

        // Create the controller.
        ToyStoreController controller = new ToyStoreController();

        // Load the toy inventory.
        controller.loadInventory();

        // Create the menu.
        ToyStoreMenu menu = new ToyStoreMenu(controller);

        // Display the menu.
        menu.start();
    }
}