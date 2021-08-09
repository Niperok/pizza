package com.company.pizza.web.screens.pizza;

import com.company.pizza.web.screens.ingredient.IngredientBrowse;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizza.entity.Pizza;
import com.haulmont.reports.gui.actions.RunReportAction;

import javax.inject.Inject;

@UiController("pizza_Pizza.browse")
@UiDescriptor("pizza-browse.xml")
@LookupComponent("pizzasTable")
@LoadDataBeforeShow
public class PizzaBrowse extends StandardLookup<Pizza> {

    @Inject
    private GroupTable<Pizza> pizzasTable;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Notifications notifications;
    @Inject
    private Button reportBtn;

    @Subscribe("pizzasTable.showRecipe")
    public void onPizzasTableShowRecipe(Action.ActionPerformedEvent event) {
        Pizza selected = pizzasTable.getSingleSelected();

        if (selected != null) {
            IngredientBrowse ingredientBrowse = screenBuilders.screen(this)
                    .withScreenClass(IngredientBrowse.class)
                    .withOpenMode(OpenMode.DIALOG).build();
            ingredientBrowse.setPizzaId(selected.getId());
            ingredientBrowse.show();
        } else {
            notifications.create().withCaption("Please, select a pizza!")
                    .withType(Notifications.NotificationType.WARNING).show();
        }
    }

    @Subscribe
    public void onInit(InitEvent event) {
        reportBtn.setAction(new RunReportAction());
    }

    
}