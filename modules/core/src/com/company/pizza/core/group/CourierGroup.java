package com.company.pizza.core.group;

import com.company.pizza.entity.Order;
import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;
import com.haulmont.cuba.security.app.group.annotation.JpqlConstraint;
import com.haulmont.cuba.security.group.ConstraintsContainer;

@AccessGroup(name = CourierGroup.GROUP_NAME)
public class CourierGroup extends AnnotatedAccessGroupDefinition {

    public static final String GROUP_NAME = "Couriers";

    @JpqlConstraint(target = Order.class, where = "{E}.delivery.courier.id = :session$userId")
    @Override
    public ConstraintsContainer accessConstraints() {
        return super.accessConstraints();
    }
}
