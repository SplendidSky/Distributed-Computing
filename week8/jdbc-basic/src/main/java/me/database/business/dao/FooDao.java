package me.database.business.dao;

import java.util.List;

import me.database.business.model.Foo;

public interface FooDao {

    Foo findOne(long id);

    List<Foo> findAll();

    void create(Foo entity);

    Foo update(Foo entity);

    void delete(Foo entity);

    void deleteById(long entityId);

}
