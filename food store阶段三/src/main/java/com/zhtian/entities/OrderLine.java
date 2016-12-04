package com.zhtian.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Column;

/**
 * Created by Administrator on 2016/11/23.
 */

@Entity
@Table(name = "orderLine")
public class OrderLine {

    @OneToOne(mappedBy = "id")
    private Integer foodId = null;

    private Food food = null;

    @Column(name = "amount")
    private Integer amount = null;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Integer orderId = null;

    private boolean isCheaper = false;

    public OrderLine() {
        super();
    }

    public OrderLine(Food food, Integer foodId, Integer amount, Integer orderId, boolean isCheaper) {
        super();
        this.food = food;
        this.foodId = foodId;
        this.amount = amount;
        this.orderId = orderId;
        this.isCheaper = isCheaper;
    }

    public Integer getFoodId() {
        return this.foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(final Food food) {
        this.food = food;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Double getProduct() {
        if (!isCheaper)
            return food.getCost() * amount;
        else
            return food.getCost() * amount * 0.95;
    }

    public void setCheaper(boolean cheaper) {
        isCheaper = cheaper;
    }

    public boolean getCheaper() {
        return isCheaper;
    }
}
