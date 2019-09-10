package com.store.rawit.datasource;

import com.store.rawit.model.Drink;
import com.store.rawit.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class StoreDatasource {

    @Autowired
    private StoreRepository storeRepository;

    public StoreDatasource() {

    }


    public List<Drink> getAllDrinks() {
        System.out.println(storeRepository.findAll());
        return storeRepository.findAll();

    }

    public List<Drink> getDrinkByType(String type) {
        List<Drink> filterDrink = new ArrayList<>();

        for(Drink drink : storeRepository.findAll()) {
            if (type.equals(drink.getDrinkType())) {
                filterDrink.add(drink);
            }
        }

        return filterDrink;
    }

//    public Drink getDrinkByID(Long id) {
//        return storeRepository.findById(id);
//    }

    public Drink addDrink(Drink drink) {
        return storeRepository.save(drink);
    }

//    public Drink deleteDrink(int id){
//
//    }
}
