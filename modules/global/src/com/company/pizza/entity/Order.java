package com.company.pizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "PIZZA_ORDER")
@Entity(name = "pizza_Order")
@NamePattern("%s|number")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 7434331762778569833L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    @Positive
    private Integer number;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    private Date date;

    @Column(name = "STATUS")
    private String status;

    @NotNull
    @Column(name = "COST", nullable = false)
    @PositiveOrZero
    private BigDecimal cost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INFORMATION_ID")
    private OrderInformation information;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITIONS_ID")
    private OrderPosition positions;

    public OrderPosition getPositions() {
        return positions;
    }

    public void setPositions(OrderPosition positions) {
        this.positions = positions;
    }

    public OrderInformation getInformation() {
        return information;
    }

    public void setInformation(OrderInformation information) {
        this.information = information;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}