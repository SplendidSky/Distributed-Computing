package com.zhtian.entities.repositories;

import com.zhtian.entities.Food;
import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;
import com.zhtian.util.CalendarUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/23.
 */
public class OrderRepository {
    private static final OrderRepository INSTANCE = new OrderRepository();
    private final Map<Integer,Order> ordersById;

    public static OrderRepository getInstance() {
        return INSTANCE;
    }

    private OrderRepository() {

        super();

        this.ordersById = new LinkedHashMap<Integer, Order>();

    }

    public Order getCurrentOrder() { return ordersById.get(Order.getCurrentOrderId()); }

    public void addNewOrder() {
        Order order = new Order();
        ordersById.put(order.getId(), order);
    }

    public List<Order> findAll() {
        return new ArrayList<Order>(this.ordersById.values());
    }

    public Order findById(final Integer id) {
        return this.ordersById.get(id);
    }

}
