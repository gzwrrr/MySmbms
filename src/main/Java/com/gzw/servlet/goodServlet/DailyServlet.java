package com.gzw.servlet.goodServlet;

import com.gzw.pojo.Good;
import com.gzw.service.good.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DailyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
//        int goodId = Integer.parseInt(req.getParameter("goodId"));

        if (method != null && method.equals("page")){
            this.getDailyList(req,resp,"daily.jsp");
        }else if (method != null && method.equals("GoodsList")){
//            this.toBuyPage(req,resp,goodId);
        }


    }

    public void getDailyList(HttpServletRequest req, HttpServletResponse resp, String pageUrl) throws ServletException, IOException {
        // 商品列表
        List<Good> normalGoodList = new ArrayList<>();
        List<Good> hotGoodList = new ArrayList<>();

        // 获取商品列表
        GoodServiceImpl goodService = new GoodServiceImpl();
//        normalGoodList = goodService.getList(area,offOrNot);
//        hotGoodList = goodService.getList(area,offOrNot);

        // 给前端传值
        req.setAttribute("dailyGoodList",normalGoodList);
        req.setAttribute("dailyHotGoodList",hotGoodList);
        // 跳转到商城页面
        req.getRequestDispatcher(pageUrl).forward(req, resp);
    }


    public void toBuyPage(HttpServletRequest req, HttpServletResponse resp, int goodId) throws ServletException, IOException {
        req.getRequestDispatcher("buyPage.jsp").forward(req,resp);
    }
}
