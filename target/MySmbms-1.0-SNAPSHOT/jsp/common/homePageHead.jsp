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
    <div class="y-center"  id="market-icon"></div>
    <div class="center" id="title"><span id="market-text">SuperMarket</span></div>
    <div class="y-center" id="logout-box"><input class="button" type="button" name="logout" id="logout-button" value="注销" /></div>
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
                <%--                <c:forEach var="provider" items="${providerList}">--%>
                <%--                    <option <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>--%>
                <%--                            value="${provider.id}">${provider.proName}</option>--%>
                <%--                </c:forEach>--%>
                <li class="one">
                    <a href="#"><img src="https://tse1-mm.cn.bing.net/th/id/R-C.75578939363586c71a96b64e7fda535a?rik=lGzx7CYPPPuuuQ&riu=http%3a%2f%2fwww.dnzhuti.com%2fuploads%2fallimg%2f161104%2f95-1611041A954.jpg&ehk=iBgM2mUyHjM2RkRm2n0ZGSeXtLE6%2ffG9Dua2TQV7sw4%3d&risl=&pid=ImgRaw" alt=""></a>
                </li>
                <li class="two">
                    <a href="#" ><img src="https://tse1-mm.cn.bing.net/th/id/R-C.98455b29ded70af025bd69579686fc6a?rik=%2fli3I88Kacojlg&riu=http%3a%2f%2fpicture.ik123.com%2fuploads%2fallimg%2f200317%2f12-20031G02004.jpg&ehk=X%2bwRGNBs56n20adp04RvSER%2fwK4RGLS6y8n1Em5yaJM%3d&risl=&pid=ImgRaw" alt=""></a>
                </li>
                <li class="three">
                    <a href="#"><img src="https://img.zcool.cn/community/01c807554b60cb000001bf7221cfec.jpg@1280w_1l_2o_100sh.jpg" alt=""></a>
                </li>
                <li class="four">
                    <a href="#"><img src="https://tse1-mm.cn.bing.net/th/id/R-C.b5c8839c98978a7670ebddee3a4720ae?rik=IRmCyjUMV7h2dg&riu=http%3a%2f%2fpicture.ik123.com%2fuploads%2fallimg%2f160720%2f3-160H0161433.jpg&ehk=N42t2Vdc9VwZgm%2b2P4RyY9M29aYajnP2feQtjFTTfgI%3d&risl=&pid=ImgRaw" alt="" class="rose"></a>
                </li>
                <li class="five">
                    <a href="#"><img src="https://img.zcool.cn/community/01c807554b60cb000001bf7221cfec.jpg@1280w_1l_2o_100sh.jpg" alt=""></a>
                </li>
                <li class="six">
                    <a href="#"><img src="https://tse1-mm.cn.bing.net/th/id/R-C.b5c8839c98978a7670ebddee3a4720ae?rik=IRmCyjUMV7h2dg&riu=http%3a%2f%2fpicture.ik123.com%2fuploads%2fallimg%2f160720%2f3-160H0161433.jpg&ehk=N42t2Vdc9VwZgm%2b2P4RyY9M29aYajnP2feQtjFTTfgI%3d&risl=&pid=ImgRaw" alt="" class="rose"></a>
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
                <div class="introduce-icon-box">
                    <img src="" >
                </div>
                <div class="introduce-text-box">
							<span class="introduce-text-one">
								天然有机产品
							</span>
                    <span class="introduce-text-Two">
								xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
							</span>
                </div>
            </li>
            <li>
                <div class="introduce-icon-box">
                    <img src="" >
                </div>
                <div class="introduce-text-box">
							<span class="introduce-text-one">
								天然有机产品
							</span>
                    <span class="introduce-text-Two">
								xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
							</span>
                </div>
            </li>
            <li>
                <div class="introduce-icon-box">
                    <img src="" >
                </div>
                <div class="introduce-text-box">
							<span class="introduce-text-one">
								天然有机产品
							</span>
                    <span class="introduce-text-Two">
								xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
							</span>
                </div>
            </li>
        </ul>
    </div>
    <div id="main">
        <div id="select-box">
            <ul>
                <a href="${pageContext.request.contextPath }/jsp/drink.do?method=page"><li>饮料区</li></a>
                <a href="${pageContext.request.contextPath }/jsp/daily.do"><li>日用品区</li></a>
                <a href="${pageContext.request.contextPath }/jsp/vegetable.do"><li>蔬菜水果</li></a>
            </ul>
        </div>