package org.foodOrder.drink;

import java.util.List;

public class Drink {
    DrinkItem drinkItem;
    List<DrinkAdditionalItem> drinkAdditionalItems;

    public DrinkItem getDrinkItem() {
        return drinkItem;
    }

    public void setDrinkItem(DrinkItem drinkItem) {
        this.drinkItem = drinkItem;
    }

    public List<DrinkAdditionalItem> getDrinkAdditionalItems() {
        return drinkAdditionalItems;
    }
}
