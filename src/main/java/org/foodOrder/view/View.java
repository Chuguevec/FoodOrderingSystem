package org.foodOrder.view;

import org.foodOrder.cuisine.Cuisine;
import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.item.Item;
import org.foodOrder.item.PaidItem;
import org.foodOrder.lunch.Lunch;
import org.foodOrder.menu.Menu;
import org.foodOrder.order.Order;

import java.util.List;

public class View {
    private final Menu menu;

    public View() {
        this.menu = new Menu();
    }

    public void showMenu() {
        System.out.println("Меню:");
        printCuisineMenu(menu.getItalianCuisine());
        printCuisineMenu(menu.getMexicanCuisine());
        printCuisineMenu(menu.getPolishCuisine());
        printDrinks();
    }

    private void printCuisineMenu(Cuisine cuisine) {
        System.out.println(cuisine.getName());
        System.out.println("Courses:");
        printPaidItem(cuisine.getCourses());
        System.out.println("Desserts:");
        printPaidItem(cuisine.getDeserts());
        System.out.println();
    }

    private void printDrinks() {
        System.out.println("Напитки:");
        printPaidItem(menu.getDrinks());
        System.out.println("К напиткам можно добавить:");
        printItem(menu.getDrinkAdditionalItems());
        System.out.println();
    }

    public void printCuisines() {
        System.out.println("1. " + menu.getItalianCuisine().getName());
        System.out.println("2. " + menu.getMexicanCuisine().getName());
        System.out.println("3. " + menu.getPolishCuisine().getName());
    }

    public void printPaidItem (List<? extends PaidItem> items) {
        for (int i = 0; i < items.size(); i++) {
            PaidItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " " + item.getPrice());
        }
    }

    public void printItem (List<? extends Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName());
        }
    }
    public void printOrder (Order order){
        Lunch lunch = order.getLunch();
        Drink drink = order.getDrink();
        System.out.println("Ваш Заказ:");
        double sumOrder = 0;
        if (lunch != null){
            System.out.println(lunch.getCourse().getName());
            System.out.println(lunch.getDesert().getName());
            sumOrder+= lunch.getCourse().getPrice() + lunch.getDesert().getPrice();
        }
        if (drink != null){
            StringBuilder result = new StringBuilder();
            result.append(drink.getDrinkItem().getName());
            if (!drink.getDrinkAdditionalItems().isEmpty()){
                for (DrinkAdditionalItem drinkAdditionalItem : drink.getDrinkAdditionalItems()) {
                    result.append(" c ").append(drinkAdditionalItem.getName());
                }
            }
            System.out.println(result);
            sumOrder+= drink.getDrinkItem().getPrice();
        }
        System.out.println("Сумма заказа: " + sumOrder);
    }
}
