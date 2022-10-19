package org.foodOrder.service;

import org.foodOrder.view.View;
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

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private View view;
    private Menu menu;
    private Order order;

    public OrderService() {
        view = new View();
        menu = new Menu();
    }

    public void makeOrder() {
        Cuisine cuisine = chooseCuisine();
        Lunch lunch = cuisine == null ? null : chooseLunch(cuisine);
        Drink drink = chooseDrink();
        order = new OrderBuilder().lunch(lunch).drink(drink).build();
        view.printOrder(order);
    }

    private Cuisine chooseCuisine() {
        view.printCuisines();
        int cuisineCount = view.getCuisineIndex();
        return cuisineCount == 0 ? null : menu.getCuisines().get(cuisineCount - 1);
    }

    private Lunch chooseLunch(Cuisine cuisine) {
        CourseItem course = chooseCourse(cuisine);
        DesertItem desert = chooseDessert(cuisine);
        return new LunchBuilder().course(course).dessert(desert).build();
    }

    private CourseItem chooseCourse(Cuisine cuisine) {
        List<CourseItem> courses = cuisine.getCourses();
        int courseIndex = view.getCourseIndex(courses);
        return courses.get(courseIndex - 1);
    }

    private DesertItem chooseDessert(Cuisine cuisine) {
        List<DesertItem> deserts = cuisine.getDeserts();
        int dessertIndex = view.getDessertIndex(deserts);
        return deserts.get(dessertIndex - 1);
    }

    private Drink chooseDrink() {
        DrinkItem drinkItem = chooseDrinkItem();
        if (drinkItem != null) {
            List<DrinkAdditionalItem> additionalItem = chooseAdditionalItem();
            DrinkBuilder drinkBuilder = new DrinkBuilder().setDrink(drinkItem);
            if (!additionalItem.isEmpty()) {
                for (DrinkAdditionalItem item : additionalItem) {
                    drinkBuilder.addAdditionalItem(item);
                }
            }
            return drinkBuilder.build();
        }
        return null;
    }

    private DrinkItem chooseDrinkItem() {
        List<DrinkItem> drinks = menu.getDrinks();
        int drinkIndex = view.getDrinkIndex(drinks);
        return drinkIndex == 0 ? null : drinks.get(drinkIndex - 1);
    }

    private List<DrinkAdditionalItem> chooseAdditionalItem() {
        List<DrinkAdditionalItem> drinkAdditionalItems = menu.getDrinkAdditionalItems();
        List<DrinkAdditionalItem> resultItem = new ArrayList<>();
        while (true){
            int index = view.getIndexAdditionalItem(drinkAdditionalItems);
            if (index == 0){
                break;
            }else if (!resultItem.contains(drinkAdditionalItems.get(index -1))){
                resultItem.add(drinkAdditionalItems.get(index -1));
            }
        }
        return resultItem;
    }
}
