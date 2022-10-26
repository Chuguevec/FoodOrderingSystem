package org.foodOrder.view;

import org.foodOrder.cuisine.Cuisine;
import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;
import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.item.Item;
import org.foodOrder.item.PaidItem;
import org.foodOrder.lunch.Lunch;
import org.foodOrder.menu.Menu;
import org.foodOrder.order.Order;

import java.util.List;
import java.util.Scanner;

public class View {
    private static final String NOTHING = "0. Не нужно";
    private final Menu menu;
    private final Scanner scanner;

    public View() {
        menu = new Menu();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("Меню:");
        List<Cuisine> cuisines = menu.getCuisines();
        cuisines.forEach(this::printCuisineMenu);
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
        System.out.println("Сделайте ваш заказ");
        System.out.println("Выбирете кухню");
        System.out.println(NOTHING);
        List<Cuisine> cuisines = menu.getCuisines();
        for (int i = 0; i < cuisines.size(); i++) {
            System.out.println(i + 1 + ". " + cuisines.get(i).getName());
        }
    }

    public int getCuisineIndex() {
        int cuisineIndex = 0;
        int cuisineCount = menu.getCuisines().size();
        while (true) {
            System.out.println("Введите номер кухни!");
            if (scanner.hasNextInt()) {
                cuisineIndex = scanner.nextInt();
                if (cuisineIndex >= 0 && cuisineIndex <= cuisineCount + 1) {
                    break;
                }
            }
        }
        return cuisineIndex;
    }

    public int getCourseIndex(List<CourseItem> courses) {
        System.out.println("Выберите основное блюдо:");
        printPaidItem(courses);
        int courseIndex = 0;
        while (true) {
            System.out.println("Введите номер блюда");
            if (scanner.hasNextInt()) {
                courseIndex = scanner.nextInt();
                if (courseIndex > 0 && courseIndex <= courses.size()) {
                    break;
                }
            }
        }
        return courseIndex;
    }

    public int getDessertIndex(List<DesertItem> deserts) {
        System.out.println("Выберите десерт:");
        printPaidItem(deserts);
        int dessertIndex = 0;
        while (true) {
            System.out.println("Введите номер десерта");
            if (scanner.hasNextInt()) {
                dessertIndex = scanner.nextInt();
                if (dessertIndex > 0 && dessertIndex <= deserts.size()) {
                    break;
                }
            }
        }
        return dessertIndex;
    }

    public int getDrinkIndex(List<DrinkItem> drinks) {
        System.out.println("Выберите напиток:");
        System.out.println(NOTHING);
        printPaidItem(drinks);
        int drinkIndex = 0;
        while (true) {
            System.out.println("Введите номер напитка");
            if (scanner.hasNextInt()) {
                drinkIndex = scanner.nextInt();
                if (drinkIndex >= 0 && drinkIndex <= drinks.size()) {
                    break;
                }
            }
        }
        return drinkIndex;
    }

    public int getIndexAdditionalItem(List<DrinkAdditionalItem> additionalItems) {
        System.out.println("Вы можете добавить в напиток");
        System.out.println(NOTHING);
        printItem(additionalItems);
        int indexAdditionalItem = 0;
        while (true) {
            System.out.println("Введите номер добавки:");
            if (scanner.hasNextInt()) {
                indexAdditionalItem = scanner.nextInt();
                if (indexAdditionalItem >= 0 && indexAdditionalItem <= additionalItems.size() + 1) {
                    break;
                }
            }
        }
        return indexAdditionalItem;
    }

    public void printPaidItem(List<? extends PaidItem> items) {
        for (int i = 0; i < items.size(); i++) {
            PaidItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " " + item.getPrice());
        }
    }

    public void printItem(List<? extends Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName());
        }
    }

    public void printOrder(Order order) {
        Lunch lunch = order.getLunch();
        Drink drink = order.getDrink();
        System.out.println("Ваш Заказ:");
        double sumOrder = 0;
        if (lunch != null) {
            System.out.println(lunch.getCourse().getName());
            System.out.println(lunch.getDesert().getName());
            sumOrder += lunch.getCourse().getPrice() + lunch.getDesert().getPrice();
        }
        if (drink != null) {
            StringBuilder result = new StringBuilder();
            result.append(drink.getDrinkItem().getName());
            if (!drink.getDrinkAdditionalItems().isEmpty()) {
                for (DrinkAdditionalItem drinkAdditionalItem : drink.getDrinkAdditionalItems()) {
                    result.append(" c ").append(drinkAdditionalItem.getName());
                }
            }
            System.out.println(result);
            sumOrder += drink.getDrinkItem().getPrice();
        }
        System.out.println("Сумма заказа: " + sumOrder);
    }
}
