package org.foodOrder.builder;

import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;

public class DrinkBuilder implements Builder {
   private Drink drink = new Drink();

   public DrinkBuilder setDrink (DrinkItem drinkItem){
        drink.setDrinkItem(drinkItem);
        return this;
    }
   public DrinkBuilder addAdditionalItem (DrinkAdditionalItem item){
        drink.getDrinkAdditionalItems().add(item);
        return this;
    }
   public Drink build (){
        return drink;
    }
}
