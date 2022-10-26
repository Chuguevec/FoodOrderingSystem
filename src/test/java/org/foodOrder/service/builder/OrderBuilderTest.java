package org.foodOrder.service.builder;

import org.foodOrder.builder.OrderBuilder;
import org.foodOrder.drink.Drink;
import org.foodOrder.lunch.Lunch;
import org.foodOrder.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderBuilderTest {
    Order order;

    @Test
    public void addLunchTest (){
        Lunch lunch = new Lunch();
        order = new OrderBuilder().lunch(lunch).build();
        Assertions.assertEquals(lunch, order.getLunch());
    }

    @Test
    public void addDrinkTest (){
        Drink drink = new Drink();
        order = new OrderBuilder().drink(drink).build();
        Assertions.assertEquals(drink, order.getDrink());
    }
}
