package org.foodOrder;

import org.foodOrder.service.OrderService;
import org.foodOrder.view.View;

public class Main {
    public static void main(String[] args) {
    View view = new View();
    OrderService orderService = new OrderService();
    view.showMenu();
    orderService.makeOrder();
    }
}
