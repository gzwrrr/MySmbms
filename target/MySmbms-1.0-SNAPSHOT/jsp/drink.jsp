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
            <img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20210316-135953-1ba4.png?x-oss-process=image/resize,w_900/interlace,1,image/format,webp" >
        </div>
        <div id="hotSale-Text">
    <pre>
    爱品质，爱生活。

    追求生活品质，共享绿色丝锐。

    纯天然匠心打造。健康快乐生活，

    丝锐品质雕琢。

    你想要的，丝锐为你一一呈现。

    日用百货集散地，丝锐品质心演绎。
    </pre>
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
