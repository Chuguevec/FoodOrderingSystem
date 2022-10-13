package org.foodOrder.service;

import org.foodOrder.View;
import org.foodOrder.builder.DrinkBuilder;
import org.foodOrder.builder.LunchBuilder;
import org.foodOrder.builder.OrderBuilder;
import org.foodOrder.cuisine.Cuisine;
import org.foodOrder.drink.Drink;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;
import org.foodOrder.item.CourseItem;
import org.foodOrder.item.DesertItem;
import org.foodOrder.lunch.Lunch;
import org.foodOrder.menu.Menu;
import org.foodOrder.order.Order;

import java.util.List;
import java.util.Scanner;


public class OrderService {

    private View view;
    private Menu menu;
    private Order order;
    private static final int CUISINE_COUNT = 3; // колличество кухонь
    private static final String NOTHING = "0. Не нужно";
    private final Scanner scanner = new Scanner(System.in);

    public OrderService() {
        view = new View();
        menu = new Menu();
    }

    public void makeOrder() {
        System.out.println("Сделайте ваш заказ");
        Cuisine cuisine = chooseCuisine();
        Lunch lunch = cuisine == null ? null : chooseLunch(cuisine);
        Drink drink = chooseDrink();
    }


    private Cuisine chooseCuisine() {
        System.out.println("Выбирете кухню");
        System.out.println(NOTHING);
        view.printCuisines();
        int cuisineCount = 0;
        while (true) {
            System.out.println("Введите номер кухни!");
            if (scanner.hasNextInt()) {
                cuisineCount = scanner.nextInt();
                if (cuisineCount >= 0 && cuisineCount <= CUISINE_COUNT) {
                    break;
                }
            }
        }
        switch (cuisineCount) {
            case 1 -> {
                return menu.getItalianCuisine();
            }
            case 2 -> {
                return menu.getMexicanCuisine();
            }
            case 3 -> {
                return menu.getPolishCuisine();
            }
        }
        return null;
    }

    private Lunch chooseLunch(Cuisine cuisine) {
        CourseItem course = chooseCourse(cuisine);
        DesertItem desert = chooseDessert(cuisine);
        return new LunchBuilder().course(course).dessert(desert).build();
    }

    private CourseItem chooseCourse(Cuisine cuisine) {
        System.out.println("Выберите основное блюдо:");
        List<CourseItem> courses = cuisine.getCourses();
        view.printPaidItem(courses);
        int courseCount = 0;
        while (true) {
            System.out.println("Введите номер блюда");
            if (scanner.hasNextInt()) {
                courseCount = scanner.nextInt();
                if (courseCount > 0 && courseCount <= courses.size()) {
                    break;
                }
            }
        }
        return courses.get(courseCount - 1);
    }

    private DesertItem chooseDessert(Cuisine cuisine) {
        System.out.println("Выберите десерт:");
        List<DesertItem> deserts = cuisine.getDeserts();
        view.printPaidItem(deserts);
        int dessertCount = 0;
        while (true) {
            System.out.println("Введите номер десерта");
            if (scanner.hasNextInt()) {
                dessertCount = scanner.nextInt();
                if (dessertCount > 0 && dessertCount <= deserts.size()) {
                    break;
                }
            }
        }
        return deserts.get(dessertCount - 1);
    }

    private Drink chooseDrink() {
        DrinkItem drinkItem = chooseDrinkItem();
        if(drinkItem != null){
            List <DrinkAdditionalItem> additionalItem = chooseAdditionalItem();
            DrinkBuilder drinkBuilder = new DrinkBuilder().setDrink(drinkItem);
            if(additionalItem != null && !additionalItem.isEmpty()){
                for (DrinkAdditionalItem item : additionalItem) {
                    drinkBuilder.addAdditionalItem(item);
                }
            }
           return drinkBuilder.build();
        }
        return null;
    }

    private DrinkItem chooseDrinkItem() {
        System.out.println("Выберите напиток:");
        List<DrinkItem> drinks = menu.getDrinks();
        System.out.println(NOTHING);
        view.printPaidItem(drinks);
        int drinkCount = 0;
        while (true) {
            System.out.println("Введите номер напитка");
            if (scanner.hasNextInt()) {
                drinkCount = scanner.nextInt();
                if (drinkCount >= 0 && drinkCount <= drinks.size()) {
                    break;
                }
            }
        }
        return drinkCount == 0 ? null : drinks.get(drinkCount - 1);
    }

    private List<DrinkAdditionalItem> chooseAdditionalItem() {
        System.out.println("Вы можете добавить в напиток");
        List<DrinkAdditionalItem> additionalItems = menu.getDrinkAdditionalItems();
        System.out.println(NOTHING);
        view.printItem(additionalItems);
        int count = 0;
        while (true) {
            System.out.println("Введите номер добавки:");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count >= 0 && count <= additionalItems.size()) {
                    break;
                }
            }
        }
        switch (count){
            case (1) : {
                return List.of(DrinkAdditionalItem.LEMON);
            }
            case (2) : {
                return List.of(DrinkAdditionalItem.ICE_CUBE);
            }
            case (3) : {
                return List.of(DrinkAdditionalItem.ICE_CUBE, DrinkAdditionalItem.LEMON);
            }
        }
        return null;
    }

}
