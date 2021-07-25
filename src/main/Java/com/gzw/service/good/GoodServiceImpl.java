package com.gzw.service.good;

import com.gzw.dao.BaseBao;
import com.gzw.dao.good.GoodDao;
import com.gzw.dao.good.GoodDaoImpl;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class GoodServiceImpl implements GoodService {
    private GoodDao goodDao;

    public GoodServiceImpl() {
        goodDao = new GoodDaoImpl();
    }

    public boolean add(Good good) throws Exception {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);
            if (goodDao.add(connection, good) > 0)
                flag = true;

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception E) {
                E.printStackTrace();
            } finally {
                //在service层进行connection连接的关闭
                BaseBao.closeResource(connection, null, null);
            }
        }
        return flag;
    }

    @Override
    public boolean delete(Good good) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);
            if (goodDao.delete(connection, good) > 0)
                flag = true;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception E) {
                E.printStackTrace();
            } finally {
                //在service层进行connection连接的关闭
                BaseBao.closeResource(connection, null, null);
            }
        }
        return flag;
    }

    @Override
    public boolean modify(Good good) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if (goodDao.modify(connection, good))
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return flag;
    }


    @Override
    public Good getGoodByID(Integer goodID) {
        Connection connection = null;
        Good good = null;
        try {
            connection = BaseBao.getConnection();
            good = goodDao.getGoodByID(connection, goodID);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return good;
    }

    @Override
    public boolean payOrNot(List<GoodInCar> goodInCarList, Integer payOrNot) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if (goodDao.payOrNot(connection, goodInCarList, payOrNot))
                flag = true;
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            //在service层进行connection连接的关闭
            BaseBao.closeResource(connection, null, null);
        }

        return flag;
    }


    @Override
    public List<GoodInCar> getGoodList(Integer userID, Integer payOrNot) {
        Connection connection = null;
        List<GoodInCar> shoppingList = null;
        try {
            connection = BaseBao.getConnection();
            shoppingList = goodDao.getGoodList(connection, userID, payOrNot);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return shoppingList;
    }

    public boolean addGoodIntoCar(GoodInCar goodInCar) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            connection.setAutoCommit(false);
            if (goodDao.addGoodIntoCar(connection, goodInCar))
                flag = true;

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception E) {
                E.printStackTrace();
            } finally {
                //在service层进行connection连接的关闭
                BaseBao.closeResource(connection, null, null);
            }
        }
        return flag;

    }

    @Override
    public boolean deleteGoodInCar(String goodName, Integer userId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if (goodDao.deleteGoodInCar(connection, goodName, userId))
                flag = true;
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            //在service层进行connection连接的关闭
            BaseBao.closeResource(connection, null, null);
        }

        return flag;

    }
}
