package mru.tsc.controller;
import mru.tsc.model.*;

import java.util.ArrayList;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ToyStoreController {
	
	private ArrayList <Toy> toys;
	
	
	
	
	
	
	public ToyStoreController () {
		toys = new ArrayList<>();
	}
	
	
	
	//make comments and java doc
	
	public void loadInventory () {
		


		File file = new File ("res/toys.txt");
	
		
		
		try (Scanner output = new Scanner(file)){
			
			while (output.hasNext()) {
				
				String [] line = output.nextLine().split(";");
				
				if (line[0].charAt(0) == '0' || line[0].charAt(0) == '1') {
					
					
					//converting string to needed objects
					
					String serialNumber = line[0];
					String name = line[1];
					String brand = line[2];
					double price = Double.parseDouble(line[3]);
					int availableCount = Integer.parseInt(line[4]);
					String apporpiateAge = line[5];
					String classification = line [6];

					
					Figure figure = new Figure (serialNumber, name, brand, price, availableCount, apporpiateAge, classification);
					
					//adding to arrayList
					toys.add(figure);
				
				}
				else if (line[0].charAt(0) == '2' || line[0].charAt(0) == '3') {
					
					//converting string to needed objects
					
					String serialNumber = line[0];
					String name = line[1];
					String brand = line[2];
					double price = Double.parseDouble(line[3]);
					int availableCount = Integer.parseInt(line[4]);
					String apporpiateAge = line[5];
					String material = line [6];
					String size = line [7];
					

					
					Animal animal = new Animal (serialNumber, name, brand, price, availableCount, apporpiateAge, material, size);
					
					//adding to arrayList
					toys.add(animal);
					
					
					
					
					
					
					
				}
				
				
				
				else if (line[0].charAt(0) == '4' || line[0].charAt(0) == '5' || line[0].charAt(0) == '6') {
					
					//converting string to needed objects
					
					String serialNumber = line[0];
					String name = line[1];
					String brand = line[2];
					double price = Double.parseDouble(line[3]);
					int availableCount = Integer.parseInt(line[4]);
					String apporpiateAge = line[5];
					String puzzleType = line [6];
					
					

					
					Puzzle puzzle = new Puzzle (serialNumber, name, brand, price, availableCount, apporpiateAge, puzzleType);
					
					//adding to arrayList
					toys.add(puzzle);

				
				
				
				
			
			}
				else if (line[0].charAt(0) == '7' || line[0].charAt(0) == '8' || line[0].charAt(0) == '9') {
					
					//converting string to needed objects
					
					String serialNumber = line[0];
					String name = line[1];
					String brand = line[2];
					double price = Double.parseDouble(line[3]);
					int availableCount = Integer.parseInt(line[4]);
					String apporpiateAge = line[5];
					
					
					
					
					//Separating min and max
					
					String [] players = line[6].split("-");
					
					
					int minPlayers = Integer.parseInt(players[0]);
					int maxPlayers = Integer.parseInt(players[1]);
					String designers = line[7];
					
					

					
					BoardGame boardGame = new BoardGame (serialNumber, name, brand, price, availableCount, apporpiateAge, minPlayers, maxPlayers, designers);
					
					//adding to arrayList
					toys.add(boardGame);

				
				
				
				
			
			}
				else {
					System.out.println("Invalid Serial Number");
				}
				
			
			
			
		
			
			
			
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
	
	
	
	}



	public ArrayList<Toy> getToys() {
		return toys;
	}



	

}
