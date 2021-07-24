package com.gzw.service.comment;

import com.gzw.pojo.Comment;

import java.sql.SQLException;

public interface CommentService {
    //添加评论到
    public  boolean add(Comment comment) throws SQLException;
    public  boolean delete(Comment comment) throws SQLException;

}
