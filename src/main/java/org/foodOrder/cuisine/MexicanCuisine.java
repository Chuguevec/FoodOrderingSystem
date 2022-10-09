package org.foodOrder.cuisine;

import org.foodOrder.lunch.mexicanLunch.MexicanCourse;
import org.foodOrder.lunch.mexicanLunch.MexicanDessert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MexicanCuisine extends Cuisine {

    public MexicanCuisine() {
        super(Stream.of(MexicanCourse.values()).collect(Collectors.toList()),
                Stream.of(MexicanDessert.values()).collect(Collectors.toList()),
                "Mexican cuisine");
    }
}
