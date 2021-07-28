package com.company.pizza.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Order;

@UiController("pizza_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}