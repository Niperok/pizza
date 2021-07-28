package com.company.pizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "PIZZA_INGREDIENT")
@Entity(name = "pizza_Ingredient")
@NamePattern("%s %s|topping,weight")
public class Ingredient extends StandardEntity {
    private static final long serialVersionUID = 4777002513880895452L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TOPPING_ID")
    @NotNull
    private Topping topping;

    @NotNull
    @Column(name = "WEIGHT", nullable = false)
    private Integer weight;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PIZZA_ID")
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

}