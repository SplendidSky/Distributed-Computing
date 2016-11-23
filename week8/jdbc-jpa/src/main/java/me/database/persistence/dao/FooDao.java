package me.database.persistence.dao;

import java.util.List;

import me.database.persistence.model.Foo;

public interface FooDao {

    Foo findOne(long id);

    List<Foo> findAll();

    void create(Foo entity);

    Foo update(Foo entity);

    void delete(Foo entity);

    void deleteById(long entityId);

}
