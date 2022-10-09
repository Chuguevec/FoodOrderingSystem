package org.foodOrder.lunch;

import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;

public class Lunch {
private CourseItem course;
private DesertItem desert;

    public CourseItem getCourse() {
        return course;
    }

    public void setCourse(CourseItem course) {
        this.course = course;
    }

    public DesertItem getDesert() {
        return desert;
    }

    public void setDesert(DesertItem desert) {
        this.desert = desert;
    }
}
