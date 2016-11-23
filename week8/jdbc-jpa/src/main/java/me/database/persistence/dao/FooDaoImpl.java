package me.database.persistence.dao;

import me.database.persistence.model.Foo;
import org.springframework.stereotype.Repository;

@Repository
public class FooDaoImpl extends AbstractJpaDAO<Foo> implements FooDao {

    public FooDaoImpl() {
        super();

        setClazz(Foo.class);
    }

    // API

}
