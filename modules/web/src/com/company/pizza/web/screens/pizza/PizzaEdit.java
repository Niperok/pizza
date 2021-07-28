package com.company.pizza.web.screens.pizza;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Pizza;

@UiController("pizza_Pizza.edit")
@UiDescriptor("pizza-edit.xml")
@EditedEntityContainer("pizzaDc")
@LoadDataBeforeShow
public class PizzaEdit extends StandardEditor<Pizza> {
}