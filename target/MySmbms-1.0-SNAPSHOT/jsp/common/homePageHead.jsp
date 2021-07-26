<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/homePage.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/slide.js" charset="utf-8"></script>
</head>
<body>

<div id="head">
    <div class="center" id="title"><span id="market-text">SuperMarket</span></div>
    <div class="y-center" id="logout-box">
        <a href="${pageContext.request.contextPath }/jsp/shoppingCart.do?method=toCart"><input class="button" type="button" name="logout" value="购物车" /></a>
        <a href="${pageContext.request.contextPath }/login.jsp"><input class="button" type="button" name="logout" id="logout-button" value="注销" /></a></div>
</div>
<div id="home">
    <!-- 轮播图 -->
    <div id="slideshow-box">
        <!-- 左侧按钮 -->
        <a href="javascript:;" class="y-center left">&lt</a>
        <!-- 右侧按钮 -->
        <a href="javascript:;" class="y-center right">&gt</a>
        <!-- 轮播图片 -->
        <form method="get" action="${pageContext.request.contextPath }/jsp/slide.do">
            <ul class="center imgs" >
                <li class="one">
                    <a href="#"><img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20200618-095314-8a86.png?x-oss-process=image/resize,w_563/interlace,1,image/format,webp" alt=""></a>
                </li>
                <li class="two">
                    <a href="#" ><img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20191213-144108-6932.png?x-oss-process=image/resize,w_675/interlace,1,image/format,webp" alt=""></a>
                </li>
                <li class="three">
                    <a href="#"><img src="https://st-gdx.dancf.com/templets/65271/shots/20191216-164203-j2Egd.png?x-oss-process=image/resize,w_563/interlace,1,image/format,webp" alt=""></a>
                </li>
                <li class="four">
                    <a href="#"><img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20191211-192259-692b.png?x-oss-process=image/resize,w_563/interlace,1,image/format,webp" alt="" class="rose"></a>
                </li>
                <li class="five">
                    <a href="#"><img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20191216-173223-fd31.png?x-oss-process=image/resize,w_675/interlace,1,image/format,webp" alt=""></a>
                </li>
                <li class="six">
                    <a href="#"><img src="https://st-gdx.dancf.com/gaodingx/0/uxms/design/20200211-172651-8cfe.png?x-oss-process=image/resize,w_563/interlace,1,image/format,webp" alt="" class="rose"></a>
                </li>
            </ul>
        </form>

        <!-- 小圆圈 -->
        <ul class="list"></ul>
        <!-- 两个空盒子，实现左右两侧图片点击效果 -->
        <div class="rights"></div>
        <div class="lefts"></div>
    </div>
    <!-- 轮播图结束 -->
    <div id="introduce-box">
        <ul>
            <li>
                <div class="introduce-icon-box" id="tianran">
                </div>
                <div class="introduce-text-box" >
							<span class="introduce-text-one">
								天然有机产品
							</span>
                    <span class="introduce-text-Two">
								无公害，纯绿色，健康
							</span>
                </div>
            </li>
            <li>
                <div class="introduce-icon-box" id="manyi">
                </div>
                <div class="introduce-text-box">
							<span class="introduce-text-one" >
								人性化服务
							</span>
                    <span class="introduce-text-Two">
								客户体贴态度优良，为您提供良好的购物体验
							</span>
                </div>
            </li>
            <li>
                <div class="introduce-icon-box" id="zaixian">
                </div>
                <div class="introduce-text-box">
							<span class="introduce-text-one">
								24小时在线
							</span>
                    <span class="introduce-text-Two">
								便捷，快速，高效
							</span>
                </div>
            </li>
        </ul>
    </div>
    <div id="main">
        <div id="select-box">
            <ul>
                <a href="${pageContext.request.contextPath }/jsp/drink.do?method=page"><li>饮料区</li></a>
                <a href="${pageContext.request.contextPath }/jsp/daily.do?method=page"><li>日用品区</li></a>
                <a href="${pageContext.request.contextPath }/jsp/vegetable.do?method=page"><li>蔬菜水果</li></a>
            </ul>
        </div>