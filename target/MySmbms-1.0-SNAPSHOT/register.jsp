<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css" />
</head>
<body>
<div id="head">
    用户注册
</div>
<div id="body">
    <div id="register-box">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/register.do">
            <input name="method" value="register" class="input-text" type="hidden">
            <span>填写信息</span>
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="user-common" id="uList-2">
                <label for="userName">用户名称：</label>
                <input type="text" name="userName" id="userName" value="">
                <font color="red"></font>
            </div>
            <div class="user-common" id="uList-3">
                <label for="userPassword">用户密码：</label>
                <input type="password" name="userPassword" id="userPassword" value="">
                <font color="red"></font>
            </div>
            <div class="user-common" id="uList-4">
                <label for="ruserPassword">确认密码：</label>
                <input type="password" name="ruserPassword" id="ruserPassword" value="">
                <font color="red"></font>
            </div>
            <div class="user-common" id="uList-5">
                <label >用户性别：</label>
                <select name="gender" id="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </div>
            <div class="user-common" id="uList-6">
                <label for="birthday">出生日期：</label>
                <input type="text" Class="Wdate" id="birthday" name="birthday"
                       readonly="readonly" onclick="WdatePicker();">
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
                <input type="button" name="add" id="add" value="注册">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="js/time.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/common.js" charset="utf-8"></script>
<script type="text/javascript" src="calendar/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="js/register.js" charset="utf-8"></script>
</html>
