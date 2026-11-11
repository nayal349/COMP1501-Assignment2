package mru.tsc.application;
import mru.tsc.model.*;
import mru.tsc.controller.*;

public class App {
	 public static void main (String[] args) {
		 
		 ToyStoreController t = new ToyStoreController ();
		 
		 t.loadInventory();
		 
		 System.out.println("Total toys loaded: "
	                + t.getToys().size());
		 
		 
		 
		 
		 for (Toy toy : t.getToys()) {

	            System.out.println("--------------------");
	            System.out.println(toy);
	        }

		 
		 
		
	 }

}
