<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/shoppingCart.css" />
</head>
<body onload="judge()">
<div id="head">
    个人信息
    <a id="back" href="${pageContext.request.contextPath }/jsp/daily.do?method=page">返回首页</a>
</div>
<div id="body">
    <div id="left">
        <div class="title" id="p-info">
            个人信息
        </div>
        <div id="p-context">
            <ul>
                <li>姓名：${userName}</li>
                <li>性别：${gender}</li>
                <li>生日：${birthday}</li>
                <li>电话号码：${phoneNumber}</li>
                <li>住址：${address}</li>
            </ul>
        </div>
    </div>
    <div id="mid">
        <div class="title" id="cart">
            购物车
        </div>
        <c:forEach var="cart" items="${shoppingCartList}">
            <div class="card-frame cart-item">
                <div class="cart-img">
                    <img src="${cart.url}" alt="">
                </div>
                <div class="cart-right">
                    <ul>
                        <li>${cart.goodName}</li>
                        <li>价格：${cart.goodPrice}</li>
                        <li>数量：${cart.goodNumber}</li>
                        <li>时间：${cart.creationDate}</li>
                    </ul>
                </div>
                <div class="read">
                    <a id="buy" href="${pageContext.request.contextPath }/jsp/bought.do?method=toBoughtPage&goodName=${cart.goodName}&goodPrice=${cart.goodPrice}&goodNumber=${cart.goodNumber}&goodId=${cart.goodID}">购买</a>
                    <a onclick="return del();" class="delete" href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=del&goodName=${cart.goodName}&payOrNot=1">删除</a>
                    <a href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=toBuyPage&goodId=${cart.goodID}" class="look">查看 ></a>
                    <input type="hidden" name="del" id="del" value="${del}" />
                </div>
            </div>
        </c:forEach>

    </div>
    <div id="right">
        <div class="title" id="bought">
            已购买
        </div>
        <c:forEach var="good" items="${boughtList}">
            <div class="card-frame cart-item">
                <div class="cart-img">
                    <img src="${good.url}" alt="">
                </div>
                <div class="cart-right">
                    <ul>
                        <li>${good.goodName}</li>
                        <li>价格：${good.goodPrice}</li>
                        <li>数量：${good.goodNumber}</li>
                        <li>时间：${good.creationDate}</li>
                    </ul>
                </div>
                <div class="read">

<%--                    <a onclick="return del();" class="delete" href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=del&goodName=${good.goodName}&payOrNot=2">删除</a>--%>
                    <a href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=toBuyPage&goodId=${good.goodID}" class="look">查看 ></a>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/time.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/shoppingCart.js" charset="utf-8"></script>
</html>