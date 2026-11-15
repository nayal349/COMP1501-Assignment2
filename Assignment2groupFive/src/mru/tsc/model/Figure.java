
package mru.tsc.model;

/**
 * Represents a figure toy in the Toy Store Company inventory.
 * Extends the Toy class and includes an additional attribute
 * for the figure's classification.
 */
public class Figure extends Toy {

    /**
     * The classification of the figure toy,
     * such as Action, Doll, or Historic.
     */
    private String classification;

    /**
     * Constructs a Figure object with the specified attributes.
     *
     * @param serialNumber the unique serial number of the toy
     * @param name the name of the figure
     * @param brand the brand of the figure
     * @param price the price of the figure
     * @param availableCount the quantity available in inventory
     * @param apporpiateAge the recommended age for the figure
     * @param classifcation the classification of the figure
     */
    public Figure(String serialNumber, String name, String brand,
                  double price, int availableCount, String apporpiateAge,
                  String classifcation) {

        super(serialNumber, name, brand, price, availableCount, apporpiateAge);
        this.classification = classifcation;
    }

    /**
     * Returns the classification of the figure toy.
     *
     * @return the classification of the figure
     */
    public String getClassifcation() {
        return classification;
    }

    /**
     * Returns a formatted String containing the figure's
     * category, serial number, name, brand, price,
     * available count, appropriate age, and classification.
     *
     * @return a String representation of the figure toy
     */
    @Override
    public String toString() {
        return "Category: Figure"
            + "\nSerial Number: " + getSerialNumber()
            + "\nName: " + getName()
            + "\nBrand: " + getBrand()
            + "\nPrice: " + getPrice()
            + "\nAvailable Count: " + getAvailableCount()
            + "\nAge Appropriate: " + getAppropriateAge()
            + "\nClassification: " + classification;
    }
}
