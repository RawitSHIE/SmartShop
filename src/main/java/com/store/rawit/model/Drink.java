package com.store.rawit.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message="name can\'t be null")
    @Size(max = 100)
    private String name;

    @NotNull(message="type can\'t be null")
    private String drinkType;

    @NotNull(message="price can\'t be null")
    private double price;

    public Drink(){}

    public Drink(Long id, String name, String drinkType, double price) {
        this.id = id;
        this.name = name;
        this.drinkType = drinkType;
        this.price = price;
    }

    public Long getId() {
        return this.id;
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
