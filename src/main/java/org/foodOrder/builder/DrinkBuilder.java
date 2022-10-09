package org.foodOrder.builder;

import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;

public class DrinkBuilder implements Builder {
    Drink drink = new Drink();

    DrinkBuilder setDrink (DrinkItem drinkItem){
        drink.setDrinkItem(drinkItem);
        return this;
    }
    DrinkBuilder addAdditionalItem (DrinkAdditionalItem item){
        drink.getDrinkAdditionalItems().add(item);
        return this;
    }
    Drink build (){
        return drink;
    }
}
