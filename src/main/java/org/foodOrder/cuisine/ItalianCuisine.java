package org.foodOrder.cuisine;

import org.foodOrder.lunch.italianLunch.ItalianCourse;
import org.foodOrder.lunch.italianLunch.ItalianDessert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItalianCuisine extends Cuisine{

    public ItalianCuisine() {
        super(Stream.of(ItalianCourse.values()).collect(Collectors.toList()),
                Stream.of(ItalianDessert.values()).collect(Collectors.toList()),
                "Italian cuisine");
    }
}
