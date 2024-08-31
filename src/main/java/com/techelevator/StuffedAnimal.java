package com.techelevator;


import java.math.BigDecimal;

public class StuffedAnimal {
    private String keyPad;
    private String animalType;
    private BigDecimal price;
    private String sound;
    private String name;
    private int quantity;

    public StuffedAnimal(String keyPad, String animalType, BigDecimal price, String sound, String name) {
        this.keyPad = keyPad;
        this.animalType = animalType;
        this.price = price;
        this.sound = sound;
        this.name = name;
        this.quantity = 5;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSound() {
        return sound;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setKeypad(String keyPad) {
        this.keyPad = keyPad;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.name + " Quantity=" + this.quantity + " $" + this.price.toString();
    }
}










/*public class StuffedAnimal {
  private String keyPad;
  private String animalType;
  private BigDecimal price;
  private String sound;
  private  String name;


    public StuffedAnimal(String keyPad, String animalType, BigDecimal price, String sound,String name) {
        this.keyPad = keyPad;
        this.animalType = animalType;
        this.price = price;
        this.sound = sound;
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name + " Quantity=5" + " " + this.price.toString();
        //this.keyPad + " -" + this.animalType + " " + this.price.toString() + this.sound;
    }
}*/

// i am not sure we need a StuffedAnimal class any more

