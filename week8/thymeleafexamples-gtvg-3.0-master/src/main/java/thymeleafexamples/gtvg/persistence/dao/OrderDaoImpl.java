package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.ProductOrder;

/**
 * Created by Administrator on 2016/11/6.
 */
@Repository
public class OrderDaoImpl extends AbstractJpaDAO<ProductOrder> implements OrderDao {
    public OrderDaoImpl() {
        super();

        setClazz(ProductOrder.class);
    }

}
