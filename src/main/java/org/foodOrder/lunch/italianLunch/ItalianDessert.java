package org.foodOrder.lunch.italianLunch;

import org.foodOrder.item.DesertItem;

public enum ItalianDessert implements DesertItem {
    ITALIAN_DESSERT("Italian Dessert", 5F);
    private Float price;
    private String name;

    ItalianDessert(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}
