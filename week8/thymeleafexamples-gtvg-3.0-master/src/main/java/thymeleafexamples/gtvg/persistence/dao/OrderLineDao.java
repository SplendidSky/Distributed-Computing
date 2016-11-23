package thymeleafexamples.gtvg.persistence.dao;

import thymeleafexamples.gtvg.persistence.model.OrderLine;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface OrderLineDao {
    OrderLine findOne(int id);

    List<OrderLine> findAll();

    void create(OrderLine orderLine);

    OrderLine update(OrderLine orderLine);

    void delete(OrderLine orderLine);
}
