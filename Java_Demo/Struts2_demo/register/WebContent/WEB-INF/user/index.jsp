<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 主页</title>
</head>
<body>
<s:fielderror></s:fielderror>
	<c:if test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/loginUI">登录</a>
		<a href="${pageContext.request.contextPath }/registerUI">注册</a>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		欢迎你：${sessionScope.user.username }
		<a href="${pageContext.request.contextPath }/logout">注销</a>
	</c:if>
	<h1>这是主页</h1>
	<form action="${pageContext.request.contextPath }/converte" method="post">
	
		<h2>接下来做的是类型转换的提示</h2>
        <h2>大体上需要转换的类型大概有日期</h2>
        <s:fielderror></s:fielderror>
        
        <div>
        	日期:<input type="text" name="days" value="${days }"/>
        </div>
        <div>
                <input type="submit" value="提交"/>
        </div>
	</form>
</body>
</html>