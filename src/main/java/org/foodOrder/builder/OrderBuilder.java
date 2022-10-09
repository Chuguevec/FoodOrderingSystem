package org.foodOrder.builder;

import org.foodOrder.order.Order;
import org.foodOrder.drink.Drink;
import org.foodOrder.lunch.Lunch;

public class OrderBuilder implements Builder {
    private Order order = new Order();

    public OrderBuilder lunch(Lunch lunch) {
        order.setLunch(lunch);
        return this;
    }

    public OrderBuilder drink(Drink drink) {
        order.setDrink(drink);
        return this;
    }

    public Order build() {
        return order;
    }
}
