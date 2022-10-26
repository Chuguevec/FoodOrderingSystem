package org.foodOrder.service.spyView;

import org.foodOrder.menu.Menu;
import org.foodOrder.view.View;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class ViewTest {
    @Spy
   static View spyView;
    Menu menu = new Menu();

    @BeforeAll
    public static void init (){
       spyView = Mockito.spy(View.class);
        spyView.showMenu();
    }

    @Test
    public void showMenuPrintItalianCuisine() throws Exception {
        Mockito.verify(spyView).printPaidItem(menu.getItalianCuisine().getCourses());
        Mockito.verify(spyView).printPaidItem(menu.getItalianCuisine().getDeserts());
    }

    @Test
    public void showMenuPrintPolishCuisine() throws Exception {
        Mockito.verify(spyView).printPaidItem(menu.getPolishCuisine().getCourses());
        Mockito.verify(spyView).printPaidItem(menu.getPolishCuisine().getDeserts());
    }

    @Test
    public void showMenuPrintMexicanCuisine() throws Exception {
        Mockito.verify(spyView).printPaidItem(menu.getMexicanCuisine().getCourses());
        Mockito.verify(spyView).printPaidItem(menu.getMexicanCuisine().getDeserts());
    }

    @Test
    public void showMenuPrintDrinks() throws Exception {
        Mockito.verify(spyView).printPaidItem(menu.getDrinks());
        Mockito.verify(spyView).printItem(menu.getDrinkAdditionalItems());
    }

}
