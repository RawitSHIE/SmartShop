package com.store.rawit;

class Drink {
    private int ID;
    private String name;
    private String drinkType;
    private double price;

    public Drink(int ID, String name, String drinkType, double price) {
        this.ID = ID;
        this.name = name;
        this.drinkType = drinkType;
        this.price = price;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getDrinkType() {
        return this.drinkType;
    }

    public Double getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
