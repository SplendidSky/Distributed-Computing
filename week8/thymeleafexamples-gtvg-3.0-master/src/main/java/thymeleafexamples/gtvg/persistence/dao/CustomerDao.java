package thymeleafexamples.gtvg.persistence.dao;

import thymeleafexamples.gtvg.persistence.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface CustomerDao {
    Customer findOne(int id);

    List<Customer> findAll();

    void create(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);

    void deleteById(int customerId);
}
