package com.gzw.service.comment;

import com.gzw.dao.BaseBao;
import com.gzw.dao.comment.CommentDao;
import com.gzw.dao.comment.CommentDaoImpl;
import com.gzw.pojo.Comment;

import java.sql.Connection;
import java.sql.SQLException;

public class CommentServiceImpl implements CommentService {

    private  CommentDao commentDao;
    CommentServiceImpl()
    {
        commentDao=new CommentDaoImpl();
    }
    public boolean add(Comment comment) throws SQLException{
        Connection connection =null;
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
    public boolean delete(Comment comment)throws SQLException {
        Connection connection =null;
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
}
