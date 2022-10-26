package org.foodOrder.service.builder;

import org.foodOrder.builder.LunchBuilder;
import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.lunch.Lunch;
import org.foodOrder.lunch.italianLunch.ItalianCourse;
import org.foodOrder.lunch.italianLunch.ItalianDessert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LunchBuilderTest {
    Lunch lunch;

    @Test
    public void addCourseTest (){
        CourseItem course = ItalianCourse.PIZZA;
        lunch = new LunchBuilder().course(course).build();
        Assertions.assertNotNull(lunch);
        Assertions.assertEquals(course, lunch.getCourse());
    }

    @Test
    public void addDessertTest (){
        DesertItem dessert = ItalianDessert.ITALIAN_DESSERT;
        lunch = new LunchBuilder().dessert(dessert).build();
        Assertions.assertNotNull(lunch);
        Assertions.assertEquals(dessert, lunch.getDesert());
    }
}
