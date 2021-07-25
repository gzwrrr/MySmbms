package com.gzw.dao.comment;

import com.gzw.dao.BaseBao;
import com.gzw.pojo.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements CommentDao {


    @Override
    public boolean add(Connection connection, Comment comment) {
      int flag=0;
        PreparedStatement preparedStatement=null;
        Object []paras={comment.getContent(),comment.getUserId(),comment.getGoodId()};
        String sql="insert into smbms_comment(content,userId,goodId)values(?,?,?);";
        try {
            flag=BaseBao.execute(connection,sql,paras,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
             BaseBao.closeResource(null,preparedStatement,null);
        }
    if (flag>0)
        return  true;
    else return  false;
    }

    @Override
    public boolean delete(Connection connection, Comment comment) {
        int flag=0;
        PreparedStatement preparedStatement=null;
        Object []paras={comment.getCommentId()};
        String sql="delete from smbms_comment where commentId=?;";
        try {
            flag=BaseBao.execute(connection,sql,paras,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseBao.closeResource(null,preparedStatement,null);
        }
        if (flag>0)
            return  true;
        else return  false;
    }
    public List<Comment> query(Connection connection, Integer goodId)
    {
        List<Comment> commentList=null;
        Comment comment=null;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        Object[]paras={goodId};
        String sql="select * from smbms_comment where commentId=?;";
        if(connection!=null) {
            try {
                resultSet = BaseBao.execute(connection, preparedStatement, resultSet, sql, paras);
                while(resultSet.next())
                {
                    comment.setCommentId(resultSet.getInt("commentId"));
                    comment.setContent(resultSet.getString("content"));
                    comment.setUserId(resultSet.getInt("userId"));
                    comment.setGoodId(resultSet.getInt("goodId"));
            commentList.add(comment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                {
                    BaseBao.closeResource(null,preparedStatement,resultSet);
                }
            }
        }
     return  commentList;
    }
}