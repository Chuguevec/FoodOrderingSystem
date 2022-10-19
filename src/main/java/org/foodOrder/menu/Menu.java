package org.foodOrder.menu;

import org.foodOrder.cuisine.Cuisine;
import org.foodOrder.cuisine.ItalianCuisine;
import org.foodOrder.cuisine.MexicanCuisine;
import org.foodOrder.cuisine.PolishCuisine;
import org.foodOrder.drink.DrinkAdditionalItem;
import org.foodOrder.drink.DrinkItem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private ItalianCuisine italianCuisine;
    private MexicanCuisine mexicanCuisine;
    private PolishCuisine polishCuisine;
   private List<DrinkItem> drinks;
   private List<DrinkAdditionalItem> drinkAdditionalItems;
   private List <Cuisine> cuisines;

    public Menu() {
        italianCuisine = new ItalianCuisine();
        mexicanCuisine = new MexicanCuisine();
        polishCuisine = new PolishCuisine();
        cuisines = List.of(italianCuisine, mexicanCuisine, polishCuisine);
        drinks = Stream.of(DrinkItem.values()).collect(Collectors.toList());
        drinkAdditionalItems = Stream.of(DrinkAdditionalItem.values()).collect(Collectors.toList());
    }

    public ItalianCuisine getItalianCuisine() {
        return italianCuisine;
    }

    public MexicanCuisine getMexicanCuisine() {
        return mexicanCuisine;
    }

    public PolishCuisine getPolishCuisine() {
        return polishCuisine;
    }

    public List<DrinkItem> getDrinks() {
        return drinks;
    }

    public List<DrinkAdditionalItem> getDrinkAdditionalItems() {
        return drinkAdditionalItems;
    }
    public List<Cuisine> getCuisines() {
        return cuisines;
    }
}
