<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/jsp/common/homePageHead.jsp"%>
<div id="location">
    饮料区
</div>
<div id="all-goods">
    <div id="hotSale-box">
        <div id="hotSale-img">
            <img src="https://tse1-mm.cn.bing.net/th/id/R-C.a6d8bce8060522c71a59cb5db27ccdd0?rik=vXuQI4BTSXQaBg&riu=http%3a%2f%2fimage.qianye88.com%2fpic%2f8dbc8d8dd6376795a936662dd4c03155&ehk=yA1izoxl4DOxTIar6P9K%2bcNwMGzU0BWZdbZE6LAS9Ts%3d&risl=&pid=ImgRaw" >
        </div>
        <div id="hotSale-Text">
                <textarea rows="12" cols="35" style="overflow: hidden;">
                    经过严格人工筛选的蔬菜
                    纯天然匠心打造。经过严格人工筛选的蔬菜
                    纯天然匠心打造。
                    经过严格人工筛选的蔬菜
                    纯天然匠心打造。经过严格人工筛选的蔬菜
                    纯天然匠心打造。
                    经过严格人工筛选的蔬菜
                    纯天然匠心打造。经过严格人工筛选的蔬菜
                    纯天然匠心打造。
                    经过严格人工筛选的蔬菜
                    纯天然匠心打造。经过严格人工筛选的蔬菜
                    纯天然匠心打造。
                </textarea>
        </div>
    </div>
    <div id="goods-box">
        <div class="title" id="goods-normal-title">
            挑你喜欢
        </div>
        <div id="goods-normal">
            <c:forEach var="good" items="${dailyGoodList}" varStatus="status">
                <div class="good-normal">
                    <div class="normal-img">
                        <img src="${good.url}" alt="">
                    </div>
                    <div class="normal-text"><span class="normal-text-one">${good.goodName}</span>
                        <span class="normal-text-two">${good.desc}</span>
                    </div>
                    <div class="normal-likeAndBuy">
                        <div class="normal-like-icon">价格：${good.goodPrice}</div>
                        <div class="normal-goodCount">剩余数量:${good.quantity}</div>
                        <a href="${pageContext.request.contextPath }/jsp/daily.do?method=GoodsList&goodId=${good.goodID}"><div class="normal-buy-text">购买 ></div></a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="title" id="goods-discount-title">
            优惠商品
        </div>
        <div id="goods-discount">
            <c:forEach var="good" items="${dailyHotGoodList}" varStatus="status">
                <div class="discount-box">
                    <div class="discount-img">
                        <img src="${good.url}" >
                    </div>
                    <div class="discount-text">
                        <div class="discount-good-text">
                            <span class="discount-title">${good.goodName}</span>
                            <span class="discount-info">${good.desc}</span>
                        </div>
                        <div class="discount-likeAndBuy">
                            <span class="discount-like">价格：${good.goodPrice}</span>
                            <span class="discount-count">剩余数量：${good.quantity}</span>
                            <a href="${pageContext.request.contextPath }/jsp/daily.do?method=GoodsList&goodId=${good.goodID}"><span class="discount-buy">购买 ></span></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>

<%@include file="/jsp/common/homePageFoot.jsp"%>
