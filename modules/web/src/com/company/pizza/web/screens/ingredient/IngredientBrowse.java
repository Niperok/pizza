package com.company.pizza.web.screens.ingredient;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Ingredient;

import javax.inject.Inject;
import java.util.UUID;

@UiController("pizza_Ingredient.browse")
@UiDescriptor("ingredient-browse.xml")
@LookupComponent("ingredientsTable")
@LoadDataBeforeShow
public class IngredientBrowse extends StandardLookup<Ingredient> {
    @Inject
    private CollectionLoader<Ingredient> ingredientsDl;

    public void setPizzaId(UUID pizzaId) {
        ingredientsDl.setParameter("pizzaId", pizzaId);
    }
}