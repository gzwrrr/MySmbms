<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView" id="view">
            <p><strong>1.用户编号：</strong><span>${user.userCode }</span></p>
            <p><strong>2.用户名称：</strong><span>${user.userName }</span></p>
            <p><strong>3.用户性别：</strong>
            	<span>
            		<c:if test="${user.gender == 1 }">男</c:if>
					<c:if test="${user.gender == 2 }">女</c:if>
				</span>
			</p>
            <p><strong>4.出生日期：</strong><span>${user.birthday }</span></p>
            <p><strong>5.用户电话：</strong><span>${user.phone }</span></p>
            <p><strong>6.用户地址：</strong><span>${user.address }</span></p>
            <p><strong>7.用户角色：</strong><span>${user.userRoleName}</span></p>
			<div class="providerAddBtn" id="view-button">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userview.js"></script>