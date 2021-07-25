package com.gzw.service.comment;

import com.gzw.dao.BaseBao;
import com.gzw.dao.comment.CommentDao;
import com.gzw.dao.comment.CommentDaoImpl;
import com.gzw.pojo.Comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    CommentServiceImpl() {
        commentDao = new CommentDaoImpl();
    }

    public boolean add(Comment comment) throws SQLException {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);
            if (commentDao.add(connection, comment))
                flag = true;
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean delete(Comment comment) throws SQLException {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);
            if (commentDao.delete(connection, comment))
                flag = true;
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public List<Comment> query(Integer goodId) throws SQLException {
        List<Comment>commentList=null;
        Connection connection = null;
        try {
            connection = BaseBao.getConnection();
            commentList = commentDao.query(connection, goodId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return commentList;
    }
}
