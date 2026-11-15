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

        String serialNumber;

        do {

            System.out.print("\nEnter Serial Number: ");
            serialNumber = input.next();

            if (!controller.isValidSerialNumber(serialNumber)) {
                System.out.println(
                        "Invalid Serial Number. Serial Number must contain 10 digits.");
            }

        } while (!controller.isValidSerialNumber(serialNumber));

        Toy toy = controller.searchBySerialNumber(serialNumber);

        if (toy != null) {

            System.out.println("\nToy Found:\n");
            System.out.println(toy);

            purchaseSingleToy(toy);

        } else {

            System.out.println(
                    "\nNo toy was found with that serial number.");
        }
    }

    /**
     * Searches for toys using a name or part of a name.
     */
    public void searchByName() {

        input.nextLine();

        System.out.print("\nEnter Toy Name: ");

        String name = input.nextLine();

        ArrayList<Toy> results = controller.searchByName(name);

        if (results.size() > 0) {

            displayResults(results);
            selectToyToPurchase(results);

        } else {

            System.out.println(
                    "\nNo toys were found with that name.");
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

            displayResults(results);
            selectToyToPurchase(results);

        } else {

            System.out.println(
                    "\nNo toys were found with that type.");
        }
    }

    /**
     * Displays all toys found from a search.
     *
     * @param results the list of toys found
     */
    public void displayResults(ArrayList<Toy> results) {

        System.out.println(
                "\nFound " + results.size() + " toy(s):\n");

        for (int i = 0; i < results.size(); i++) {

            System.out.println("Toy " + (i + 1));
            System.out.println(results.get(i));
            System.out.println();
        }
    }

    /**
     * Lets the user choose one toy from the search results.
     *
     * @param results the list of toys found
     */
    public void selectToyToPurchase(ArrayList<Toy> results) {

        int selection = -1;

        while (selection < 0 || selection > results.size()) {

            System.out.println(
                    "Enter the toy number you would like to purchase.");
            System.out.println(
                    "Enter 0 to return to the search menu.");

            System.out.print("\nEnter Option: ");

            if (input.hasNextInt()) {

                selection = input.nextInt();

            } else {

                input.next();
                System.out.println("\nInvalid option.");
                continue;
            }

            if (selection < 0 || selection > results.size()) {

                System.out.println("\nInvalid option.");
            }
        }

        if (selection == 0) {
            return;
        }

        Toy toy = results.get(selection - 1);

        completePurchase(toy);
    }

    /**
     * Allows the user to purchase a toy found by serial number.
     *
     * @param toy the toy found
     */
    public void purchaseSingleToy(Toy toy) {

        int option = 0;

        while (option != 1 && option != 2) {

            System.out.println("\n(1) Purchase Toy");
            System.out.println("(2) Back to Search Menu");

            System.out.print("\nEnter Option: ");

            if (input.hasNextInt()) {

                option = input.nextInt();

            } else {

                input.next();
                System.out.println("\nInvalid option.");
            }

            if (option != 1 && option != 2) {

                System.out.println(
                        "\nInvalid option. Please enter 1 or 2.");
            }
        }

        if (option == 1) {

            completePurchase(toy);
        }
    }

    /**
     * Completes the purchase of a selected toy.
     *
     * @param toy the toy selected for purchase
     */
    public void completePurchase(Toy toy) {

        if (controller.purchaseToy(toy)) {

            System.out.println(
                    "\nThe transaction was completed successfully.");

            System.out.println(
                    "Remaining Available Count: "
                    + toy.getAvailableCount());

        } else {

            System.out.println(
                    "\nSorry, this toy is currently out of stock.");
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
                    System.out.println(
                            "Invalid option. Please enter 1-4.");
                    break;
            }
        }
    }

    /**
     * Starts the Toy Store application and displays the main menu.
     */
    public void start() {

        int option = 0;

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
                    controller.saveInventory();
                    System.out.println("Thank you for visiting Toy Store Company!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please enter 1-4.");
                    break;
            }
        }
    }
}
