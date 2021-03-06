<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td><a href="index.jsp"><img src="images/logo.png"
					width="95" height="30" border="0" /> </a></td>
			<td style="text-align:right"><img src="images/cart.gif"
				width="26" height="23" style="margin-bottom:-4px" />&nbsp;
				<c:if test="${empty user}">
				<a href="product_list.jsp">商品列表</a> &nbsp; | &nbsp; 
				<a href="#">帮助中心</a> &nbsp; | &nbsp;
				<a href="login.jsp">登录账户</a> &nbsp; | &nbsp;
				<a href="register.jsp">新用户注册</a>
				</c:if>
				
				<c:if test="${not empty user}">
				<a href="cart.jsp">购物车</a> &nbsp; | &nbsp; 
				<a href="product_list.jsp">商品列表</a> &nbsp; | &nbsp; 
				<a href="myAccount.jsp">您好: ${user.username} </a> &nbsp; | &nbsp; 
				<a href="/BookStore/user?method=logout">注销</a> 
				</c:if>
				</td>
		</tr>
	</table>
</div>