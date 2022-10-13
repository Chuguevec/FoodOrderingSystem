package org.foodOrder;

import org.foodOrder.service.OrderService;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.showMenu();
        OrderService orderService = new OrderService();
        orderService.makeOrder();


    }
}
