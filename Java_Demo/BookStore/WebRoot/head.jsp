<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td><a href="index.jsp"><img src="images/logo.png"
					width="95" height="30" border="0" /> </a></td>
			<td style="text-align:right"><img src="images/cart.gif"
				width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a
				href="cart.jsp">购物车</a> | <a href="#">帮助中心</a> 
				| ${(empty sessionScope.user)?"<a href='login.jsp'>": "<a href='myAccount.jsp'>"}
				 ${(empty sessionScope.user)?'登录账户':sessionScope.user.username}</a>
				| ${(empty sessionScope.user)?"<a href='register.jsp'>新用户注册</a>":"<a href='/BookStore/logout'>注销</a>"}</td>
		</tr>
	</table>
</div>