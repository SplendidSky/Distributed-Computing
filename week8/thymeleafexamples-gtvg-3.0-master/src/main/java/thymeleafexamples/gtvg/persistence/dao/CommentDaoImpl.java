package thymeleafexamples.gtvg.persistence.dao;

import org.springframework.stereotype.Repository;
import thymeleafexamples.gtvg.persistence.model.Comment;

/**
 * Created by Administrator on 2016/11/6.
 */

@Repository
public class CommentDaoImpl extends AbstractJpaDAO<Comment> implements CommentDao{

    public CommentDaoImpl() {
        super();

        setClazz(Comment.class);
    }

}
