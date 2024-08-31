package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Application {


	private Scanner userInput;
// This is the main entrance to this app
	public static void main(String[] args) throws IOException {
		int selection = 0;

		String logMessage = "";

		BasicLogger logger = new BasicLogger("src/logs", "Vending.log");


		VendingMachine vendingMachine = new VendingMachine();
		ConsoleService.printWelcomeMessage();

		while (selection != 3) {
			selection = ConsoleService.inputStuffedAnimalOptions();

			switch (selection) {
				case 1:
					ConsoleService.printInventory(vendingMachine);
					break;
				case 2:
					logMessage = ConsoleService.printPurchaseOptions(vendingMachine);
					logger.writeToLog(logMessage);
					break;
				case 3:
					System.out.println(vendingMachine.getVendingMachineBank().makeChange());
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
	}



	}





