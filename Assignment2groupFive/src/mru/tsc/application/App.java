
package mru.tsc.application;

import mru.tsc.controller.*;
import mru.tsc.view.*;

/**
 * Main application class for the Toy Store Company.
 * starts the program and connects the controller and view.
 */
public class App {

    /**
     * main method that starts the application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create the controller.
        ToyStoreController t = new ToyStoreController();

        // Load the inventory.
        t.loadInventory();

        // Create the menu and connect it to the controller.
        ToyStoreMenu menu = new ToyStoreMenu(t);

        // Start the application.
        menu.start();
    }
}
