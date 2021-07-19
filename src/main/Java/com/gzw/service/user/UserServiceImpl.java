package com.gzw.service.user;

import com.gzw.dao.BaseBao;
import com.gzw.dao.user.UserDaoImpl;
import com.gzw.pojo.User;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends GeneralSqlService implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();


    @Override
    public User login(String userCode, String password) {
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建用于查询的User对象
        User queryUser = new User();
        queryUser.setUserCode(userCode);
        queryUser.setUserPassword(password);
        // 执行sql
        User user = sqlSession.selectOne("mybatis.mapper.UserMapper.selectUser",queryUser);
        // 提交并关闭sqlSession
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建用于查询的User对象
        User queryUser = new User();
        queryUser.setId(id);
        queryUser.setUserPassword(password);
        // 执行sql
        try {
            sqlSession.update("mybatis.mapper.UserMapper.updateUser",queryUser);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @Override
    public int getUserCount(String userName, int userRole) {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUserName(userName);
        user.setUserCode(String.valueOf(userRole));

        int count = sqlSession.selectOne("mybatis.mapper.UserMapper.countUser",user);

        sqlSession.commit();
        sqlSession.close();

        return count;
    }

    /*@Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseBao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseBao.closeResource(connection, null, null);
        }
        return userList;
    }*/
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize){

        if (currentPageNo < 1){
            return null;
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("userName", queryUserName);
        queryMap.put("UserRole", queryUserRole);
        queryMap.put("index", (currentPageNo - 1) * pageSize);
        queryMap.put("number", pageSize);

        List<User> userList = sqlSession.selectList("mybatis.mapper.UserMapper.selectUserList",queryMap);
        sqlSession.commit();
        sqlSession.close();

        return userList;
    }

    @Test
    public void testCountUser(){
        UserService userService = new UserServiceImpl();
        int count = this.getUserCount("张",3);
        System.out.println(count);
    }

    @Test
    public void testGetUserList(){
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getUserList("",3,2, 10);
        for (User user :
                userList) {
            System.out.println(user.getUserName());
        }
    }
}