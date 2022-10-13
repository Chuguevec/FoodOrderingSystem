package org.foodOrder.drink;

import org.foodOrder.item.Item;

public enum DrinkAdditionalItem implements Item {
    LEMON("Лимон"),
    ICE_CUBE("Кубик льда");

    private String name;

    DrinkAdditionalItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
