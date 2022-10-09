package org.foodOrder.lunch.italianLunch;

import org.foodOrder.item.DesertItem;

public enum ItalianDessert implements DesertItem {
    ITALIAN_DESSERT(5F);
    private Float price;

    ItalianDessert(float price) {
        this.price = price;
    }

    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
