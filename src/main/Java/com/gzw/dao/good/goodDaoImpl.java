package com.gzw.dao.good;

import com.gzw.dao.BaseBao;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.Provider;
import com.gzw.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class goodDaoImpl implements  goodDao{
    @Override
    //管理员上架商品
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
    //显示用户的购物车内容
    public List<GoodInCar> getGoodList(Connection connection, Integer userID)throws  SQLException {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        List<GoodInCar> shoppingList = new ArrayList<GoodInCar>();
        Object [] paras= {userID};
        String sql="select addressDesc,creationDate,goodId,goodNumber,goodName,goodPrice from smbms_address where id= ?";
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
               goodInCar.setUrl(resultSet.getString("url"));
               shoppingList.add(goodInCar);
           }
           BaseBao.closeResource(null, pstm, resultSet);
       }
        return  shoppingList;
    }

    @Override
    //显示单个商品的信息
    //当参数为null时显示全部商品
    public Good getGoodByID(Connection connection, Integer goodID)throws SQLException {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        Good good=null;
        Object [] paras= {goodID};
        String sql;
        if(goodID!=null)
            sql="select *  from smbms_good where goodId= ?";
        else sql="select * from smbms_good ";
        if(connection!=null)
        {
            resultSet = BaseBao.execute(connection, pstm, resultSet, sql, paras);
            while (resultSet.next()) {

                good.setGoodID(resultSet.getInt("goodId"));
                good.setGoodName(resultSet.getString("goodName"));
                good.setGoodPrice(resultSet.getDouble("goodPrice"));
                good.setCreatedDate(resultSet.getDate("createdDate"));
                good.setCreatedBy(resultSet.getInt("createdBy"));
                good.setUrl(resultSet.getString("url"));
            }
            BaseBao.closeResource(null, pstm, resultSet);
        }
        return  good;

    }



    @Override
    //添加商品到购物车
    //paras中的参数
    //contact~tel 是通过表单提交获取
    //createdBy~userId通过Id查询用户信息获取
    //goodName~url 通过页面getArribute获取
    public boolean addGoodIntoCar(Connection connection , Object []paras)throws SQLException
    {
        PreparedStatement pstm = null;
        int flag = 0;
        if(null != connection){
            String sql = "insert into smbms_address (contact,addressDesc,postCode,tel,createdBy,creationDate," +
                    "userId,goodName,goodId,goodNumber,goodPrice,url)" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            flag = BaseBao.execute(connection, sql, paras,pstm);
            BaseBao.closeResource(null, pstm, null);
        }

        if(flag>0)
        return  true;
        else return false;
    }

}
