package org.foodOrder.lunch.mexicanLunch;

import org.foodOrder.item.CourseItem;

public enum MexicanCourse implements CourseItem {
    BURRITO(5F),
    TACO(5F);

    private Float price;

    MexicanCourse(Float price) {
        this.price = price;
    }

    public String getName() {
        return name();
    }

    public Float getPrice() {
        return price;
    }
}
