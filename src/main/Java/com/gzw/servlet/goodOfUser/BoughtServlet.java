package com.gzw.servlet.goodOfUser;

import com.gzw.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class BoughtServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private void bought(HttpServletRequest req, HttpServletResponse resp) {
        // 获取前端传回的值
        String goodId = req.getParameter("");
        String goodName = req.getParameter("");
        String goodPrice = req.getParameter("");
        String url = req.getParameter("");
        String quantity = req.getParameter("");
        String area = req.getParameter("");
        String desc = req.getParameter("");
        String offOrNot = req.getParameter("");

        Good good = new Good();
        // 设置商品的属性
        good.setGoodID(Integer.valueOf(goodId));
        good.setGoodName(goodName);
        good.setGoodPrice(Double.valueOf(goodPrice));
        good.setUrl(url);
        good.setCreatedDate(new Date());
        good.setCreatedBy((Integer) req.getSession().getAttribute("userId"));
        good.setArea(Integer.valueOf(area));
        good.setDesc(desc);
        good.setOffOrNot(Integer.valueOf(offOrNot));
        good.setQuantity(Integer.valueOf(quantity));


    }
}
