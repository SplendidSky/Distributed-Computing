package thymeleafexamples.gtvg.persistence.dao;

import thymeleafexamples.gtvg.persistence.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface UserDao {
    User findOne(int id);

    List<User> findAll();

    void create(User user);

    User update(User user);

    void delete(User user);

    void deleteById(int userId);
}
