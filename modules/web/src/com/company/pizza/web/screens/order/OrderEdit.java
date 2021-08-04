package com.company.pizza.web.screens.order;

import com.company.pizza.entity.OrderPosition;
import com.company.pizza.entity.OrderStatus;
import com.company.pizza.service.OrderService;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Order;

import javax.inject.Inject;

@UiController("pizza_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
    @Inject
    private OrderService orderService;

    private void refreshCost() {
        Order order = getEditedEntity();
        order.setCost(orderService.calculateCost(order));
    
    }

    @Subscribe(id = "positionsDc", target = Target.DATA_CONTAINER)
    public void onPositionsDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderPosition> event) {
        if(event.getChangeType() != CollectionChangeType.REFRESH) {
            refreshCost();
        }
    }

//    @Subscribe(id = "orderDc", target = Target.DATA_CONTAINER)
//    public void onOrderDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Order> event) {
//        Order order = getEditedEntity();
//        if (order.getStatus().equals(OrderStatus.COOKING)) {
//            orderService.createPayment(order);
//        }
//        if (order.getStatus().equals(OrderStatus.CANCELED)) {
//            orderService.createRefund(order);
//        }
//    }

    

}