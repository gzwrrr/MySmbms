package com.gzw.service.good;

import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface goodService {
    //上架商品到数据库
    public boolean add(Good good) throws Exception;
    //删除数据库内上架的商品
    public boolean delete(Good good);
    //通过商品Id获取货物
    public Good getGoodByID(Integer goodID);
    //付款与取消付款,付款退款是对购物车内所有物品进行操作
    public boolean pay(Integer userId,Integer payOrNot);
    //将商品加入购物车
    public boolean addGoodIntoCar(Object []paras);
    //将商品从购物车内删除
    public boolean deleteGoodInCar(String goodName,Integer userId) ;
    //通过userId 查找smbms_address表中含有该userID的行，去查找其productId,查smbms_good表
    //需要smbms_address :addressDesc,productNumber，creationDate,productId
    // smbms_good :goodName，goodPrice
    //Object[] 是集合以上五个字段的数组，指的是用户购物车里单个商品信息
    //得到用户的购物车清单

    public  List<GoodInCar> getGoodList(Integer userID);


}
