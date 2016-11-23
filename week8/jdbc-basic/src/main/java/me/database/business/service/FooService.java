package me.database.business.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import me.database.business.dao.FooDao;
import me.database.business.model.Foo;

@Service
@Transactional
public class FooService {

    @Autowired
    private FooDao dao;

    public FooService() {
        super();
    }

    // API
    public void create(final Foo entity) {
        dao.create(entity);
    }

    public Foo findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Foo> findAll() {
        return dao.findAll();
    }

}
