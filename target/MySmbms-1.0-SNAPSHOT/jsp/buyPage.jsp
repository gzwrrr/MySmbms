<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/buyPage.css" />
</head>
<body>
<div id="head">
    购买页面
</div>
<div id="body">
    <div id="good-detials">
        <div id="good-img">
            <img src="https://tse1-mm.cn.bing.net/th/id/R-C.75578939363586c71a96b64e7fda535a?rik=lGzx7CYPPPuuuQ&riu=http%3a%2f%2fwww.dnzhuti.com%2fuploads%2fallimg%2f161104%2f95-1611041A954.jpg&ehk=iBgM2mUyHjM2RkRm2n0ZGSeXtLE6%2ffG9Dua2TQV7sw4%3d&risl=&pid=ImgRaw" alt="">
        </div>
        <div id="good-info">
            <ul>
                <li>${title}</li>
                <li><div id="price-box">
                    <span>价格:</span>
                    <span>${price}</span>
                </div></li>
                <li>剩余数量：${count}</li>
                <li>评论数：${commentCount}</li>
                <li>${desc}</li>
                <li>
                    购买数量：
                    <div id="good-count">
                        <input class="button" id="sub" onclick="sub()" type="button" value="-" />
                        <input type="text" id="num" value="0" />
                        <input class="button" id="plus" onclick="add()" type="button" value="+" />
                    </div>
                    件
                </li>
                <li><div id="good-buy">
                    <input class="button" type="submit" value="立即购买" />
                    <input class="button" type="submit" value="加入购物车" />
                </div></li>
            </ul>
        </div>
    </div>
    <div id="sign">
        图片/评论区
    </div>
    <div id="comment-box">

        <div id="good-imgs">
            <c:if urls="${urlsList != null }">
                <c:forEach var="url" items="${urlsList}">
                    <div class="good-img">
                        <img src="${url}" alt="">
                    </div>
                </c:forEach>
            </c:if>
        </div>


        <div id="comment">
            <div id="edit-comment-box">
                <textarea rows="10" cols="58"></textarea>
                <span>写下你的想法吧...</span>
                <div id="edit-submit">
                    <input type="submit" value="提交" />
                </div>
            </div>

            <c:if comments="${commentsList != null }">
                <c:forEach var="comment" items="${commentsList}">
                    <div class="comment-item">
                        <div class="comment-left">
                            <span class="comment-text">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                            <span class="comment-time">时间：xx-xx-xx</span>
                        </div>
                        <div class="comment-right">
                            <span>评价/标签：</span>
                            <ul><li>好吃</li><li>便宜</li><li>推荐</li></ul>
                            <div class="comment-like">点赞数：xxx</div>
                            <div class="delete-button"><input type="submit" class="delete" value="删除" /></div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
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
<script type="text/javascript" src="../js/buyPage.js" charset="utf-8"></script>
</html>
