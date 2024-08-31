package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private final Map<String, StuffedAnimal> inventory = new HashMap<>();
    private final Bank vendingMachineBank = new Bank();

// This portion of the code read the user's input on the keyboard
    public VendingMachine() {
        String fileName = "vendingmachine.csv";
        File inputFile = new File(fileName);
        String[] inputString;
        try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                inputString = line.split(",");
                StuffedAnimal sf = new StuffedAnimal(inputString[0], inputString[3], new BigDecimal(inputString[2]), inputString[4], inputString[1]);
                inventory.put(inputString[0], sf);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
// This code displays the vending machine items
    public void displayItems() {
        for (Map.Entry<String, StuffedAnimal> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - $" + entry.getValue().getPrice());
        }
    }

    public boolean isValidSlot(String slotId) {
        return inventory.containsKey(slotId);
    }
// This code dispenses the vending machine items
    public void dispenseItem(String slotId) {
        StuffedAnimal item = inventory.get(slotId);
        System.out.println("Dispensing item: " + item.getName() + " - $" + item.getPrice());
        vendingMachineBank.addFunds(item.getPrice().negate());
        item.setQuantity(item.getQuantity() - 1);
        System.out.println(item.getSound());
    }



    public Map<String, StuffedAnimal> getInventory() {
        return inventory;
    }

    public Bank getVendingMachineBank() {
        return vendingMachineBank;
    }

    }
















/*
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    Map<String, StuffedAnimal> inventory = new HashMap<>();
    private  Bank vendingMachineBank = new Bank();

    public Bank getVendingMachineBank(){
        return vendingMachineBank;
    }

    public VendingMachine() {
        String fileName = "vendingMachine.csv";
        File inputFile = new File(fileName);
        String[] inputString;
        try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
            while(inputScanner.hasNextLine()){
                String line=inputScanner.nextLine();
                inputString = line.split(",");
                StuffedAnimal sf = new StuffedAnimal(inputString[0], inputString[3], new BigDecimal(inputString[2]), inputString[4], inputString[1]);
                //StuffedAnimal sf = new StuffedAnimal(inputString[0], inputString[3], new BigDecimal(inputString[2]), "Quack", "Duck");
                inventory.put(inputString[0],sf);
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }





    public Map<String, StuffedAnimal> getInventory()  {
        return inventory;
    }

} */

























