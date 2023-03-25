package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class VendingMachineCLI {


	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		Map<String, Integer> inventory = new HashMap<>();
		List<String> slots = new ArrayList<>();
		List<BigDecimal> prices = new ArrayList();
		List<StuffedAnimals> animals = new ArrayList<>();
		MoneyHolder money = new MoneyHolder();
		Menus menu = new Menus(); // Menu's which hold user choices

		String outputFile = "Log.txt"; // Creates the output file path for the log file.
		File logFile = new File(outputFile); // Creates the log file object to be printed to.


		try (PrintWriter writer = new PrintWriter(new FileOutputStream("C:/Users/Student/workspace/Capstone 1/java-minicapstonemodule1-team4/log.txt", true))){
			writer.println(String.valueOf(LocalDateTime.now()).substring(0,10));
			writer.println(String.valueOf(LocalDateTime.now()).substring(11,19));
			String inputFile = "vendingmachine.csv";
			File file = new File(inputFile);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				StuffedAnimals animal = new StuffedAnimals();
				String line = scanner.nextLine();
				String[] splitLines = line.split("\\|");
				slots.add(splitLines[0]);
				prices.add(new BigDecimal(splitLines[2]));
				animal.setName(splitLines[1]);
				animal.setType(splitLines[3]);
				animals.add(animal);
			}
			for (int i = 0; i < slots.size(); i++) {
				inventory.put(slots.get(i), 5);
			}

			menu.getMainMenu(); // Display main menu and loop through menus depending on user choice.
			String mainChoice = scan.nextLine();
			do {
				if (mainChoice.equals("1")) {
					for (int i = 0; i < animals.size() && i < slots.size() && i < prices.size() && i < inventory.size(); i++) {
						StuffedAnimals currentAnimal = animals.get(i);
						System.out.println((slots.get(i) + " " + prices.get(i) + " " + currentAnimal.getName()) + " " + inventory.get(slots.get(i)));
					}
					menu.getMainMenu();
					mainChoice = scan.nextLine();
				}
				if (mainChoice.equals("2")) {
					menu.getPurchaseMenu();
					String purchaseChoice = scan.nextLine();

					if (purchaseChoice.equals("1")) { // we will increase balance based on user input and store in money class.
						System.out.println("How much Money are you Inserting?");
						String monies = scan.nextLine(); // user inputs amount of money
						BigDecimal addedMoney = new BigDecimal(monies);
						money.setBalance(money.getBalance().add(addedMoney));// Stores Balance
						writer.println( "FEED MONEY: " + monies + " " + money.getBalance());
								menu.getPurchaseMenu();
								purchaseChoice = scan.nextLine();
					}
					if (purchaseChoice.equals("2")) {

						System.out.println("" +
								"\nyou have $" + money.getBalance() + " left.");
						System.out.println("What Animal Would you like?");
						for (int i = 0; i < animals.size() && i < slots.size() && i < prices.size() && i < inventory.size(); i++) {
							StuffedAnimals currentAnimal = animals.get(i);
							System.out.println((slots.get(i) + " " + prices.get(i) + " " + currentAnimal.getName()) + " " + inventory.get(slots.get(i)));
						}
						System.out.println("Choose Your Stuffed Animal");
						String itemChoice = scan.nextLine(); // user selects item based on slot number.

						for (int i = 0; i < slots.size() && i < prices.size() && i < inventory.size() && i < animals.size(); i++) {

							if (itemChoice.equalsIgnoreCase(slots.get(i)) && (money.getBalance().compareTo(prices.get(i)) > 0)) {
								money.setBalance(money.getBalance().subtract(prices.get(i))); // Subtracts price of item from balance.
								int amount = inventory.get(slots.get(i)); // creates a variable to get the inventory from a particular slot.
								inventory.put(slots.get(i), amount - 1); // removes one item from inventory
								StuffedAnimals currentAnimal = animals.get(i); // creates a variable for the current animal in the slot.
								System.out.println("You just spent $" + prices.get(i) + " on a " + currentAnimal.getName() +
										"\nyou now have $" + money.getBalance() + " remaining." +
										"\n" + currentAnimal.getSound());
								System.out.println(slots.get(i) + " Inventory Remaining: " + inventory.get(slots.get(i)));
								writer.println(LocalDateTime.now() + " " + animals.get(i) + " " + slots.get(i) + " " +
										prices.get(i) + " " + money.getBalance());
							} else if (!(money.getBalance().compareTo(prices.get(i)) > 0.00)) {
								System.out.println("Not Enough Money... Please Try Again");
							} else if (inventory.get(slots.get(i)).equals(0)){
								System.out.println("Sorry this product is sold out");
//							} else if (itemChoice.isEmpty() || itemChoice.isBlank()){
////								System.out.println("Sorry that product doesn't exist");
//								throw new IOException("This product is sold out");
							}
//							else System.out.println("Sorry that product doesn't exist");
						}
						menu.getPurchaseMenu();
						purchaseChoice = scan.nextLine();
					}

					if (purchaseChoice.equals("3")) {

						System.out.println("Your Remaining Balance is " + money.getBalance());
						System.out.println("Here is your Change: ");
						BigDecimal pennyMultiplier = new BigDecimal(100);
						int currentChange = money.getBalance().multiply(pennyMultiplier).intValue();
						double change = money.getBalance().doubleValue();

						while (currentChange > 0) {

							int quarter, dime, nickel, penny;

							quarter = currentChange / 25;
							currentChange = currentChange % 25;

							dime = currentChange / 10;
							currentChange = currentChange % 10;

							nickel = currentChange / 5;
							currentChange = currentChange % 5;

							penny = currentChange;

							money.setBalance(money.getBalance().subtract(money.getBalance()));

							System.out.println(quarter + " quarters");
							System.out.println(dime + " dimes");
							System.out.println(nickel + " nickles");
							System.out.println(penny + " pennies");// Return change in coins.
							System.out.println("Final balance is " + money.getBalance());
						}
						menu.getMainMenu();
						mainChoice = scan.nextLine();
					}
				}
				if (mainChoice.equals("3")) {
					System.out.println("Thank you for using our Vending Machine");
					System.exit(1);
				}
			} while (!(mainChoice.equalsIgnoreCase("3")));
		} catch(IOException e){
			System.out.println("oops you just broke me :( ");

		}
	}
}

