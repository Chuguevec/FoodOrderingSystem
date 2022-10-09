package org.foodOrder.cuisine;

import org.foodOrder.lunch.polishLunch.PolishCourse;
import org.foodOrder.lunch.polishLunch.PolishDessert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PolishCuisine extends Cuisine {

    public PolishCuisine() {
        super(Stream.of(PolishCourse.values()).collect(Collectors.toList()),
                Stream.of(PolishDessert.values()).collect(Collectors.toList()),
                "Polish cuisine");
    }
}
