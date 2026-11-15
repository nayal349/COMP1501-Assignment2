package mru.tsc.controller;

import mru.tsc.model.*;
import mru.tsc.exceptions.InvalidPriceException;
import mru.tsc.exceptions.InvalidPlayersException;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Manages the inventory for the Toy Store Company.
 * Loads toy records from a file and stores Figure, Animal,
 * Puzzle, and BoardGame objects in a single ArrayList.
 */
public class ToyStoreController {

    /**
     * The list containing all toys in the inventory.
     */
    private ArrayList<Toy> toys;

    /**
     * Constructs a ToyStoreController with an empty inventory.
     */
    public ToyStoreController() {
        toys = new ArrayList<>();
    }

    /**
     * Reads toy records from the toys.txt file and adds them
     * to the inventory.
     */
    public void loadInventory() {

        File file = new File("res/toys.txt");

        try (Scanner output = new Scanner(file)) {

            while (output.hasNextLine()) {

                String[] line = output.nextLine().split(";");

                if (line[0].charAt(0) == '0'
                        || line[0].charAt(0) == '1') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String appropriateAge = line[5];
                    String classification = line[6];

                    Figure figure = new Figure(
                            serialNumber, name, brand, price,
                            availableCount, appropriateAge,
                            classification);

                    toys.add(figure);

                } else if (line[0].charAt(0) == '2'
                        || line[0].charAt(0) == '3') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String appropriateAge = line[5];
                    String material = line[6];
                    String size = line[7];

                    Animal animal = new Animal(
                            serialNumber, name, brand, price,
                            availableCount, appropriateAge,
                            material, size);

                    toys.add(animal);

                } else if (line[0].charAt(0) == '4'
                        || line[0].charAt(0) == '5'
                        || line[0].charAt(0) == '6') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String appropriateAge = line[5];
                    String puzzleType = line[6];

                    Puzzle puzzle = new Puzzle(
                            serialNumber, name, brand, price,
                            availableCount, appropriateAge,
                            puzzleType);

                    toys.add(puzzle);

                } else if (line[0].charAt(0) == '7'
                        || line[0].charAt(0) == '8'
                        || line[0].charAt(0) == '9') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String appropriateAge = line[5];

                    String[] players = line[6].split("-");

                    int minPlayers = Integer.parseInt(players[0]);
                    int maxPlayers = Integer.parseInt(players[1]);
                    String designers = line[7];

                    BoardGame boardGame = new BoardGame(
                            serialNumber, name, brand, price,
                            availableCount, appropriateAge,
                            minPlayers, maxPlayers, designers);

