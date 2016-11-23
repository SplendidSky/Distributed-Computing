package thymeleafexamples.gtvg.persistence.dao;

import thymeleafexamples.gtvg.persistence.model.Comment;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public interface CommentDao {
    Comment findOne(int id);

    List<Comment> findAll();

    void create(Comment comment);

    Comment update(Comment comment);

    void delete(Comment comment);

    void deleteById(int commentId);
}
