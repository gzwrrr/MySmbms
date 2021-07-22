package com.gzw.service.user;

import com.gzw.dao.user.UserDaoImpl;
import com.gzw.pojo.User;
import com.gzw.service.abstractService.GeneralSqlService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends GeneralSqlService implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();


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
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if(userDao.deleteUserById(connection,delId) > 0)
                flag = true;
        } catch (Exception e) {
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
    public User login(String userCode, String password) {
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建用于查询的User对象
        User queryUser = new User();
        queryUser.setUserCode(userCode);
        queryUser.setUserPassword(password);
        // 执行sql
        User user = sqlSession.selectOne("mybatis.mapper.UserMapper.selectUser", queryUser);
        // 提交并关闭sqlSession
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public boolean register(String userCode, String password) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setUserCode(userCode);
            if(sqlSession.selectOne("mybatis.mapper.UserMapper.selectUser",user) != null){
                return false;
            }
            user.setUserPassword(password);
            sqlSession.insert("mybatis.mapper.UserMapper.insertUser",user);

            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        // 通过SqlSessionFactory创建SqlSession
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            User queryUser = new User();
            queryUser.setId(id);
            if(sqlSession.selectOne("mybatis.mapper.UserMapper.selectUser", queryUser)==null){
                return false;
            }
            queryUser.setUserPassword(password);
            sqlSession.update("mybatis.mapper.UserMapper.updateUser", queryUser);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int getUserCount(String userName, int userRole) {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUserName(userName);
        user.setUserCode(String.valueOf(userRole));

        int count = sqlSession.selectOne("mybatis.mapper.UserMapper.countUser", user);

        sqlSession.commit();
        sqlSession.close();

        return count;
    }

    // TODO: 代码功能比较复杂，暂时保留
    /*@Override
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
    }*/
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {

        if (currentPageNo < 1) {
            return null;
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userName", queryUserName);
        queryMap.put("UserRole", queryUserRole);
        queryMap.put("index", (currentPageNo - 1) * pageSize);
        queryMap.put("number", pageSize);

        List<User> userList = sqlSession.selectList("mybatis.mapper.UserMapper.selectUserList", queryMap);
        sqlSession.commit();
        sqlSession.close();

        return userList;
    }



    @Test
    public void testCountUser() {
        UserService userService = new UserServiceImpl();
        int count = this.getUserCount("张", 3);
        System.out.println(count);
    }

    @Test
    public void testGetUserList() {
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getUserList("", 3, 2, 10);
        for (User user :
                userList) {
            System.out.println(user.getUserName());
        }
    }

    @Test
    public void testRegisterUser() {
        UserService userService = new UserServiceImpl();

        System.out.println(register("717368","123456"));
    }
}