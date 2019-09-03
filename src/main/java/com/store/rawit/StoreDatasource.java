package com.store.rawit;

import java.util.*;

public class StoreDatasource {
    List<Drink> inStoreDrinks = new ArrayList<>();

    StoreDatasource() {
        inStoreDrinks.add(new Drink(1, "Latté", "Coffee", 200));
        inStoreDrinks.add(new Drink(2, "Ceremel Moccheatto", "Coffee", 220));
        inStoreDrinks.add(new Drink(3, "White Chocolate Latté", "Coffee", 220));
    }

    List<Drink> getAllDrinks() {
        return inStoreDrinks;
    }

    List<Drink> getDrinkByType(String type) {
        List<Drink> filterDrink = new ArrayList<>();

        for(Drink drink : this.inStoreDrinks) {
            if (type.equals(drink.getDrinkType())) {
                filterDrink.add(drink);
            }
        }

        return filterDrink;
    }

    Drink getDrinkByID(int ID) {
        for(Drink drink : this.inStoreDrinks) {
            if (drink.getID() == ID) {
                return drink;
            }
        }

        return null;
    }
}
