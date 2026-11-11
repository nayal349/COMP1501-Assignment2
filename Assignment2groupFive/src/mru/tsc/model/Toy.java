package mru.tsc.model;

public abstract class Toy {
	private String serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availableCount;
	private String appropriateAge;
	
	public Toy(String serialNumber, String name, String brand,double price, int availableCount, String apporpiateAge){
		this.serialNumber =serialNumber;
		this.name =name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.appropriateAge = apporpiateAge;
		
		
	}
	
	
	
	//getters for the all the fields in this class
	public String getSerialNumber () {
		return serialNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrand () {
		return brand;
	}
	
	
	public double getPrice(){
		return price;
	}
	
	
	public int getAvailableCount() {
		return availableCount;
	}
	
	public String getAppropriateAge() {
		return appropriateAge;
	}
	
	
	
	//method for allowing stock update
	
	public void setAvailableCount (int count) {
		this.availableCount = count;
		
	}
	
	

}
