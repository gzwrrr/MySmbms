package com.gzw.dao.good;

import com.gzw.dao.BaseBao;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class goodDaoImpl implements  goodDao{
    @Override
    public int add(Connection connection, Good good) throws Exception  {

            PreparedStatement pstm = null;
            int flag = 0;
            if(null != connection){
                String sql = "insert into smbms_good (goodName,goodPrice,createDate,createdBy,url)" +
                        "values(?,?,?,?,?)";
                Object[] params = {good.getGoodName(),good.getGoodPrice(),good.getCreatedDate(),good.getCreatedBy(),good.getUrl()};
                flag = BaseBao.execute(connection, sql, params,pstm);
                BaseBao.closeResource(null, pstm, null);
            }
            return flag;
        }

    @Override
    //通过Id删除上架的物品
    public int delete(Connection connection, Good good) {
        PreparedStatement pstm = null;
        int flag = 0;
        if(null != connection){
            String sql = "delete from smbms_good where id="+good.getGoodID();
            Object[] params = {good.getGoodID()};
            try {
                flag = BaseBao.execute(connection, sql, params,pstm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BaseBao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public List<GoodInCar> getGoodList(Connection connection, Integer userID)throws  SQLException {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        List<GoodInCar> shoppingList = new ArrayList<GoodInCar>();
        Object [] paras=null;
        String sql="select addressDesc,creationDate,goodId,goodNumber,goodName,goodPrice from smbms_address where id= "+userID;
       if(connection!=null) {
           resultSet = BaseBao.execute(connection, pstm, resultSet, sql, paras);
           while (resultSet.next()) {
               GoodInCar goodInCar = new GoodInCar();
               goodInCar.setAddressDesc(resultSet.getString("addressDesc"));
               goodInCar.setGoodNumber(resultSet.getInt("goodNumber"));
               goodInCar.setCreationDate(resultSet.getDate("creationDate"));
               goodInCar.setGoodID(resultSet.getInt("goodId"));
               goodInCar.setGoodPrice(resultSet.getDouble("goodPrice"));
               goodInCar.setGoodName(resultSet.getString("goodName"));
               shoppingList.add(goodInCar);
           }
           BaseBao.closeResource(null, pstm, resultSet);
       }
        return  shoppingList;



    }

    @Override
    public Good getGoodByID(Connection connection, Integer goodID) {

        return null;
    }
}
