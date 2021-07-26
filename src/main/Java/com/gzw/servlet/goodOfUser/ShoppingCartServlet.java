package com.gzw.servlet.goodOfUser;

import com.alibaba.fastjson.JSONArray;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodInCar;
import com.gzw.pojo.User;
import com.gzw.service.bill.BillService;
import com.gzw.service.bill.BillServiceImpl;
import com.gzw.service.good.GoodServiceImpl;
import com.gzw.service.user.UserServiceImpl;
import com.gzw.servlet.goodServlet.DailyServlet;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("shoppingCart".equals(method)){
            try {
                this.shoppingCart(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("toCart".equals(method)){
            this.showCartlist(req,resp);
        }else if ("toBuyPage".equals(method)){
            try {
                this.toBuyPage(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("del".equals(method)){
            this.delCartItem(req,resp);
        }
    }

    private void delCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String goodName = req.getParameter("goodName");
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        String payOrNot = req.getParameter("payOrNot");

        GoodServiceImpl goodService = new GoodServiceImpl();
        boolean flag = goodService.deleteGoodInCar(goodName,userId,Integer.valueOf(payOrNot));
        if (flag) {
            req.setAttribute("del","success");
        }else {
            req.setAttribute("del","fail");
        }
        this.showCartlist(req,resp);
    }

    private void toBuyPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
        String goodId = req.getParameter("goodId");
        new DailyServlet().toBuyPage(req,resp,goodId);
    }

    private void showCartlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        GoodServiceImpl goodService = new GoodServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        List<GoodInCar> shoppingCartList = goodService.getGoodList(userId,1);
        List<GoodInCar> boughtList = goodService.getGoodList(userId,2);
        User user = userService.getUserById(String.valueOf(userId));
        req.setAttribute("userName",user.getUserName());
        req.setAttribute("gender",user.getGender());
        req.setAttribute("birthday",user.getBirthday());
        req.setAttribute("phoneNumber",user.getPhone());
        req.setAttribute("address",user.getAddress());
        req.setAttribute("shoppingCartList",shoppingCartList);
        req.setAttribute("boughtList",boughtList);


        if (shoppingCartList!=null){
            req.getRequestDispatcher("shoppingCart.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("buyPage.jsp").forward(req,resp);
        }
    }

    private void shoppingCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        /*
            goodId:"goodId",
            goodName:"goodName",
            goodPrice:"goodPrice",
            goodNumber:"goodNumber",
            addressDesc:"addressDesc",
            goodUrl:"goodUrl"
        */
        String goodId = req.getParameter("goodId");
        String goodName = req.getParameter("goodName");
        String goodPrice = req.getParameter("goodPrice");
        String goodNumber = req.getParameter("num");
        String addressDesc = req.getParameter("addressDesc");
        String goodUrl = req.getParameter("goodUrl");


        GoodInCar goodInCar = new GoodInCar();
        goodInCar.setGoodID(Integer.valueOf(goodId));
        goodInCar.setGoodName(goodName);
        goodInCar.setGoodPrice(Double.valueOf(goodPrice));
        goodInCar.setGoodNumber(Integer.valueOf(goodNumber));
        goodInCar.setAddressDesc(addressDesc);
        goodInCar.setUrl(goodUrl);
        goodInCar.setIsPayment(1);
        goodInCar.setCreationDate(new Date());
        goodInCar.setUserId((Integer) req.getSession().getAttribute("userId"));

        System.out.println(goodInCar);
        GoodServiceImpl goodService  =new GoodServiceImpl();
        boolean flag = goodService.addGoodIntoCar(goodInCar);
        if (flag) {
            req.setAttribute("added","success");
        }else {
            req.setAttribute("added","fail");
        }
        new DailyServlet().toBuyPage(req,resp,goodId);

    }
}
