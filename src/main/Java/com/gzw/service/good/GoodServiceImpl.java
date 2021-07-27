package com.gzw.service.good;

import com.gzw.dao.BaseBao;
import com.gzw.dao.good.GoodDao;
import com.gzw.dao.good.GoodDaoImpl;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.GoodsImgUrl;
import com.gzw.pojo.GoodsOfUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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
    public Good getGoodByID(String goodID) {
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




    @Override
    public List<Good> getGoodsInPage(Integer area, Integer offOrNot) {
        Connection connection = null;
        List<Good> goodList = null;
        try {
            connection = BaseBao.getConnection();
            goodList = goodDao.getGoodsInPage(connection, area,offOrNot);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return goodList;
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
    public boolean deleteGoodInCar(String goodName, Integer userId,Integer payOrNot) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            if (goodDao.deleteGoodInCar(connection, goodName, userId,payOrNot))
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
    public List<GoodsImgUrl> getUrlById(Integer goodId) {
        Connection connection = null;
        List<GoodsImgUrl> url = null;
        try {
            connection = BaseBao.getConnection();
            url = goodDao.getUrlById(connection, goodId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseBao.closeResource(connection, null, null);
        }
        return url;
    }

    @Override
    public boolean decreaseQuantity(String decreaseNum, String goodId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            flag = goodDao.decreaseQuantity(connection,decreaseNum,goodId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseBao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Override
    public boolean confirmBuy(GoodsOfUser goodsOfUser, String goodId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseBao.getConnection();
            flag = goodDao.confirmBuy(connection,goodsOfUser,goodId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseBao.closeResource(connection,null,null);
        }
        return flag;
    }

    public static void main(String[] args) {
        GoodServiceImpl goodService = new GoodServiceImpl();
        GoodInCar goodInCar = new GoodInCar();
//        goodInCar.setUrl("xxx");
//        goodInCar.setAddressDesc("xxx");
//        goodInCar.setGoodNumber(2);
//        goodInCar.setGoodPrice(2.0);
//        goodInCar.setGoodName("xxx");
//        goodInCar.setGoodID(1);
//        goodInCar.setCreationDate(new Date());
//        goodInCar.setIsPayment(1);
//        System.out.println(goodService.addGoodIntoCar(goodInCar));
//        System.out.println(goodService.getGoodList(16,1));
//        System.out.println(goodService.getUrlById(1));

        System.out.println(goodService.decreaseQuantity("1","1"));
    }

}
