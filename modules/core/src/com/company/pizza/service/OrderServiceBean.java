package com.company.pizza.service;

import com.company.pizza.entity.Order;
import com.company.pizza.entity.OrderPosition;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

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


}