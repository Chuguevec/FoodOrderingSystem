package org.foodOrder.lunch.polishLunch;

import org.foodOrder.item.CourseItem;

public enum PolishCourse implements CourseItem {
    PAPRIKASH(10F),
    CUTLET(8F);

    private Float price;

    PolishCourse (Float price) {
        this.price = price;
    }

    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
