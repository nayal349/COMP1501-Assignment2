package mru.tsc.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.controller.ToyStoreController;
import mru.tsc.model.Toy;

/**
 * Displays the main menu and search menu
 * for the Toy Store Company application.
 */
public class ToyStoreMenu {

    private Scanner input;
    private ToyStoreController controller;

    /**
     * Creates a MainMenu object.
     *
     * @param t the controller used by the menu
     */
    public ToyStoreMenu(ToyStoreController t) {
        input = new Scanner(System.in);
        controller = t;
    }

    /**
     * Displays the main menu and gets the user's choice.
     *
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
     *
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
     * Displays the toy type menu and gets the user's choice.
     *
     * @return the toy type selected by the user
     */
    public int displayTypeMenu() {

        int type = 0;

        System.out.println("\nToy Types:\n");

        System.out.println("(1) Figure");
        System.out.println("(2) Animal");
        System.out.println("(3) Puzzle");
        System.out.println("(4) Board Game");

        System.out.print("\nEnter Type: ");

        if (input.hasNextInt()) {
            type = input.nextInt();
        } else {
            input.next();
        }

        return type;
    }

    /**
     * Searches for a toy using its serial number.
     */
    public void searchBySerialNumber() {

        System.out.print("\nEnter Serial Number: ");

        String serialNumber = input.next();

        Toy toy = controller.searchBySerialNumber(serialNumber);

        if (toy != null) {

            System.out.println("\nToy Found:\n");
            System.out.println(toy);

        } else {

            System.out.println("\nNo toy was found with that serial number.");
        }
    }

    /**
     * Searches for toys using a name or part of a name.
     */
    public void searchByName() {

        // Clear the remaining new line from the previous input.
        input.nextLine();

        System.out.print("\nEnter Toy Name: ");

        String name = input.nextLine();

        ArrayList<Toy> results = controller.searchByName(name);

        if (results.size() > 0) {

            System.out.println("\nFound " + results.size() + " toy(s):\n");

            for (int i = 0; i < results.size(); i++) {

                System.out.println("Toy " + (i + 1));
                System.out.println(results.get(i));
                System.out.println();
            }

        } else {

            System.out.println("\nNo toys were found with that name.");
        }
    }

    /**
     * Searches for toys by their type.
     */
    public void searchByType() {

        int type = displayTypeMenu();

        if (type < 1 || type > 4) {

            System.out.println("\nInvalid toy type.");
            return;
        }

        ArrayList<Toy> results = controller.searchByType(type);

        if (results.size() > 0) {

            System.out.println("\nFound " + results.size() + " toy(s):\n");

            for (int i = 0; i < results.size(); i++) {

                System.out.println("Toy " + (i + 1));
                System.out.println(results.get(i));
                System.out.println();
            }

        } else {

            System.out.println("\nNo toys were found with that type.");
        }
    }

    /**
     * Displays the search menu and handles the user's
     * search option.
     */
    public void searchInventory() {

        int option = 0;

        while (option != 4) {

            option = displaySearchMenu();

            switch (option) {

                case 1:
                    searchBySerialNumber();
                    break;

                case 2:
                    searchByName();
                    break;

                case 3:
                    searchByType();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1-4.");
                    break;
            }
        }
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
                    searchInventory();
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
