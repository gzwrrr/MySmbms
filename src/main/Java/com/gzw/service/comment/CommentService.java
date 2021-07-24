package com.gzw.service.comment;

import com.gzw.pojo.Comment;

import java.sql.Connection;
import java.sql.SQLException;

public interface CommentService {
    //添加评论到该商品页面
    public boolean add(Comment comment) throws SQLException;
    //删除评论，发出评论的用户有删除评论的权限
    public boolean delete(Comment comment) throws SQLException;
    //查询评论
    public Comment query(Integer goodId) throws SQLException;

}
