package org.foodOrder.lunch.italianLunch;

import org.foodOrder.item.CourseItem;

public enum ItalianCourse implements CourseItem {
    PIZZA(10F);

    private Float price;

    ItalianCourse(Float price) {
        this.price = price;
    }

    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
