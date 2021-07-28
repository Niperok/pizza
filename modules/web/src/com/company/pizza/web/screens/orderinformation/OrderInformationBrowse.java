package com.company.pizza.web.screens.orderinformation;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.OrderInformation;

@UiController("pizza_OrderInformation.browse")
@UiDescriptor("order-information-browse.xml")
@LookupComponent("orderInformationsTable")
@LoadDataBeforeShow
public class OrderInformationBrowse extends StandardLookup<OrderInformation> {
}