                    toys.add(boardGame);

                } else {
                    System.out.println("Invalid Serial Number");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks if a serial number contains exactly 10 digits.
     *
     * @param serialNumber the serial number to validate
     * @return true if the serial number is valid, otherwise false
     */
    public boolean isValidSerialNumber(String serialNumber) {

        if (serialNumber.length() != 10) {
            return false;
        }

        for (int i = 0; i < serialNumber.length(); i++) {

            if (!Character.isDigit(serialNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether a serial number already exists.
     *
     * @param serialNumber the serial number to check
     * @return true if the serial number already exists
     */
    public boolean serialNumberExists(String serialNumber) {
        return searchBySerialNumber(serialNumber) != null;
    }

    /**
     * Searches for a toy using its serial number.
     *
     * @param serialNumber the serial number to search for
     * @return the matching Toy object, or null if not found
     */
    public Toy searchBySerialNumber(String serialNumber) {

        for (Toy toy : toys) {

            if (toy.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return toy;
            }
        }

        return null;
    }

    /**
     * Searches for toys containing the entered name.
     *
     * @param name the name or part of the name to search for
     * @return an ArrayList containing matching toys
     */
    public ArrayList<Toy> searchByName(String name) {

        ArrayList<Toy> results = new ArrayList<Toy>();

        for (Toy toy : toys) {

            if (toy.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(toy);
            }
        }

        return results;
    }

    /**
     * Searches for toys by type.
     *
     * @param type the toy type to search for
     * @return an ArrayList containing matching toys
     */
    public ArrayList<Toy> searchByType(int type) {

        ArrayList<Toy> results = new ArrayList<Toy>();

        for (Toy toy : toys) {

            if (type == 1 && toy instanceof Figure) {
                results.add(toy);

            } else if (type == 2 && toy instanceof Animal) {
                results.add(toy);

            } else if (type == 3 && toy instanceof Puzzle) {
                results.add(toy);

            } else if (type == 4 && toy instanceof BoardGame) {
                results.add(toy);
            }
        }

        return results;
    }

    /**
     * Searches for toys that match the gift suggestion choices.
     * A value of -1 means that filter was left empty.
     * A type of 0 means any toy type.
     *
     * @param age the recipient's age, or -1 for any age
     * @param type the toy type, or 0 for any type
     * @param minPrice the minimum price, or -1 for any price
     * @param maxPrice the maximum price, or -1 for any price
     * @return an ArrayList containing matching gift suggestions
     */
    public ArrayList<Toy> suggestGift(
            int age, int type, double minPrice, double maxPrice) {

        ArrayList<Toy> results = new ArrayList<Toy>();

        for (Toy toy : toys) {

            boolean matchesAge = true;
            boolean matchesType = true;
            boolean matchesPrice = true;

            if (age != -1) {

                String ageText = toy.getAppropriateAge()
                        .replace("+", "")
                        .trim();

                int toyAge = Integer.parseInt(ageText);

                matchesAge = age >= toyAge;
            }

            if (type != 0) {

                matchesType =
                        (type == 1 && toy instanceof Figure)
                        || (type == 2 && toy instanceof Animal)
                        || (type == 3 && toy instanceof Puzzle)
                        || (type == 4 && toy instanceof BoardGame);
            }

            if (minPrice != -1 && toy.getPrice() < minPrice) {
                matchesPrice = false;
            }

            if (maxPrice != -1 && toy.getPrice() > maxPrice) {
                matchesPrice = false;
            }

            if (matchesAge && matchesType && matchesPrice) {
                results.add(toy);
            }
        }

        return results;
    }

    /**
     * Purchases a toy if it is available.
     *
     * @param toy the toy being purchased
     * @return true if the purchase was successful
     */
    public boolean purchaseToy(Toy toy) {

        if (toy.getAvailableCount() > 0) {
            toy.setAvailableCount(toy.getAvailableCount() - 1);
            return true;
        }

        return false;
    }

    /**
     * Adds a new toy to the inventory.
     *
     * @param toy the toy to add
     */
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    /**
     * Removes a toy from the inventory.
     *
     * @param toy the toy to remove
     * @return true if the toy was removed
     */
    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    /**
     * Checks that the price is not negative.
     *
     * @param price the price to validate
     * @throws InvalidPriceException if the price is negative
     */
    public void validatePrice(double price)
            throws InvalidPriceException {

        if (price < 0) {
            throw new InvalidPriceException(
                    "Price cannot be negative.");
        }
    }

    /**
     * Checks that minimum players is not greater
     * than maximum players.
     *
     * @param minPlayers minimum number of players
     * @param maxPlayers maximum number of players
     * @throws InvalidPlayersException if minimum is greater
     */
    public void validatePlayers(int minPlayers, int maxPlayers)
            throws InvalidPlayersException {

        if (minPlayers > maxPlayers) {
            throw new InvalidPlayersException(
                    "Minimum players cannot be greater than maximum players.");
        }
    }

    /**
     * Saves all toys in the inventory back to toys.txt.
     */
    public void saveInventory() {

        File file = new File("res/toys.txt");

        try (PrintWriter writer = new PrintWriter(file)) {

            for (Toy toy : toys) {

                if (toy instanceof Figure) {

                    Figure figure = (Figure) toy;

                    writer.println(
                            figure.getSerialNumber() + ";"
                            + figure.getName() + ";"
                            + figure.getBrand() + ";"
                            + String.format("%.2f", figure.getPrice()) + ";"
                            + figure.getAvailableCount() + ";"
                            + figure.getAppropriateAge() + ";"
                            + figure.getClassification());

                } else if (toy instanceof Animal) {

                    Animal animal = (Animal) toy;

                    writer.println(
                            animal.getSerialNumber() + ";"
                            + animal.getName() + ";"
                            + animal.getBrand() + ";"
                            + String.format("%.2f", animal.getPrice()) + ";"
                            + animal.getAvailableCount() + ";"
                            + animal.getAppropriateAge() + ";"
                            + animal.getMaterial() + ";"
                            + animal.getSize());

                } else if (toy instanceof Puzzle) {

                    Puzzle puzzle = (Puzzle) toy;

                    writer.println(
                            puzzle.getSerialNumber() + ";"
                            + puzzle.getName() + ";"
                            + puzzle.getBrand() + ";"
                            + String.format("%.2f", puzzle.getPrice()) + ";"
                            + puzzle.getAvailableCount() + ";"
                            + puzzle.getAppropriateAge() + ";"
                            + puzzle.getPuzzleType());

                } else if (toy instanceof BoardGame) {

                    BoardGame boardGame = (BoardGame) toy;

                    writer.println(
                            boardGame.getSerialNumber() + ";"
                            + boardGame.getName() + ";"
                            + boardGame.getBrand() + ";"
                            + String.format("%.2f", boardGame.getPrice()) + ";"
                            + boardGame.getAvailableCount() + ";"
                            + boardGame.getAppropriateAge() + ";"
                            + boardGame.getMinPlayers() + "-"
                            + boardGame.getMaxPlayers() + ";"
                            + boardGame.getDesigners());
                }
            }

            System.out.println("\nInventory saved successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save inventory.");
        }
    }

    /**
     * Returns the list of toys currently stored.
     *
     * @return an ArrayList containing Toy objects
     */
    public ArrayList<Toy> getToys() {
        return toys;
    }
}
