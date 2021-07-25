<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/jsp/common/homePageHead.jsp"%>
    <div id="location">
        日用品区
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
            <c:if goods="${dailyGoodList != null }">
                <c:forEach var="good" items="${dailyGoodList}">
                    <div id="goods-normal">
                        <div class="good-normal">
                            <div class="normal-img">
                                <img src="${good.url}" alt="">
                            </div>
                            <div class="normal-text"><span class="normal-text-one">${good.goodName}</span>
                                <span class="normal-text-two">good.describe</span>
                            </div>
                            <div class="normal-likeAndBuy">
                                <div class="normal-like-icon">价格：${good.price}</div>
                                <div class="normal-goodCount">剩余数量:${good.count}</div>
                                <a href="${pageContext.request.contextPath }/jsp/daily.do?method=normalGoodsList"><div class="normal-buy-text">购买 ></div></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <div class="title" id="goods-discount-title">
                优惠商品
            </div>
            <c:if goods="${dailyHotGoodList != null }">
            <c:forEach var="good" items="${dailyHotGoodList}">
            <div id="goods-discount">
                <div class="discount-box">
                    <div class="discount-img">
                        <img src="${good.url}" >
                    </div>
                    <div class="discount-text">
                        <div class="discount-good-text">
                            <span class="discount-title">${good.goodName}</span>
                            <span class="discount-info">${good.describe}</span>
                        </div>
                        <div class="discount-likeAndBuy">
                            <span class="discount-like">价格：${good.price}</span>
                            <span class="discount-count">剩余数量：${good.count}</span>
                            <a href="${pageContext.request.contextPath }/jsp/daily.do?method=discountGoodsList"><span class="discount-buy">购买 ></span></a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<%@include file="/jsp/common/homePageFoot.jsp"%>
