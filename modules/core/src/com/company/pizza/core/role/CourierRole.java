package com.company.pizza.core.role;

import com.company.pizza.entity.*;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = CourierRole.NAME)
public class CourierRole extends AnnotatedRoleDefinition {
    public final static String NAME = "CourierRole";

    @ScreenAccess(screenIds = {"application-pizza", "pizza_Pizza.browse", "pizza_Topping.browse", "pizza_Ingredient.browse", "pizza_Order.browse", "pizza_OrderPosition.browse", "pizza_Order.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = OrderPosition.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Delivery.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Order.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = Ingredient.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Topping.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Pizza.class, operations = EntityOp.READ)
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = OrderPosition.class, view = {"order", "pizza", "count"})
    @EntityAttributeAccess(entityClass = Delivery.class, view = "*")
    @EntityAttributeAccess(entityClass = Order.class, modify = "status", view = {"number", "date", "cost", "delivery"})
    @EntityAttributeAccess(entityClass = Ingredient.class, view = {"pizza", "weight", "topping"})
    @EntityAttributeAccess(entityClass = Topping.class, view = {"name", "isHot"})
    @EntityAttributeAccess(entityClass = Pizza.class, view = {"name", "size", "price"})
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}
