package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleService{

    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Useless Vending Machine");
        System.out.println("You will find many uniquely useless Stuffed Animals");
        System.out.println("Good Luck!");
    }

    public static int inputStuffedAnimalOptions() {
        Scanner userInput = new Scanner(System.in);
        int selected = 0;

        while (selected < 1 || selected > 3) {
            System.out.println("Please make a selection:");
            System.out.println("1 -> Display Vending Machine Items");
            System.out.println("2 -> Purchase");
            System.out.println("3 -> Exit");

            try {
                selected = Integer.parseInt(userInput.nextLine());
                if (selected < 1 || selected > 3) {
                    System.out.println("Invalid selection. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Entry. Please enter a numeric value.");
            }
        }

        return selected;
    }

    public static void printInventory(VendingMachine vendingMachine) {
        System.out.println("Vending Machine Inventory:");
        for (Map.Entry<String, StuffedAnimal> entry : vendingMachine.getInventory().entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public static String printPurchaseOptions(VendingMachine vendingMachine) throws IOException {
        // Implement purchase options

        Scanner userInput = new Scanner(System.in);

        int selection = 0;

        while (selection != 3) {
            System.out.println("Current Money Provided: $" + vendingMachine.getVendingMachineBank().getBalance());
            System.out.println("Please make a selection:");
            System.out.println("1 -> Feed Money");
            System.out.println("2 -> Select Product");
            System.out.println("3 -> Finish Transaction");

            try {
                selection = Integer.parseInt(userInput.nextLine());
                switch (selection) {
                    case 1:
                        // Implement feed money option
                        int amountToAdd = getAmountToAdd(userInput);
                        vendingMachine.getVendingMachineBank().addFunds(new BigDecimal(amountToAdd));
                        return "FEED MONEY: " + "$" + amountToAdd + " " + "$" + vendingMachine.getVendingMachineBank().getBalance();
                    case 2:
                        // Implement select product option
                        return selectProduct(vendingMachine, userInput) + " " + "$" + vendingMachine.getVendingMachineBank().getBalance();
                        // returns the selectProduct method which returns " Animal Type / Quantity / price of animal" then added balance to show remaining amount
                    case 3:
                        // Implement finish transaction option
                        finishTransaction(vendingMachine);
                        return "GIVE CHANGE" + " " + "$" + vendingMachine.getVendingMachineBank().makeChange() + " " + "$0.00";
                        // added "Give Change" as a default string, makeChange() method to print the change being given, and String of 0.00 since it is always defaulted to 0 ( Could also probably use getBalance() here for less bugs)
                    default:
                        System.out.println("Invalid selection. Please enter 1, 2, or 3.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Entry. Please enter a numeric value.");
            }
        }
        return " End Of Transaction";
    }




    private static StuffedAnimal selectProduct(VendingMachine vendingMachine, Scanner userInput) {
        vendingMachine.displayItems();
        System.out.println("Enter the slot ID of the product you want to purchase:");
        String slotId = userInput.nextLine().toUpperCase();
        if (vendingMachine.isValidSlot(slotId)) {
            StuffedAnimal selectedProduct = vendingMachine.getInventory().get(slotId);
            if (selectedProduct != null) {
                if (selectedProduct.getQuantity() > 0) {
                    if (vendingMachine.getVendingMachineBank().getBalance().compareTo(selectedProduct.getPrice()) >= 0) {
                        vendingMachine.dispenseItem(slotId);
                    } else {
                        System.out.println("Insufficient funds. Please add more money.");
                    }
                } else {
                    System.out.println("Selected product is out of stock.");
                }
            } else {
                System.out.println("Invalid slot ID. Please enter a valid slot ID.");
            }
        } else {
            System.out.println("Invalid slot ID. Please enter a valid slot ID.");

        } return vendingMachine.getInventory().get(slotId);
    }


    private static int getAmountToAdd(Scanner userInput) {

            System.out.println("Enter the amount to add:");
            int amount = 0;
            try {
                amount = Integer.parseInt(userInput.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Entry. Please enter a numeric value.");
            }
            return amount;
    }


    private static void finishTransaction(VendingMachine vendingMachine) {
        String change = String.valueOf(vendingMachine.getVendingMachineBank().makeChange());
        System.out.println("Transaction complete. Change given: $" + change);
        System.out.println("Thanks for your Purchase!");
    }
}













