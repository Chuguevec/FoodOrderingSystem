package org.foodOrder.lunch.mexicanLunch;

import org.foodOrder.item.DesertItem;

public enum MexicanDessert implements DesertItem {
    MEXICAN_DESSERT (5F),
    MEXICAN_DESSERT2 (3F);

    private Float price;
    MexicanDessert (Float price){
        this.price = price;
    }
    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
