package thymeleafexamples.gtvg.persistence.dao;

import thymeleafexamples.gtvg.persistence.model.ProductOrder;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface OrderDao {
    ProductOrder findOne(int id);

    List<ProductOrder> findAll();

    void create(ProductOrder productOrder);

    ProductOrder update(ProductOrder productOrder);

    void delete(ProductOrder productOrder);

    void deleteById(int orderId);
}
