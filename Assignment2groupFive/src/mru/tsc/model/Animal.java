
package mru.tsc.model;

/**
 * Represents an animal toy in the Toy Store Company inventory.
 * Extends the Toy class and includes additional attributes
 * for the animal's material and size.
 */
public class Animal extends Toy {

    /**
     * The material used to make the animal toy.
     */
    private String material;

    /**
     * The size of the animal toy.
     */
    private String size;

    /**
     * Constructs an Animal object with the specified attributes.
     *
     * @param serialNumber the unique serial number of the toy
     * @param name the name of the toy
     * @param brand the brand of the toy
     * @param price the price of the toy
     * @param availableCount the quantity available in inventory
     * @param appropriateAge the recommended age for the toy
     * @param material the material of the animal toy
     * @param size the size of the animal toy
     */
    public Animal(String serialNumber, String name, String brand,
                  double price, int availableCount, String appropriateAge,
                  String material, String size) {

        super(serialNumber, name, brand, price, availableCount, appropriateAge);

        this.material = material;
        this.size = size;
    }

    /**
     * Returns the material of the animal toy.
     *
     * @return the material of the animal toy
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Returns the size of the animal toy.
     *
     * @return the size of the animal toy
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns a formatted String containing the animal toy's
     * category, serial number, name, brand, price, available
     * count, appropriate age, size, and material.
     *
     * @return a String representation of the animal toy
     */
    @Override
    public String toString() {
        return "Category: Animal"
            + "\nSerial Number: " + getSerialNumber()
            + "\nName: " + getName()
            + "\nBrand: " + getBrand()
            + "\nPrice: " + getPrice()
            + "\nAvailable Count: " + getAvailableCount()
            + "\nAge Appropriate: " + getAppropriateAge()
            + "\nSize: " + size
            + "\nMaterial: " + material;
    }
}
