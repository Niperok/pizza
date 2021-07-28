package com.company.pizza.web.screens.topping;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Topping;

@UiController("pizza_Topping.browse")
@UiDescriptor("topping-browse.xml")
@LookupComponent("toppingsTable")
@LoadDataBeforeShow
public class ToppingBrowse extends StandardLookup<Topping> {
}