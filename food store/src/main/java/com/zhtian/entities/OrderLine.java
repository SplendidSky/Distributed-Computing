package com.zhtian.entities;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/11/23.
 */
public class OrderLine {
    private Food food = null;
    private Integer amount = null;

    public OrderLine() {
        super();
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

}
