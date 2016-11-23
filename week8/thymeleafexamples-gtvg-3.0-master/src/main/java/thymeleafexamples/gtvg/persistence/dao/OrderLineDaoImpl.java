package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.OrderLine;

/**
 * Created by Administrator on 2016/11/6.
 */
@Repository
public class OrderLineDaoImpl extends AbstractJpaDAO<OrderLine> implements OrderLineDao {

    public OrderLineDaoImpl() {
        super();

        setClazz(OrderLine.class);
    }

}
