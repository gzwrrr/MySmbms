package com.gzw.servlet.user;

import com.gzw.pojo.User;
import com.gzw.service.user.UserServiceImpl;
import com.gzw.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//用户注册的Servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("register")){
            this.register(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        // String userRole = req.getParameter("userRole");

        // 创建用户对象
        User user = new User();
        // 设置属性
        user.setUserCode(userName);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            if (birthday==null){
                user.setBirthday(new Date());
            }
            else {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(3);
        user.setCreationDate(new Date());
        user.setCreatedBy(3);

        // 将user对象写入数据库
        UserServiceImpl userService = new UserServiceImpl();
        req.setAttribute("error","注册成功!");


        if(userService.add(user)){
//            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/register.jsp");
        }



//        //以下是可选信息 他们在jsp中的name值都一致才能使用getParameterValues()
//        Object[] obj=req.getParameterValues("options");
//        UserServiceImpl userService = new UserServiceImpl();
//        HttpSession session = req.getSession();

//        if (userService.checkUserCode(userCode) == true && userCode != null) {
//
//            if (!userPassword.equals(userPassword2) || userPassword == null || userPassword2 == null)
//                session.setAttribute("message", "密码不一致或为空，请重新输入");
//            else userService.registUser(userCode, userPassword,obj);
//        }
//        else session.setAttribute("message", "用户名重复或为空，请重新输入");
    }
}
