package com.company.pizza.service;

import com.company.pizza.entity.Order;
import com.company.pizza.entity.OrderPosition;
import com.company.pizza.entity.OrderStatus;
import com.company.pizza.entity.Payment;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.math.BigDecimal;


@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    protected DataManager dataManager;
    @Inject
    private Persistence persistence;

    @Override
    public BigDecimal calculateCost(Order order) {
        BigDecimal cost = BigDecimal.ZERO;

        if(order.getPositions() != null) {
            for (OrderPosition position :
                 order.getPositions()) {
                cost = cost.add(position.getPizza().getPrice()
                        .multiply(BigDecimal.valueOf(position.getCount())));
            }
            cost = calculateSales(order, cost);

        }

        return cost;
    }

    @Override
    public BigDecimal calculateSales(Order order, BigDecimal cost) {
        BigDecimal moreThan3Sale = BigDecimal.valueOf(0.95);
        BigDecimal moreThan8Sale = BigDecimal.valueOf(0.9);

        if (order.getPositions().size() > 8) {
            cost = cost.multiply(moreThan8Sale);
        }
        else if (order.getPositions().size() > 3) {
            cost = cost.multiply(moreThan3Sale);
        }
        return cost;
    }

    @Override
    public void createPayment(Order order) {
        persistence.createTransaction().execute(em -> {
            Query query = em.createQuery("Select e FROM pizza_Payment e WHERE e.order = :id and e.total = :total");
            query.setParameter("id", order);
            query.setParameter("total", order.getCost());
            try {
                Object result = query.getSingleResult();
            } catch (NoResultException e) {
                Payment payment = dataManager.create(Payment.class);
                payment.setOrder(order);
                payment.setTotal(order.getCost());
                dataManager.commit(payment);
            }
        });
    }

    @Override
    public void createRefund(Order order) {
        persistence.createTransaction().execute(em -> {
            Query query = em.createQuery("Select e FROM pizza_Payment e WHERE e.order = :id and e.total = :total");
            query.setParameter("id", order);
            query.setParameter("total", order.getCost().negate());
            try {
                Object result = query.getSingleResult();
            } catch (NoResultException e) {
                Payment payment = dataManager.create(Payment.class);
                payment.setOrder(order);
                payment.setTotal(order.getCost().negate());
                dataManager.commit(payment);
            }
        });
    }

    ;


}