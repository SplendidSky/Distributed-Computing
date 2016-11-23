package thymeleafexamples.gtvg.persistence.dao;


import thymeleafexamples.gtvg.persistence.model.Product;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface ProductDao {
    Product findOne(int id);

    List<Product> findAll();

    void create(Product product);

    Product update(Product product);

    void delete(Product product);

    void deleteById(int productId);
}
