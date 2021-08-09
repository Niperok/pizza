package com.company.pizza.listeners;

import com.company.pizza.entity.Order;
import com.company.pizza.entity.OrderStatus;
import com.company.pizza.entity.Payment;
import com.company.pizza.service.OrderService;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component("pizza_OrderEntityListener")
public class OrderEntityListener implements BeforeInsertEntityListener<Order>{

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    @Inject
    private DataManager dataManager;

    @Override
    public void onBeforeInsert(Order entity, EntityManager entityManager) {
        entity.setNumber(Long.valueOf(
                entity.getDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")) +
                        uniqueNumbersAPI.getNextNumber("ORDER_NUMBER")
                )
        );
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderAfterCommit(EntityChangedEvent<Order, UUID> event) {
        if (!event.getChanges().isChanged("status")) {
            return;
        }

        Order order = dataManager.load(event.getEntityId()).view(View.LOCAL).one();

        if (order.getStatus() == OrderStatus.PAYED) {
            Payment payment = dataManager.create(Payment.class);
            payment.setOrder(order);
            payment.setTotal(order.getCost());
            dataManager.commit(payment);
        }

        if (order.getStatus() == OrderStatus.CANCELED) {
            OrderStatus prev = OrderStatus.fromId(event.getChanges().getOldValue("status"));
            if (prev == OrderStatus.PAYED || prev == OrderStatus.COOKING) {
                Payment payment = dataManager.create(Payment.class);
                payment.setOrder(order);
                payment.setTotal(order.getCost().negate());
                dataManager.commit(payment);
            }
        }
    }
}
