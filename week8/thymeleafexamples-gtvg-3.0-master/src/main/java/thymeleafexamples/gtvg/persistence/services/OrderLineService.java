package thymeleafexamples.gtvg.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thymeleafexamples.gtvg.persistence.dao.OrderLineDao;
import thymeleafexamples.gtvg.persistence.model.OrderLine;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
@Service
@Transactional
public class OrderLineService {
    @Autowired
    private OrderLineDao dao;

    public OrderLineService() {
        super();
    }

    public void create(OrderLine orderLine) {
        dao.create(orderLine);
    }

    public List<OrderLine> findAll() {
        return dao.findAll();
    }

}
