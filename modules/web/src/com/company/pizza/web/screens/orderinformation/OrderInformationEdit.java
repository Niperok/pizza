package com.company.pizza.web.screens.orderinformation;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.OrderInformation;

@UiController("pizza_OrderInformation.edit")
@UiDescriptor("order-information-edit.xml")
@EditedEntityContainer("orderInformationDc")
@LoadDataBeforeShow
public class OrderInformationEdit extends StandardEditor<OrderInformation> {
}