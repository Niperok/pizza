package com.company.pizza.web.screens.pizza;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Pizza;

@UiController("pizza_PizzaIngrefients.browse")
@UiDescriptor("pizza-ingredients-browse.xml")
@LookupComponent("pizzasTable")
@LoadDataBeforeShow
public class PizzaBrowseIngredients extends StandardLookup<Pizza> {
}