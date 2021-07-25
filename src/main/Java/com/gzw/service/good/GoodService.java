package com.gzw.service.good;

import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface GoodService {
    //上架商品到数据库
    public boolean add(Good good) throws Exception;

    //删除数据库内上架的商品
    public boolean delete(Good good);

    //修改所上架商品的信息
    public boolean modify(Good good);

    //通过商品Id获取货物
    public Good getGoodByID(Integer goodID);

    //付款与取消付款,付款退款是对购物车内所有物品进行操作，payornot=1改为未付款状态，改为2是已付款状态
    public boolean payOrNot(List<GoodInCar> goodInCarList, Integer payOrNot);

    //购物车/已购买清单的商品信息在smbms_address表 :addressDesc,productNumber，creationDate,productId,goodName，goodPrice
    //Object[]paras 是集合以上五个字段的数组，指的是用户购物车里单个商品信息
    //将商品加入购物车
    public boolean addGoodIntoCar(GoodInCar goodInCar);

    //将商品从购物车内/已付款订单内删除
    //payornot=1删除购物车内，改为2删除已付款清单
    public boolean deleteGoodInCar(String goodName, Integer userId,Integer payOrNot);

    //得到用户的购物车清单/已购买清单,payornot=1是未付款，2是已付款，未付款是购物车，已付款是已购买清单
    public List<GoodInCar> getGoodList(Integer userID, Integer payOrNot);

    //得到首页3X2个区域的商品List
    public List<Good>getGoodsInPage(Integer area,Integer offOrNot);



}
