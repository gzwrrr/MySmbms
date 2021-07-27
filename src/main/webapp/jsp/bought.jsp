<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/bought.css" />
</head>
<body onload="judgeBuy()">
<div id="head">
    购买商品
</div>
<div id="body">
    <div id="register-box">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/jsp/bought.do?method=confirmBuy&goodName=${goodName}&goodPrice=${goodPrice}&goodNumber=${goodNumber}&goodId=${goodId}">
            <input name="method" value="register" class="input-text" type="hidden">
            <span>确认购买</span>
            <div class="good-info">
                <ul>
                    <li>商品名称：${goodName}</li>
                    <li>商品价格：${goodPrice}</li>
                    <li>购买数量：${goodNumber}</li>

                </ul>
            </div>

            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="user-common" id="uList-3">
                <label for="userPassword">账户密码：</label>
                <input type="password" name="userPassword" id="userPassword" value="">
                <font color="red"></font>
            </div>
            <div class="user-common" id="uList-7">
                <label for="phone">用户电话：</label>
                <input type="text" name="phone" id="phone" value="">
                <font color="red"></font>
            </div>
            <div class="user-common" id="uList-8">
                <label for="address">用户地址：</label>
                <input name="address" id="address"  value="">
            </div>
            <div class="providerAddBtn user-common" id="uList-10">
<%--                <input type="hidden" name="goodId" value="${goodId}">--%>
                <input type="submit" name="add" id="add" value="确定">
                <input type="button" id="back" name="back" value="返回">
                <input type="hidden" id="error" name="error" value="${error}">
                <input type="hidden" id="addGood" name="error" value="${add}">
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/time.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bought.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/buyPage.js" charset="utf-8"></script>
</html>
