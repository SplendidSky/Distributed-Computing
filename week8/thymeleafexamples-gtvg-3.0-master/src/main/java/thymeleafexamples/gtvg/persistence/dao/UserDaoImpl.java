package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.User;

/**
 * Created by Administrator on 2016/11/6.
 */
@Repository
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {
    public UserDaoImpl() {
        super();

        setClazz(User.class);
    }
}
