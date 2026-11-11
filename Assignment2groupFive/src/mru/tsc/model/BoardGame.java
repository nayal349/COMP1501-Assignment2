
package mru.tsc.model;

public class BoardGame extends Toy {

    private int minPlayers;
    private int maxPlayers;
    private String designers;

    public BoardGame(String serialNumber, String name, String brand, double price, int availableCount, String appropriateAge, int minPlayers, int maxPlayers,String designers) {

        super(serialNumber, name, brand, price, availableCount, appropriateAge);

        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.designers = designers;
    }
    
    
    

    public int getMinPlayers() {
        return minPlayers;
    }

    
    
    public int getMaxPlayers() {
        return maxPlayers;
    }
    
    

    public String getDesigners() {
        return designers;
    }
    
    
    

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
