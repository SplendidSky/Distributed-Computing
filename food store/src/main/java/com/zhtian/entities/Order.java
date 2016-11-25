package com.zhtian.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Order {
    private static int _id = 1;
    private int id;
    private Calendar date = null;
    private Set<OrderLine> orderLines;

    public Order() {
        super();
        this.id = _id++;
        this.orderLines = new LinkedHashSet<OrderLine>();
    }

    public static int getCurrentOrderId() { return _id - 1; }
    public int getId() {
        return this.id;
    }

    public Calendar getDate() {
        return this.date;
    }
    public void setDate(final Calendar date) {
        this.date = date;
    }


    public Set<OrderLine> getOrderLines() {
        return this.orderLines;
    }

//    public BigDecimal getTotal() {
//        BigDecimal total = new BigDecimal(0);
//        for (OrderLine orderLine : getOrderLines())
//            total = total.add(orderLine.getPurchasePrice().multiply(new BigDecimal(orderLine.getAmount())));
//        return total;
//    }
}
