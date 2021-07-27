package com.gzw.service.user;

import com.gzw.dao.BaseBao;
import com.gzw.dao.user.UserDao;
import com.gzw.dao.user.UserDaoImpl;
import com.gzw.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    @Override
    public boolean add(User user) {

        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userDao.add(connection,user);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseBao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }

        //匹配密码
        if(null != user){
            if(!user.getUserPassword().equals(userPassword))
                user = null;
        }

        return user;
    }


    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
        try {
            connection = BaseBao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return userList;
    }



    @Override
    public User selectUserCodeExist(String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseBao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return user;
    }
    @Override
    public boolean deleteUserById(Integer delId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if(userDao.deleteUserById(connection,delId) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }
    @Override
    public User getUserById(String id) {
        User user = null;
        Connection connection = null;
        try{
            connection = BaseBao.getConnection();
            user = userDao.getUserById(connection,id);
        }catch (Exception e) {
            e.printStackTrace();
            user = null;
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return user;
    }
    @Override
    public boolean modify(User user) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if(userDao.modify(connection,user) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }
    @Override
    public boolean updatePwd(int id, String pwd) {
        boolean flag = false;
        Connection connection = null;
        try{
            connection = BaseBao.getConnection();
            if(userDao.updatePwd(connection,id,pwd) > 0)
                flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }
    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseBao.getConnection();
            count = userDao.getUserCount(connection, queryUserName,queryUserRole);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public boolean checkUserCode(String userCode) {
        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        Object [] params={userCode};
        String sql="select id from smbms_user where userCode =?";
        try {
            connection = BaseBao.getConnection();
            resultSet=BaseBao.execute(connection,preparedStatement,resultSet,sql,params);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            BaseBao.closeResource(connection,null,null);
        }
        if(resultSet==null)
            return false;
        else return true;

    }


    @Override
    public boolean registUser(String userCode, String userPassword,Object[]params) {
        Connection connection=null;
        int flag=0;
        PreparedStatement preparedStatement=null;

        String sql="insert into smbms_user values(null,"+userCode+",?,"+userPassword+",?,?,?,?,?,?,?,null,null)";
        try {
            connection = BaseBao.getConnection();
            flag=BaseBao.execute(connection,sql,params,preparedStatement);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            BaseBao.closeResource(connection,null,null);
        }
        if(flag==0)
            return false;
        else return true;
    }


}
