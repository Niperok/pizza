package com.company.pizza.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "PIZZA_PIZZA")
@Entity(name = "pizza_Pizza")
@NamePattern("%s|name")
public class Pizza extends StandardEntity {
    private static final long serialVersionUID = 4186425602332203836L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "SIZE_", nullable = false)
    @Min(10)
    @Max(50)
    private Integer size;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    @DecimalMin("0")
    private BigDecimal price;

    @Column(name = "CALORIFIC")
    private Integer calorific;

    @Lob
    @Column(name = "INFORMATION")
    private String information;

    @OneToMany(mappedBy = "pizza")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    private List<Ingredient> ingredients;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_ID")
    private FileDescriptor image;

    public FileDescriptor getImage() {
        return image;
    }

    public void setImage(FileDescriptor image) {
        this.image = image;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getCalorific() {
        return calorific;
    }

    public void setCalorific(Integer calorific) {
        this.calorific = calorific;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}