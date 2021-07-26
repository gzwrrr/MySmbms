package com.gzw.servlet.goodServlet;

import com.gzw.pojo.Comment;
import com.gzw.pojo.Good;
import com.gzw.pojo.GoodsImgUrl;
import com.gzw.service.comment.CommentServiceImpl;
import com.gzw.service.good.GoodServiceImpl;
import com.gzw.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DailyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String goodId = req.getParameter("goodId");
        String commentId = req.getParameter("commentId");

        if (method != null && method.equals("page")){
            this.getDailyList(req,resp,"daily.jsp");
        }else if (method != null && method.equals("GoodsList")){
            try {
                this.toBuyPage(req,resp,goodId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (method != null && method.equals("del")){
            try {
                this.delComment(req,resp,commentId,"buyPage.jsp",goodId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (method != null && method.equals("addComment")){
            try {
                this.addComment(req,resp,goodId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    private void addComment(HttpServletRequest req, HttpServletResponse resp,String goodId) throws SQLException, ServletException, IOException {
        Comment comment = new Comment();
        // 从前端获取数据
        String star = req.getParameter("star");
        String cContent = req.getParameter("cContent");
        comment.setContent(cContent);
        comment.setStars(Integer.valueOf(star));
        comment.setLikes(5);
        comment.setGoodId(Integer.valueOf(goodId));
        comment.setUserId((Integer) req.getSession().getAttribute("userId"));

        // 添加评论
        CommentServiceImpl commentService = new CommentServiceImpl();
        commentService.add(comment);
        this.toBuyPage(req,resp,goodId);

    }

    private void delComment(HttpServletRequest req, HttpServletResponse resp, String commentId, String pageUrl, String goodId) throws ServletException, IOException, SQLException {
        CommentServiceImpl commentService = new CommentServiceImpl();
        commentService.delete(commentId);
        req.setAttribute("deleted","success");
        this.toBuyPage(req,resp,goodId);
    }

    public void getDailyList(HttpServletRequest req, HttpServletResponse resp, String pageUrl) throws ServletException, IOException {
        // 商品列表
        List<Good> normalGoodList = null;
        List<Good> hotGoodList = null;

        // 获取商品列表
        GoodServiceImpl goodService = new GoodServiceImpl();
        normalGoodList = goodService.getGoodsInPage(1,1);
        hotGoodList = goodService.getGoodsInPage(2,1);

        // 给前端传值
        req.setAttribute("dailyGoodList",normalGoodList);
        req.setAttribute("dailyHotGoodList",hotGoodList);
        System.out.println(normalGoodList);
        req.setAttribute("msg","成功！");

        // 跳转到商城页面
        req.getRequestDispatcher(pageUrl).forward(req, resp);
    }


    public void toBuyPage(HttpServletRequest req, HttpServletResponse resp, String goodId) throws ServletException, IOException, SQLException {
        GoodServiceImpl goodService = new GoodServiceImpl();
        Good good = goodService.getGoodByID(goodId);
        // 设置商品的属性
        req.setAttribute("title",good.getGoodName());
        req.setAttribute("price",good.getGoodPrice());
        req.setAttribute("count",good.getQuantity());
        req.setAttribute("commentCount",good.getQuantity());
        req.setAttribute("desc",good.getDesc());
        req.setAttribute("goodId",goodId);
        req.setAttribute("url",good.getUrl());

        // 返回评论
        CommentServiceImpl commentService = new CommentServiceImpl();
        List<Comment> commentList = commentService.query(goodId);
        req.setAttribute("commentsList",commentList);


        // 返回图片列表
        List<GoodsImgUrl> urlsList = goodService.getUrlById(Integer.valueOf(goodId));
        req.setAttribute("urlsList",urlsList);

        req.getRequestDispatcher("buyPage.jsp").forward(req,resp);
    }
}
