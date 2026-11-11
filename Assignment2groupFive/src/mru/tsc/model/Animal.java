package mru.tsc.model;

public class Animal extends Toy {
	
	private String material;
	private String size;
	
	public Animal (String serialNumber, String name, String brand, double price, int availableCount, String appropriateAge, String material, String size) {
		super(serialNumber, name, brand, price, availableCount, appropriateAge);
		
		this.material = material;
		this.size = size;
		
		
	}
	
	public String getMaterial() {
		return material;
	}
	
	
	public String getSize() {
		return size;
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
	            +  "\nSize: " + size
	            + "\nMaterial: " + material;
	    }
	

}
