<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/buyPage.css" />
</head>
<input type="hidden" id="deleted" value='${deleted}'>
<input type="hidden" id="added" name="added" value="${added}">
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }" />
<body onload="judgeDel()">
<div id="head">
    购买页面
</div>
<div id="body">
    <form name="shoppingCart" action="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=shoppingCart" method="post">
    <div id="good-detials">
        <div id="good-img">
            <img src="${url}" alt="">
        </div>
        <div id="good-info">
                <ul>
                    <li>${title}</li>
                    <li><div id="price-box"><span>价格:</span><span>${price}</span></div></li>
                    <li>剩余数量：${count}</li>
                    <li>评论数：${commentCount}</li>
                    <li>${desc}</li>
                    <li>
                        购买数量：
                        <div id="good-count">
                            <input class="button" id="sub" onclick="sub()" type="button" value="-"/>
                            <input type="text" id="num" name="num" value="1" />
                            <input class="button" id="plus" onclick="add()" type="button" value="+"/>
                        </div>件
                    </li>
                    <li><div id="good-buy">
                        <input id="bought" class="button" type="button" value="立即购买" />
                        <input id="shoppingCart" class="button" type="submit" value="加入购物车" />
                        <a href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=toCart"><input style="border: none" type="button" name="toCart" id="toCart" value="查看购物车" /></a>
                        <a href="${pageContext.request.contextPath }/jsp/daily.do?method=page"><input style="border: none" type="button" name="toCart" value="返回首页" /></a>
                        <input type="hidden" id="goodId" name="goodId" value="${goodId}">
                        <input type="hidden" id="goodName" name="goodName" value="${title}">
                        <input type="hidden" id="goodPrice" name="goodPrice" value="${price}">
                        <input type="hidden" id="addressDesc" name="addressDesc" value="${desc}">
                        <input type="hidden" id="goodUrl" name="goodUrl" value="${url}">
                    </div></li>
                </ul>
            </div>
    </div>
    </form>

    <div id="sign">
        图片/评论区
    </div>
    <div id="comment-box">

        <div id="good-imgs">
                <c:forEach var="goodsImgUrl" items="${urlsList}">
                    <div class="good-img">
                        <img src="${goodsImgUrl.url}" alt="">
                    </div>
                </c:forEach>
        </div>


        <div id="comment">
            <form action="${pageContext.request.contextPath }/jsp/daily.do?method=addComment&goodId=${goodId}" method="post">
                <div id="edit-comment-box">
                    <div id="star">
                        评分：
                        <select name="star">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <textarea rows="7" cols="58" name="cContent"></textarea>
                    <div id="writeDown">写下你的想法吧...</div>
                    <div id="edit-submit">
                        <input type="submit" value="提交" />
                    </div>
                </div>
            </form>
            <c:forEach var="comment" items="${commentsList}">
                    <div class="comment-item">
                        <div class="comment-left">
                            <span class="comment-text">${comment.content}</span>
                            <span class="comment-time">时间：xx-xx-xx</span>
                        </div>
                        <div class="comment-right">
                            <div id="star-text">
                                评分（5分满分）：${comment.stars}
                            </div>
                            <div class="comment-like">点赞数：xxx</div>
                            <div class="delete-button"><a href="${pageContext.request.contextPath }/jsp/daily.do?method=del&commentId=${comment.commentId}&goodId=${comment.goodId}" onclick="return del();"><input type="submit" class="delete" value="删除" /></a></div>
                        </div>
                    </div>
                </c:forEach>
        </div>
    </div>
</div>



<div id="footer">
    <div id="footer-box">
        <ul>
            <li>xxxxx</li>
            <li>xxxxxxxx</li>
            <li>xxxxx</li>
        </ul>
        <ul>
            <li>xxxx</li>
            <li>xxxxxxxxxx</li>
            <li>xxx</li>
        </ul>
        <ul>
            <li>xxx</li>
            <li>xxxxxxxx</li>
            <li>xxxx</li>
        </ul>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/time.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/buyPage.js" charset="utf-8"></script>
</html>
