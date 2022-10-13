package org.foodOrder.builder;

import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.lunch.Lunch;

public class LunchBuilder implements Builder{
   private Lunch lunch = new Lunch();

   public LunchBuilder course (CourseItem courseItem){
        lunch.setCourse(courseItem);
        return this;
    }
   public LunchBuilder dessert (DesertItem desertItem){
        lunch.setDesert(desertItem);
        return this;
    }
    public Lunch build (){
        return lunch;
    }
}
