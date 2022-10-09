package org.foodOrder.cuisine;

import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import java.util.List;

public abstract class Cuisine {
    private List <CourseItem> courses;
    private List<DesertItem> deserts;
    private String name;

    public Cuisine(List<CourseItem> courses, List<DesertItem> deserts, String name) {
        this.courses = courses;
        this.deserts = deserts;
        this.name = name;
    }

    public List<CourseItem> getCourses() {
        return courses;
    }

    public List<DesertItem> getDeserts() {
        return deserts;
    }

    public String getName() {
        return name;
    }
}
