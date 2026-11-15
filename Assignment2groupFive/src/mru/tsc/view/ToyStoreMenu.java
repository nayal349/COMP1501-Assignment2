package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.controller.ToyStoreController;

/**
 * Displays the main menu and search menu
 * for the Toy Store Company application.
 */
public class ToyStoreMenu {

    private Scanner input;

    /**
     * Creates a MainMenu object.
     * @param 
     */
    public ToyStoreMenu(ToyStoreController t) {
        input = new Scanner(System.in);
    }

    /**
     * Displays the main menu and gets the user's choice.
     * @return the option selected by the user
     */
    public int displayMainMenu() {

        int option = 0;

        System.out.println("\n*************************************");
        System.out.println("     WELCOME TO TOY STORE COMPANY");
        System.out.println("***************************************");

        System.out.println("\nHow can we help you?\n");

        System.out.println("(1) Search Inventory and Purchase Toy");
        System.out.println("(2) Add New Toy");
        System.out.println("(3) Remove Toy");
        System.out.println("(4) Save & Exit");

        System.out.print("\nEnter Option: ");

        if (input.hasNextInt()) {
            option = input.nextInt();
        } else {
            input.next();
        }

        return option;
    }

    /**
     * Displays the search menu and gets the user's choice.
     * @return the search option selected by the user
     */
    public int displaySearchMenu() {

        int option = 0;

        System.out.println("\nFind Toys With:\n");

        System.out.println("(1) Serial Number (SN)");
        System.out.println("(2) Toy Name");
        System.out.println("(3) Type");
        System.out.println("(4) Back to Main Menu");

        System.out.print("\nEnter Option: ");

        if (input.hasNextInt()) {
            option = input.nextInt();
        } else {
            input.next();
        }

        return option;
    }

    /**
     * Starts the Toy Store application and displays the main menu.
     */
    public void start() {

        int option = 0;

        // Keep displaying the menu until the user chooses to exit.
        while (option != 4) {

            option = displayMainMenu();

            switch (option) {

                case 1:
                    System.out.println("Search Inventory and Purchase Toy");
                    break;

                case 2:
                    System.out.println("Add New Toy");
                    break;

                case 3:
                    System.out.println("Remove Toy");
                    break;

                case 4:
                    System.out.println("Thank you for visiting Toy Store Company!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1-4.");
                    break;
            }
        }
    }
}

        
    
