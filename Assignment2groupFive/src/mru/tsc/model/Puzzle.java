package mru.tsc.model;

public class Puzzle  extends Toy{
	
	private  String puzzleType;
	

	public Puzzle (String serialNumber, String name, String brand, double price, int availableCount, String appropriateAge, String puzzleType) {
		super(serialNumber, name, brand, price, availableCount, appropriateAge);  
		
		this.puzzleType = puzzleType;
		
	}
	
	public String getPuzzleType() {
		return puzzleType;
	}
	
	
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
