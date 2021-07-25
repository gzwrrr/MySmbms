package com.gzw.dao.goodInCar;

import com.gzw.pojo.GoodInCar;

import java.sql.Connection;
import java.util.List;

public interface GoodInCarDao {
    // 添加商品
    int add(Connection connection, GoodInCar goodInCar);

    // 删除商品
    int delete(Connection connection, GoodInCar goodInCar);

    // 修改商品信息
    int modify(Connection connection, GoodInCar goodInCar);

    // 根据条件获取商品列表
    List<GoodInCar> getGoodInCarList(Connection connection, GoodInCar goodInCar);
}
