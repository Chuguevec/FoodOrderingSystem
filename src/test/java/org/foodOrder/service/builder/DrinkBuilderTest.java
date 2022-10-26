package org.foodOrder.service.builder;

import org.foodOrder.builder.DrinkBuilder;
import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;
import org.foodOrder.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrinkBuilderTest {
    Drink drink = new Drink();
    Menu menu = new Menu();

    @Test
    public void setDrinkTest() {
        DrinkItem drinkItem = menu.getDrinks().get(0);
        Assertions.assertNull(drink.getDrinkItem());
        drink = new DrinkBuilder().setDrink(drinkItem).build();
        Assertions.assertEquals(drinkItem, drink.getDrinkItem());
    }
    @Test
    public void addAdditionalItemTest() {
        DrinkAdditionalItem drinkAdditionalItem = menu.getDrinkAdditionalItems().get(0);
        Assertions.assertTrue(drink.getDrinkAdditionalItems().isEmpty());
        drink = new DrinkBuilder().addAdditionalItem(drinkAdditionalItem).build();
        Assertions.assertEquals(drinkAdditionalItem, drink.getDrinkAdditionalItems().get(0));
    }

}
