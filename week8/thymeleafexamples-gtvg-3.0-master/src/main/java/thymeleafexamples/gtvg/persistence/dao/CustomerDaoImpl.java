package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.Customer;

/**
 * Created by Administrator on 2016/11/6.
 */

@Repository
public class CustomerDaoImpl extends AbstractJpaDAO<Customer> implements CustomerDao {
    public CustomerDaoImpl() {
        super();

        setClazz(Customer.class);
    }
}
