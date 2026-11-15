
package mru.tsc.model;

/**
 * Represents a puzzle toy in the Toy Store Company inventory.
 * Extends the Toy class and includes an additional attribute
 * for the type of puzzle.
 */
public class Puzzle extends Toy {

    /**
     * The type of puzzle, such as Mechanical, Cryptic,
     * Logic, Trivia, or Riddle.
     */
    private String puzzleType;

    /**
     * Constructs a Puzzle object with the specified attributes.
     *
     * @param serialNumber the unique serial number of the toy
     * @param name the name of the puzzle
     * @param brand the brand of the puzzle
     * @param price the price of the puzzle
     * @param availableCount the quantity available in inventory
     * @param appropriateAge the recommended age for the puzzle
     * @param puzzleType the type of puzzle
     */
    public Puzzle(String serialNumber, String name, String brand,
                  double price, int availableCount, String appropriateAge,
                  String puzzleType) {

        super(serialNumber, name, brand, price, availableCount, appropriateAge);

        this.puzzleType = puzzleType;
    }

    /**
     * Returns the type of puzzle.
     *
     * @return the puzzle type
     */
    public String getPuzzleType() {
        return puzzleType;
    }

    /**
     * Returns a formatted String containing the puzzle's
     * category, serial number, name, brand, price,
     * available count, appropriate age, and puzzle type.
     *
     * @return a String representation of the puzzle toy
     */
    @Override
    public String toString() {
        return "Category: Puzzle"
            + "\nSerial Number: " + getSerialNumber()
            + "\nName: " + getName()
            + "\nBrand: " + getBrand()
            + "\nPrice: " + getPrice()
            + "\nAvailable Count: " + getAvailableCount()
            + "\nAge Appropriate: " + getAppropriateAge()
            + "\nPuzzle Type: " + puzzleType;
    }
}
