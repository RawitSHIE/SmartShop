package com.store.rawit;

import com.store.rawit.datasource.StoreDatasource;
import com.store.rawit.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class StoreFacade {
    @Autowired
    StoreDatasource storeDatasource = new StoreDatasource();

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
        return storeDatasource.getAllDrinks();
    }

    @RequestMapping(
            value = "storefacade/drink/type/{type}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Drink> getDrinkByType(@PathVariable String type) {
       return storeDatasource.getDrinkByType(type);
    }

    @RequestMapping(
            value = "storefacade/drink/id/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Drink getDrinkByID(@PathVariable Long id) {
        return storeDatasource.getDrinkByID(id);
    }

    @RequestMapping(
            value="storefacade/addDrink",
            method = RequestMethod.POST)
    Drink addDrink(@RequestBody Drink drink) {
        return storeDatasource.addDrink(drink);
    }

    @RequestMapping(
            value="storefacade/deleteDrink/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus
    Drink deleteDrink(@PathVariable Long id) {
      return storeDatasource.deleteDrink(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreFacade.class, args);
    }
}