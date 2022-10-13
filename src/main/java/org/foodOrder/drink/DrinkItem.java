package org.foodOrder.drink;

import org.foodOrder.item.PaidItem;

public enum DrinkItem implements PaidItem {
    PEPSI(3F),
    TEA(2F),
    COFFEE(4F);

    private final Float price;

    DrinkItem(Float price) {
        this.price = price;
    }

    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
