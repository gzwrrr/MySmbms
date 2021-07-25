package com.gzw.dao.comment;

import com.gzw.pojo.Comment;

import java.sql.Connection;
import java.util.List;

public interface CommentDao {
    public  boolean add(Connection connection, Comment comment);
    public  boolean delete(Connection connection,Comment comment);
    public List<Comment> query(Connection connection, Integer goodId);
}
