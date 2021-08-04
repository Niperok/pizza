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

@Role(name = CookRole.NAME)
public class CookRole extends AnnotatedRoleDefinition {
    public final static String NAME = "CookRole";

    @ScreenAccess(screenIds = {"application-pizza", "pizza_Pizza.browse", "pizza_Topping.browse", "pizza_OrderPosition.browse", "pizza_Order.browse", "pizza_Ingredient.browse", "pizza_Pizza.edit", "pizza_Topping.edit", "pizza_Ingredient.edit", "pizza_Order.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = OrderPosition.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Order.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = Ingredient.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Topping.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Pizza.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = OrderPosition.class, view = {"order", "pizza", "count"})
    @EntityAttributeAccess(entityClass = Order.class, modify = "status", view = {"number", "date", "positions"})
    @EntityAttributeAccess(entityClass = Ingredient.class, modify = {"topping", "weight", "pizza"})
    @EntityAttributeAccess(entityClass = Topping.class, modify = {"name", "isHot"})
    @EntityAttributeAccess(entityClass = Pizza.class, modify = {"name", "size", "price", "calorific", "information", "ingredients"})
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}
