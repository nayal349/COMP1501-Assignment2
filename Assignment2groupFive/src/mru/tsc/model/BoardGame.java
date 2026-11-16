
package mru.tsc.model;

/**
 * Represents a board game in the Toy Store Company inventory.
 * Extends the Toy class and includes additional attributes
 * for the minimum and maximum number of players and designers.
 */
public class BoardGame extends Toy {

    /**
     * The minimum number of players required to play the board game.
     */
    private int minPlayers;

    /**
     * The maximum number of players allowed to play the board game.
     */
    private int maxPlayers;

    /**
     * The designer or designers of the board game.
     */
    private String designers;

    /**
     * Constructs a BoardGame object with the specified attributes.
     *
     * @param serialNumber the unique serial number of the toy
     * @param name the name of the board game
     * @param brand the brand of the board game
     * @param price the price of the board game
     * @param availableCount the quantity available in inventory
     * @param appropriateAge the recommended age for the board game
     * @param minPlayers the minimum number of players
     * @param maxPlayers the maximum number of players
     * @param designers the designer or designers of the board game
     */
    public BoardGame(String serialNumber, String name, String brand,
                     double price, int availableCount, String appropriateAge,
                     int minPlayers, int maxPlayers, String designers) {

        super(serialNumber, name, brand, price, availableCount, appropriateAge);

        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.designers = designers;
    }

    /**
     * Returns the minimum number of players required for the board game.
     * @return the minimum number of players
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Returns the maximum number of players allowed for the board game.
     * @return the maximum number of players
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Returns the designer or designers of the board game.
     * @return the designers of the board game
     */
    public String getDesigners() {
        return designers;
    }

    /**
     * Returns a formatted String containing the board game's
     * category, serial number, name, brand, price, available count,
     * appropriate age, player range, and designers.
     *
     * @return a String representation of the board game
     */
    @Override
    public String toString() {
        return "Category: BoardGame"
            + "\nSerial Number: " + getSerialNumber()
            + "\nName: " + getName()
            + "\nBrand: " + getBrand()
            + "\nPrice: " + getPrice()
            + "\nAvailable Count: " + getAvailableCount()
            + "\nAge Appropriate: " + getAppropriateAge()
            + "\nPlayers: " + minPlayers + "-" + maxPlayers
            + "\nDesigners: " + designers;
    }
}
