package com.company.pizza.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "PIZZA_ORDER")
@Entity(name = "pizza_Order")
@NamePattern("%s|number")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 7434331762778569833L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    @Positive
    private Integer number;

    @Column(name = "DATE_", nullable = false)
    @NotNull
    private LocalDateTime date;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private Integer status;

    @NotNull
    @Column(name = "COST", nullable = false)
    @PositiveOrZero
    private BigDecimal cost;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AssociationOverrides({
            @AssociationOverride(name = "courier", joinColumns = @JoinColumn(name = "DELIVERY_COURIER_ID"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "clientName", column = @Column(name = "DELIVERY_CLIENT_NAME")),
            @AttributeOverride(name = "adress", column = @Column(name = "DELIVERY_ADRESS")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "DELIVERY_PHONE_NUMBER")),
            @AttributeOverride(name = "email", column = @Column(name = "DELIVERY_EMAIL")),
            @AttributeOverride(name = "comment", column = @Column(name = "DELIVERY_COMMENT_"))
    })
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    private List<OrderPosition> positions;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setStatus(OrderStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public OrderStatus getStatus() {
        return status == null ? null : OrderStatus.fromId(status);
    }

    public void setPositions(List<OrderPosition> positions) {
        this.positions = positions;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}