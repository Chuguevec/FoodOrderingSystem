package org.foodOrder.builder;

import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.lunch.Lunch;

public class LunchBuilder implements Builder{
    Lunch lunch = new Lunch();

    LunchBuilder course (CourseItem courseItem){
        lunch.setCourse(courseItem);
        return this;
    }
    LunchBuilder dessert (DesertItem desertItem){
        lunch.setDesert(desertItem);
        return this;
    }
    Lunch build (){
        return lunch;
    }
}
