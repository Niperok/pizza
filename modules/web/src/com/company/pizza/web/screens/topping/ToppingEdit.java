package com.company.pizza.web.screens.topping;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Topping;

@UiController("pizza_Topping.edit")
@UiDescriptor("topping-edit.xml")
@EditedEntityContainer("toppingDc")
@LoadDataBeforeShow
public class ToppingEdit extends StandardEditor<Topping> {
}