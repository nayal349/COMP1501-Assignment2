package mru.tsc.model;

public class Figure extends Toy {
	
	private String classification; 
	

	public Figure(String serialNumber, String name, String brand, double price, int availableCount, String apporpiateAge, String classifcation) {
		super(serialNumber, name, brand, price, availableCount, apporpiateAge);
		this.classification = classifcation; 
		
		
	}
	
	public String getClassifcation () {
		return classification;
	}

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
