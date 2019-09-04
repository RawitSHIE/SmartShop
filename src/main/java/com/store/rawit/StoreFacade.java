package com.store.rawit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class StoreFacade {

    StoreDatasource storeDatasource = new StoreDatasource();
    Gson gson = new Gson();

    @RequestMapping("/")
    String home() {
        return "API Documentation\n" +
                "GET ...storefacade/ => return list of all drinks in store\n" +
                "GET ...storefacade/drink/type/{type} => return exact type of drinks (Coffee, Smoothiee, Chocolate)\n" +
                "GET ...storefacade/drink/id/{id} => return exact drink of that id";
    }

    @RequestMapping(
            value = "storefacade/allDrinks",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getAllDrinks() {
        return gson.toJson(storeDatasource.getAllDrinks());
    }

    @RequestMapping(
            value = "storefacade/drink/type/{type}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getDrinkByType(@PathVariable String type) {
        return gson.toJson(this.storeDatasource.getDrinkByType(type));
    }

    @RequestMapping(
            value = "storefacade/drink/id/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getDrinkByID(@PathVariable int id) {
        return gson.toJson(this.storeDatasource.getDrinkByID(id));
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
