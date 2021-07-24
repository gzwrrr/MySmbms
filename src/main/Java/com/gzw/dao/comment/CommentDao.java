package com.gzw.dao.comment;

import com.gzw.pojo.Comment;

import java.sql.Connection;

public interface CommentDao {
    public  boolean add(Connection connection, Comment comment);
    public  boolean delete(Connection connection,Comment comment);
    public  Comment query(Connection connection,Integer goodId);
}
