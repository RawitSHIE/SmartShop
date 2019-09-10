package com.store.rawit;

import com.store.rawit.exception.NotFoundException;
import com.store.rawit.model.Drink;
import com.store.rawit.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class StoreFacade {
//    TODO: Respository can't call in nested method will solve later
//    StoreDatasource storeDatasource = new StoreDatasource();

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping("/")
    String home() {
        return "API Documentation\n" +
                "GET .../storefacade/ => return list of all drinks in store\n" +
                "GET .../storefacade/drink/type/{type} => return exact type of drinks (Coffee, Smoothiee, Chocolate)\n" +
                "GET .../storefacade/drink/id/{id} => return exact drink of that id\n" +
                "POST .../storefacade/addDrink add drink to store datasource\n" +
                "DELETE .../storefacade/deleteDrink/{id}` delete drink with specific id\n";
    }

    @RequestMapping(
            value = "storefacade/allDrinks",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Drink> getAllDrinks() {
        return storeRepository.findAll();
    }

    @RequestMapping(
            value = "storefacade/drink/type/{type}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Drink> getDrinkByType(@PathVariable String type) {
        List<Drink> drinksType = new ArrayList<>();

        storeRepository.findAll().forEach(drink -> {
            if (drink.getDrinkType().equals(type)) {
                drinksType.add(drink);
            }
        });

        return drinksType;
    }

    @RequestMapping(
            value = "storefacade/drink/id/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Drink getDrinkByID(@PathVariable Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id not found"));
    }

    @RequestMapping(
            value="storefacade/addDrink",
            method = RequestMethod.POST)
    Drink addDrink(@RequestBody Drink drink) {
        Drink newDrink = drink;

        return storeRepository.save(newDrink);
    }
//    TODO DELETE METHOD
//    @DeleteMapping(
//            value="storefacade/deleteDrink/{id}")
//    String deleteDrink(@PathVariable int id) {
//        Drink drink = storeDatasource.deleteDrink(id);
//        if (drink == null) {
//            return "Drink doesn't exist.";
//        }
//
//        return drink.getName() + " successfully deleted.";
//    }

    public static void main(String[] args) {
        SpringApplication.run(StoreFacade.class, args);
    }
}