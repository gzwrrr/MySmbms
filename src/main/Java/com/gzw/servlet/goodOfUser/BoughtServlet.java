package com.gzw.servlet.goodOfUser;

import com.alibaba.fastjson.JSONArray;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodsOfUser;
import com.gzw.pojo.User;
import com.gzw.service.good.GoodServiceImpl;
import com.gzw.service.user.UserServiceImpl;
import com.gzw.util.Constants;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BoughtServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("bought".equals(method)){
            this.bought(req,resp);
        }else if("toBoughtPage".equals(method)){
            this.toBoughtPage(req,resp);
        }else if("confirmBuy".equals(method)){
            this.confirmBuy(req,resp);
        }
    }

    private void confirmBuy(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String goodName = req.getParameter("goodName");
        String goodPrice = req.getParameter("goodPrice");
        String goodNumber = req.getParameter("goodNumber");
        String userPassword = req.getParameter("userPassword");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        String goodId = req.getParameter("goodId");

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserById(String.valueOf(userId));
        String userTruePwd = user.getUserPassword();
        if (!userPassword.equals(userTruePwd)){
            req.setAttribute("error","pwdFail");
        }else {
            // 密码正确则加入到购买列表
            GoodsOfUser goodsOfUser = new GoodsOfUser();
            goodsOfUser.setContact(address);
            goodsOfUser.setTel(phone);
            goodsOfUser.setGoodId(Integer.valueOf(goodId));
            goodsOfUser.setGoodName(goodName);
            goodsOfUser.setGoodPrice(Double.valueOf(goodPrice));
            goodsOfUser.setGoodNumber(Integer.valueOf(goodNumber));
            goodsOfUser.setUserId(userId);

            GoodServiceImpl goodService = new GoodServiceImpl();
            boolean flag = goodService.confirmBuy(goodsOfUser,goodId);
            boolean flagTwo = goodService.decreaseQuantity(goodNumber,goodId);
            if (flag&&flagTwo){
                req.setAttribute("add","success");
                req.getRequestDispatcher("bought.jsp").forward(req,resp);
            }else {
                req.setAttribute("error","pwdFail");
                req.getRequestDispatcher("bought.jsp").forward(req,resp);
            }
        }


    }

    private void toBoughtPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodName = req.getParameter("goodName");
        String goodPrice = req.getParameter("goodPrice");
        String goodNumber = req.getParameter("goodNumber");
        String goodId = req.getParameter("goodId");

        req.setAttribute("goodName",goodName);
        req.setAttribute("goodPrice",goodPrice);
        req.setAttribute("goodNumber",goodNumber);
        req.setAttribute("goodId",goodId);
        req.getRequestDispatcher("bought.jsp").forward(req,resp);
    }

    private void bought(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 万能的map,原生结果集
        Map<String, String> resultMap = new HashMap<String, String>();

        resultMap.put("result","true");

        try {
            resp.setContentType("application/json");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(JSONArray.toJSONString(resultMap));
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
