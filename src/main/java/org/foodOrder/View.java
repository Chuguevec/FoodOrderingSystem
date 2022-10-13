package org.foodOrder;

import org.foodOrder.cuisine.Cuisine;
import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.item.Item;
import org.foodOrder.item.PaidItem;
import org.foodOrder.menu.Menu;

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
        printPaidItem(cuisine.getCourses());
        printPaidItem(cuisine.getDeserts());
        System.out.println();
    }

    private void printDrinks() {
        System.out.println("Напитки:");
        printPaidItem(menu.getDrinks());
        System.out.println("К напиткам можно добавить:");
        menu.getDrinkAdditionalItems().forEach((value) -> System.out.println(value.getName()));
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
}
