# SmartShop
SOP Spring Boot Project

Topic : Smart Coffee Shop
>JSON Structure
```json
[
  {
    "ID" : interger,
    "name" : String,
    "drinkType": String,
    "price": double
  }
]
```
___

## GET

`GET .../` return API Documentation

`GET .../storefacade/allDrinks` return array of all drinks available in store datasource
```json
[
    {
        "ID": 0,
        "name": "Latté",
        "drinkType": "Coffee",
        "price": 200.0
    },
    {
        "ID": 1,
        "name": "Ceremel Moccheatto",
        "drinkType": "Coffee",
        "price": 220.0
    },
    {
        "ID": 2,
        "name": "White Chocolate Latté",
        "drinkType": "Coffee",
        "price": 220.0
    }
]
```

`GET ../storefacade/drink/{type}` return array of exact drink of that drink's type.

```json
[
    {
        "ID": 0,
        "name": "Latté",
        "drinkType": "Coffee",
        "price": 200.0
    },
    {
        "ID": 1,
        "name": "Ceremel Moccheatto",
        "drinkType": "Coffee",
        "price": 220.0
    },
    {
        "ID": 2,
        "name": "White Chocolate Latté",
        "drinkType": "Coffee",
        "price": 220.0
    }
]
```

`GET .../storefacade/drink/{id}` return json of exact drink containing {id}

> return json
```json
{
    "ID": 0,
    "name": "Latté",
    "drinkType": "Coffee",
    "price": 200.0
}
```

## POST
`POST .../storefacade/addDrink` add drink to store datasource

> request body
```json
{
	"name" : "Green Tea",
	"type" : "Tea",
	"price" : 150
}
```
> response message (success)
```
{drink's name} added.
```

## DELETE
`DELETE .../storefacade/deleteDrink/{id}` delete drink with specific id
>response message (success)
```
{drink's name} successfully deleted.
```
>response message {drink with {id} doesn't exist}
```
Drink doesn't exist.
```
