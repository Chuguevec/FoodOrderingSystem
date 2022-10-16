package org.foodOrder.drink;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private DrinkItem drinkItem;
    private List<DrinkAdditionalItem> drinkAdditionalItems;

    public Drink() {
        drinkAdditionalItems = new ArrayList<>();
    }

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
