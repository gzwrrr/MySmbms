package com.gzw.dao.good;

import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.GoodsImgUrl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GoodDao {
    public int add(Connection connection, Good good) throws Exception;

    int delete(Connection connection, Good good);

    public List<GoodInCar> getGoodList(Connection connection, Integer userID, Integer payOrNot) throws SQLException;

    public Good getGoodByID(Connection connection, String goodID) throws SQLException;

    public boolean addGoodIntoCar(Connection connection, GoodInCar goodInCar) throws SQLException;

    public boolean deleteGoodInCar(Connection connection, String goodName, Integer userId, Integer payOrNot);

    public boolean payOrNot(Connection connection, List<GoodInCar> goodInCarList, Integer payOrNot) throws SQLException;

    boolean modify(Connection connection, Good good);

    public List<Good> getGoodsInPage(Connection connection, Integer area, Integer offOrNot) throws SQLException;

    public List<GoodsImgUrl> getUrlById(Connection connection, Integer goodId) throws SQLException;
}
