package com.store.rawit;

import java.util.*;

public class StoreDatasource {
    List<Drink> inStoreDrinks = new ArrayList<>();
    int runningID = 0;

    StoreDatasource() {
        this.addDrink("Latté", "Coffee", 200.0);
        this.addDrink("Ceremel Moccheatto", "Coffee", 220.0);
        this.addDrink("White Chocolate Latté", "Coffee", 220.0);
    }

    public List<Drink> getAllDrinks() {
        return inStoreDrinks;
    }

    public List<Drink> getDrinkByType(String type) {
        List<Drink> filterDrink = new ArrayList<>();

        for(Drink drink : this.inStoreDrinks) {
            if (type.equals(drink.getDrinkType())) {
                filterDrink.add(drink);
            }
        }

        return filterDrink;
    }

    public Drink getDrinkByID(int ID) {
        for(Drink drink : this.inStoreDrinks) {
            if (drink.getID() == ID) {
                return drink;
            }
        }

        return null;
    }

    public Drink addDrink(String name, String type, Double price) {
        Drink drink = new Drink(this.runningID, name, type, price);
        this.runningID++;
        inStoreDrinks.add(drink);

        return drink;
    }

    public Drink deleteDrink(int id){
        for (Iterator<Drink> drinks = inStoreDrinks.iterator(); drinks.hasNext();) {
            Drink drink = drinks.next();
            if (drink.getID() == id) {
                inStoreDrinks.remove(drink);
                return drink;
            }
        }

        return null;
    }
}
