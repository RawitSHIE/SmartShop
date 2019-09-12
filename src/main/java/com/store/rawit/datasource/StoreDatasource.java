package com.store.rawit.datasource;

import com.store.rawit.exception.NotFoundException;
import com.store.rawit.model.Drink;
import com.store.rawit.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreDatasource {

    @Autowired
    private StoreRepository storeRepository;

    public StoreDatasource() {}

    public List<Drink> getAllDrinks() {
        return storeRepository.findAll();
    }

    public List<Drink> getDrinkByType(String type) {
        List<Drink> drinksType = new ArrayList<>();

        storeRepository.findAll().forEach(drink -> {
            if (drink.getDrinkType().equals(type)) {
                drinksType.add(drink);
            }
        });

        return drinksType;
    }

    public Drink getDrinkByID(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id not found"));
    }

    public Drink addDrink(Drink drink) {
        return storeRepository.save(drink);
    }

    public Drink deleteDrink(Long id){
        return storeRepository.findById(id)
                .map(drink -> {
                    storeRepository.delete(drink);

                    return drink;
                })
                .orElseThrow(() -> new NotFoundException("id not found"));
    }
}
