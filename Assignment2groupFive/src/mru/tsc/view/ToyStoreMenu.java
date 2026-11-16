package mru.tsc.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.controller.ToyStoreController;
import mru.tsc.model.*;
import mru.tsc.exceptions.InvalidPriceException;
import mru.tsc.exceptions.InvalidPlayersException;

/**
 * Shows the menus and handles user choices.
 */
public class ToyStoreMenu {

    private Scanner input;
    private ToyStoreController controller;

    /**
     * Creates the menu.
     * @param t the controller
     */
    public ToyStoreMenu(ToyStoreController t) {
        input = new Scanner(System.in);
        controller = t;
    }

    
    
    
    
   
    /**
     * Shows the main menu.
     * @return the option chosen by the user
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
        System.out.println("(4) Make a Gift Suggestion");
        System.out.println("(5) Save & Exit");

        System.out.print("\nEnter Option: ");

        if (input.hasNextInt()) {
            option = input.nextInt();
        } else {
            input.next();
        }

        return option;
    }

    
    
    
    /**
     * Shows the search menu.
     * @return the option chosen by the user
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
     * Shows the toy type menu.
     * @return the type chosen by the user
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
     * Finds a toy using its serial number.
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
     * Finds toys using their names.
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
     * Finds toys using their type.
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
     * Shows the toys found in a search.
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
     * Lets the user choose a toy to buy.
     * @param results the list of toys found
     */
    public void selectToyToPurchase(ArrayList<Toy> results) {

        int selection = -1;

        while (selection < 0
                || selection > results.size()) {

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

            if (selection < 0
                    || selection > results.size()) {

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
     * Lets the user buy a toy or go back.
     * @param toy the toy selected
     */
    public void purchaseSingleToy(Toy toy) {

        int option = 0;

        while (option != 1
                && option != 2) {

            System.out.println("\n(1) Purchase Toy");
            System.out.println("(2) Back to Search Menu");

            System.out.print("\nEnter Option: ");

            if (input.hasNextInt()) {

                option = input.nextInt();

            } else {

                input.next();
                System.out.println("\nInvalid option.");
            }

            if (option != 1
                    && option != 2) {

                System.out.println(
                        "\nInvalid option. Please enter 1 or 2.");
            }
        }

        if (option == 1) {

            completePurchase(toy);
        }
    }

    
    
    
    
    
    /**
     * Buys the selected toy.
     * @param toy the toy selected
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

        input.nextLine();

        System.out.print(
                "Press Enter to Continue...");

        input.nextLine();
    }

    
    
    
    
    
    
    
    /**
     * Adds a new toy to the inventory.
     */
    public void addNewToy() {

        input.nextLine();

        String serialNumber;

        while (true) {

            System.out.print("\nEnter Serial Number: ");
            serialNumber = input.nextLine().trim();

            if (!controller.isValidSerialNumber(serialNumber)) {

                System.out.println(
                        "Invalid Serial Number. Serial Number must contain 10 digits.");

            } else if (controller.serialNumberExists(serialNumber)) {

                System.out.println(
                        "A toy with this Serial Number already exists.");

            } else {

                break;
            }
        }

        
        
        
        
        
        
        System.out.print("Enter Toy Name: ");
        String name = input.nextLine();

        System.out.print("Enter Toy Brand: ");
        String brand = input.nextLine();

        double price;

        while (true) {

            System.out.print("Enter Toy Price: ");

            try {

                price = Double.parseDouble(
                        input.nextLine());

                controller.validatePrice(price);

                break;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid price. Please enter a number.");

            } catch (InvalidPriceException e) {

                System.out.println(
                        e.getMessage());
            }
        }

        int availableCount =
                readNonNegativeInteger(
                        "Enter Available Counts: ");

        String appropriateAge;

        while (true) {

            System.out.print(
                    "Enter Appropriate Age: ");

            appropriateAge =
                    input.nextLine().trim();

            try {

                int age = Integer.parseInt(appropriateAge);

                if (age >= 0) {
                    break;
                }

                System.out.println(
                        "Age cannot be negative.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid age. Please enter a number.");
            }
        }

        char firstDigit =
                serialNumber.charAt(0);

        if (firstDigit == '0'
                || firstDigit == '1') {

            String classification;

            while (true) {

                System.out.print(
                        "Enter Classification (A/D/H): ");

                classification =
                        input.nextLine()
                        .trim()
                        .toUpperCase();

                if (classification.equals("A")
                        || classification.equals("D")
                        || classification.equals("H")) {

                    break;
                }

                System.out.println(
                        "Invalid classification. Enter A, D, or H.");
            }

            Figure figure =
                    new Figure(
                            serialNumber,
                            name,
                            brand,
                            price,
                            availableCount,
                            appropriateAge,
                            classification);

            controller.addToy(figure);

            
            
            
        } else if (firstDigit == '2'
                || firstDigit == '3') {

            System.out.print(
                    "Enter Material: ");

            String material =
                    input.nextLine();

            String size;

            while (true) {

                System.out.print(
                        "Enter Size (S/M/L): ");

                size =
                        input.nextLine()
                        .trim()
                        .toUpperCase();

                if (size.equals("S")
                        || size.equals("M")
                        || size.equals("L")) {

                    break;
                }

                System.out.println(
                        "Invalid size. Enter S, M, or L.");
            }

            Animal animal =
                    new Animal(
                            serialNumber,
                            name,
                            brand,
                            price,
                            availableCount,
                            appropriateAge,
                            material,
                            size);

            controller.addToy(animal);

        } else if (firstDigit == '4'
                || firstDigit == '5'
                || firstDigit == '6') {

            String puzzleType;

            while (true) {

                System.out.print(
                        "Enter Puzzle Type (M/C/L/T/R): ");

                puzzleType =
                        input.nextLine()
                        .trim()
                        .toUpperCase();

                if (puzzleType.equals("M")
                        || puzzleType.equals("C")
                        || puzzleType.equals("L")
                        || puzzleType.equals("T")
                        || puzzleType.equals("R")) {

                    break;
                }

                System.out.println(
                        "Invalid puzzle type. Enter M, C, L, T, or R.");
            }

            Puzzle puzzle =
                    new Puzzle(
                            serialNumber,
                            name,
                            brand,
                            price,
                            availableCount,
                            appropriateAge,
                            puzzleType);

            controller.addToy(puzzle);

        } else {

            int minPlayers;
            int maxPlayers;

            while (true) {

                minPlayers =
                        readPositiveInteger(
                                "Enter Minimum Number of Players: ");

                maxPlayers =
                        readPositiveInteger(
                                "Enter Maximum Number of Players: ");

                try {

                    controller.validatePlayers(
                            minPlayers,
                            maxPlayers);

                    break;

                } catch (InvalidPlayersException e) {

                    System.out.println(
                            e.getMessage());
                }
            }

            System.out.print(
                    "Enter Designer Names (use ',' to separate names): ");

            String designers =
                    input.nextLine();

            BoardGame boardGame =
                    new BoardGame(
                            serialNumber,
                            name,
                            brand,
                            price,
                            availableCount,
                            appropriateAge,
                            minPlayers,
                            maxPlayers,
                            designers);

            controller.addToy(boardGame);
        }

        System.out.println(
                "\nNew Toy Added!");

        System.out.print(
                "Press Enter to Continue...");

        input.nextLine();
    }

    
    
    
    
    
    
    
    
    /**
     * Reads a number that is zero or greater.
     * @param message the message to show
     * @return the valid number
     */
    private int readNonNegativeInteger(
            String message) {

        while (true) {

            System.out.print(message);

            try {

                int number =
                        Integer.parseInt(
                                input.nextLine());

                if (number >= 0) {

                    return number;
                }

                System.out.println(
                        "Please enter 0 or greater.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number.");
            }
        }
    }

    /**
     * Reads a number greater than zero.
     * @param message the message to show
     * @return the valid number
     */
    private int readPositiveInteger(
            String message) {

        while (true) {

            System.out.print(message);

            try {

                int number =
                        Integer.parseInt(
                                input.nextLine());

                if (number > 0) {

                    return number;
                }

                System.out.println(
                        "Please enter a number greater than 0.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number.");
            }
        }
    }

    /**
     * Removes a toy using its serial number.
     */
    public void removeToy() {

        String serialNumber;

        do {

            System.out.print(
                    "\nEnter Serial Number: ");

            serialNumber =
                    input.next();

            if (!controller.isValidSerialNumber(
                    serialNumber)) {

                System.out.println(
                        "Invalid Serial Number. Serial Number must contain 10 digits.");
            }

        } while (!controller.isValidSerialNumber(
                serialNumber));

        Toy toy =
                controller.searchBySerialNumber(
                        serialNumber);

        if (toy == null) {

            System.out.println(
                    "\nNo toy was found with that serial number.");

            return;
        }

        System.out.println(
                "\nToy Found:\n");

        System.out.println(toy);

        int option = 0;

        while (option != 1
                && option != 2) {

            System.out.println(
                    "\n(1) Remove Toy");

            System.out.println(
                    "(2) Cancel");

            System.out.print(
                    "\nEnter Option: ");

            if (input.hasNextInt()) {

                option =
                        input.nextInt();

            } else {

                input.next();

                System.out.println(
                        "\nInvalid option.");
            }

            if (option != 1
                    && option != 2) {

                System.out.println(
                        "\nInvalid option. Please enter 1 or 2.");
            }
        }

        if (option == 1) {

            if (controller.removeToy(toy)) {

                System.out.println(
                        "\nToy removed successfully.");

            } else {

                System.out.println(
                        "\nUnable to remove the toy.");
            }
        }
    }

    
    
    
    
    
    /**
     * Suggests toys using age, type, and price.
     */
    public void makeGiftSuggestion() {

        input.nextLine();

        System.out.println(
                "\nGift Suggestion");

        System.out.println(
                "Press Enter to leave a choice empty.\n");

        int age = -1;

        while (true) {

            System.out.print(
                    "Enter Recipient Age: ");

            String ageText =
                    input.nextLine().trim();

            if (ageText.isEmpty()) {
                break;
            }

            try {

                age =
                        Integer.parseInt(
                                ageText);

                if (age >= 0) {
                    break;
                }

                System.out.println(
                        "Age cannot be negative.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid age.");
            }
        }

        int type = 0;

        while (true) {

            System.out.println(
                    "\nToy Type:");

            System.out.println(
                    "(1) Figure");

            System.out.println(
                    "(2) Animal");

            System.out.println(
                    "(3) Puzzle");

            System.out.println(
                    "(4) Board Game");

            System.out.println(
                    "Press Enter for Any Type");

            System.out.print(
                    "Enter Type: ");

            String typeText =
                    input.nextLine().trim();

            if (typeText.isEmpty()) {

                type = 0;
                break;
            }

            try {

                type =
                        Integer.parseInt(
                                typeText);

                if (type >= 1
                        && type <= 4) {

                    break;
                }

                System.out.println(
                        "Invalid type. Please enter 1-4.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid type. Please enter 1-4.");
            }
        }

        double minPrice = -1;
        double maxPrice = -1;

        while (true) {

            System.out.print(
                    "\nEnter Minimum Price "
                    + "(Press Enter to skip price range): ");

            String minText =
                    input.nextLine().trim();

            if (minText.isEmpty()) {
                break;
            }

            try {

                minPrice =
                        Double.parseDouble(
                                minText);

                if (minPrice < 0) {

                    System.out.println(
                            "Price cannot be negative.");

                    minPrice = -1;
                    continue;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid price.");

                minPrice = -1;
                continue;
            }

            while (true) {

                System.out.print(
                        "Enter Maximum Price: ");

                String maxText =
                        input.nextLine().trim();

                try {

                    maxPrice =
                            Double.parseDouble(
                                    maxText);

                    if (maxPrice < minPrice) {

                        System.out.println(
                                "Maximum price cannot be less than minimum price.");

                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid price.");
                }
            }

            break;
        }

        if (age == -1
                && type == 0
                && minPrice == -1) {

            System.out.println(
                    "\nPlease enter at least one gift suggestion choice.");

            return;
        }

        ArrayList<Toy> results =
                controller.suggestGift(
                        age,
                        type,
                        minPrice,
                        maxPrice);

        if (results.size() > 0) {

            System.out.println(
                    "\nGift Suggestions:");

            displayResults(results);

            selectToyToPurchase(results);

        } else {

            System.out.println(
                    "\nNo gift suggestions matched your choices.");
        }
    }

    
    
    
    
    
    /**
     * Shows the search menu and handles the user's choice.
     */
    public void searchInventory() {

        int option = 0;

        while (option != 4) {

            option =
                    displaySearchMenu();

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
     * Starts the application and shows the main menu.
     */
    public void start() {

        int option = 0;

        while (option != 5) {

            option =
                    displayMainMenu();

            switch (option) {

                case 1:

                    searchInventory();
                    break;

                case 2:

                    addNewToy();
                    break;

                case 3:

                    removeToy();
                    break;

                case 4:

                    makeGiftSuggestion();
                    break;

                case 5:

                    controller.saveInventory();

                    System.out.println(
                            "Thank you for visiting Toy Store Company!");

                    System.out.println(
                            "Goodbye!");

                    break;

                default:

                    System.out.println(
                            "Invalid option. Please enter 1-5.");

                    break;
            }
        }
    }
}
