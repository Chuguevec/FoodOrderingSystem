package org.foodOrder.lunch.polishLunch;

import org.foodOrder.item.DesertItem;

public enum PolishDessert implements DesertItem {
    POLISH_DESSERT (5F);

    private Float price;
    PolishDessert (Float price){
        this.price = price;
    }
    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
