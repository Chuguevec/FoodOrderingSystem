package org.foodOrder.lunch.italianLunch;

import org.foodOrder.item.CourseItem;

public enum ItalianCourse implements CourseItem {
    PIZZA("Pizza",10F);

    private Float price;
    private String name;

    ItalianCourse(String name, Float price) {
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
