package com.gzw.servlet.goodServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VegetableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        int goodId = Integer.parseInt(req.getParameter("goodId"));

        if (method != null && method.equals("page")){
            new DailyServlet().getDailyList(req,resp,"vegetable.jsp");
        }else if (method != null && method.equals("GoodsList")){
            new DailyServlet().toBuyPage(req,resp,goodId);
        }
    }

}
