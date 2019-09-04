package com.store.rawit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SpringBootApplication
@RestController
public class StoreFacade {

    StoreDatasource storeDatasource = new StoreDatasource();

    @RequestMapping("/")
    String home() {
        return "API Documentation\n" +
                "GET ...storefacade/ => return list of all drinks in store\n" +
                "GET ...storefacade/drink/type/{type} => return exact type of drinks (Coffee, Smoothiee, Chocolate)\n" +
                "GET ...storefacade/drink/id/{id} => return exact drink of that id\n" +
                "POST .../storefacade/addDrink add drink to store datasource\n" +
                "DELETE .../storefacade/deleteDrink/{id}` delete drink with specific id\n";
    }

    @RequestMapping(
            value = "storefacade/allDrinks",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Drink> getAllDrinks() {
        return this.storeDatasource.getAllDrinks();
    }

    @RequestMapping(
            value = "storefacade/drink/type/{type}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Drink> getDrinkByType(@PathVariable String type) {
        return this.storeDatasource.getDrinkByType(type);
    }

    @RequestMapping(
            value = "storefacade/drink/id/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Drink getDrinkByID(@PathVariable int id) {
        return this.storeDatasource.getDrinkByID(id);
    }

    @PostMapping(
            value="storefacade/addDrink")
    String addDrink(@RequestBody Drink drink) {
        Drink addedDrink = storeDatasource.addDrink(
                drink.getName(),
                drink.getDrinkType(),
                drink.getPrice()
        );

        return addedDrink.getName() + " added";
    }

    @DeleteMapping(
            value="storefacade/deleteDrink/{id}")
    String deleteDrink(@PathVariable int id) {
        Drink drink = storeDatasource.deleteDrink(id);
        if (drink == null) {
            return "Drink doesn't exist.";
        }

        return drink.getName() + " successfully deleted.";
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreFacade.class, args);
    }
}
