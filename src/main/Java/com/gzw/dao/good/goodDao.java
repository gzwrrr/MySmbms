package com.gzw.dao.good;

import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface goodDao {
public int  add(Connection connection ,Good  good)throws Exception;

    int delete(Connection connection, Good good);

    List<GoodInCar> getGoodList(Connection connection, Integer userID)throws SQLException;
    public Good getGoodByID(Connection connection,Integer goodID)throws SQLException;
    public boolean addGoodIntoCar(Connection connection, Object [] paras)throws SQLException;
    public boolean deleteGoodInCar(Connection connection, String goodName,Integer userId) ;
    public boolean payOrNot(Connection connection, Integer userId,Integer payornot);

}
