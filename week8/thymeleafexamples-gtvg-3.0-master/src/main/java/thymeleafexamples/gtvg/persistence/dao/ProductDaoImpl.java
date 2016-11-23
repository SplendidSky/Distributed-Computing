package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.Product;

/**
 * Created by Administrator on 2016/11/6.
 */

@Repository
public class ProductDaoImpl extends AbstractJpaDAO<Product> implements ProductDao{

    public ProductDaoImpl() {
        super();

        setClazz(Product.class);
    }
}
