
package mru.tsc.controller;

import mru.tsc.model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
     *
     * Each record is separated by semicolons. The first digit
     * of the serial number determines which toy subclass
     * is instantiated.
     *
     * Displays an error message if the file cannot be found.
     */
    public void loadInventory() {

        File file = new File("res/toys.txt");

        try (Scanner output = new Scanner(file)) {

            while (output.hasNextLine()) {

                String[] line = output.nextLine().split(";");

                if (line[0].charAt(0) == '0' || line[0].charAt(0) == '1') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String apporpiateAge = line[5];
                    String classification = line[6];

                    Figure figure = new Figure(
                            serialNumber, name, brand, price,
                            availableCount, apporpiateAge, classification);

                    toys.add(figure);

                } else if (line[0].charAt(0) == '2' || line[0].charAt(0) == '3') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String apporpriateAge = line[5];
                    String material = line[6];
                    String size = line[7];

                    Animal animal = new Animal(
                            serialNumber, name, brand, price,
                            availableCount, apporpriateAge, material, size);

                    toys.add(animal);

                } else if (line[0].charAt(0) == '4'
                        || line[0].charAt(0) == '5'
                        || line[0].charAt(0) == '6') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String apporpiateAge = line[5];
                    String puzzleType = line[6];

                    Puzzle puzzle = new Puzzle(
                            serialNumber, name, brand, price,
                            availableCount, apporpiateAge, puzzleType);

                    toys.add(puzzle);

                } else if (line[0].charAt(0) == '7'
                        || line[0].charAt(0) == '8'
                        || line[0].charAt(0) == '9') {

                    String serialNumber = line[0];
                    String name = line[1];
                    String brand = line[2];
                    double price = Double.parseDouble(line[3]);
                    int availableCount = Integer.parseInt(line[4]);
                    String apporpiateAge = line[5];

                    String[] players = line[6].split("-");

                    int minPlayers = Integer.parseInt(players[0]);
                    int maxPlayers = Integer.parseInt(players[1]);
                    String designers = line[7];

                    BoardGame boardGame = new BoardGame(
                            serialNumber, name, brand, price,
                            availableCount, apporpiateAge,
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
    Searches for a toy using its serial number.
    *
    *@param serialNumber the serial number to search for
    *@return the matching Toy object, or null if not found
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
    *Searches for toys containing the entered name.
    *
    *@param name the name or part of the name to search for
    *@return an ArrayList containing matching toys
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
        *Searches for toys by type.
        *
        *@param type the toy type to search for
        *@return an ArrayList containing matching toys
        */
    public ArrayList<Toy> searchByType(int type) {
        
        ArrayList<Toy> results = new ArrayList<Toy>();

        for (Toy toy : toys) {

            if (type == 1 && toy instanceof Figure) {
                results.add(toy);
            }

            else if (type == 2 && toy instanceof Animal) {
                results.add(toy);
            }

            else if (type == 3 && toy instanceof Puzzle) {
                results.add(toy);
            }

            else if(type ==4 && toy instanceof BoardGame) {
                results.add(toy);
            }
        }

        return results;
    }

    /**
     * Returns the list of toys currently stored in the inventory.
     *
     * @return an ArrayList containing the Toy objects
     */
    public ArrayList<Toy> getToys() {
        return toys;
    }
}
