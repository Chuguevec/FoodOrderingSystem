package org.foodOrder.drink;

import org.foodOrder.item.Item;

public enum DrinkAdditionalItem implements Item {
    LEMON,
    ICE_CUBE;

    public String getName() {
        return name();
    }
}
