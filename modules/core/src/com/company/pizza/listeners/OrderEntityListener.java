package com.company.pizza.listeners;

import com.company.pizza.entity.Order;
import com.company.pizza.entity.OrderStatus;
import com.company.pizza.service.OrderService;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component("pizza_OrderEntityListener")
public class OrderEntityListener implements BeforeInsertEntityListener<Order>, BeforeUpdateEntityListener<Order> {

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    @Inject
    private OrderService orderService;

    @Override
    public void onBeforeInsert(Order entity, EntityManager entityManager) {
        entity.setNumber(Long.valueOf(
                entity.getDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")) +
                        uniqueNumbersAPI.getNextNumber("ORDER_NUMBER")
            )
        );
    }

    @Override
    public void onBeforeUpdate(Order order, EntityManager entityManager) {
        if (order.getStatus().equals(OrderStatus.COOKING)) {
            orderService.createPayment(order);
        }
        if (order.getStatus().equals(OrderStatus.CANCELED)) {
            orderService.createRefund(order);
        }
    }
}
