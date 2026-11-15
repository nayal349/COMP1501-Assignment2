
package mru.tsc.model;

/**
 * Represents a general toy in the Toy Store Company inventory.
 * This abstract class contains the common attributes and methods
 * shared by Figure, Animal, Puzzle, and BoardGame objects.
 */
public abstract class Toy {

    /**
     * The unique serial number of the toy.
     */
    private String serialNumber;

    /**
     * The name of the toy.
     */
    private String name;

    /**
     * The brand of the toy.
     */
    private String brand;

    /**
     * The price of the toy.
     */
    private double price;

    /**
     * The number of units currently available in inventory.
     */
    private int availableCount;

    /**
     * The recommended age for the toy.
     */
    private String appropriateAge;

    /**
     * Constructs a Toy object with the specified attributes.
     *
     * @param serialNumber the unique serial number of the toy
     * @param name the name of the toy
     * @param brand the brand of the toy
     * @param price the price of the toy
     * @param availableCount the quantity available in inventory
     * @param apporpiateAge the recommended age for the toy
     */
    public Toy(String serialNumber, String name, String brand,
               double price, int availableCount, String apporpiateAge) {

        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.availableCount = availableCount;
        this.appropriateAge = apporpiateAge;
    }

    /**
     * Returns the unique serial number of the toy.
     *
     * @return the serial number of the toy
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Returns the name of the toy.
     *
     * @return the name of the toy
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the brand of the toy.
     *
     * @return the brand of the toy
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the price of the toy.
     *
     * @return the price of the toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the number of units available in inventory.
     *
     * @return the available quantity of the toy
     */
    public int getAvailableCount() {
        return availableCount;
    }

    /**
     * Returns the recommended age for the toy.
     *
     * @return the appropriate age for the toy
     */
    public String getAppropriateAge() {
        return appropriateAge;
    }

    /**
     * Updates the number of units available in inventory.
     *
     * @param count the new available quantity of the toy
     */
    public void setAvailableCount(int count) {
        this.availableCount = count;
    }
}
