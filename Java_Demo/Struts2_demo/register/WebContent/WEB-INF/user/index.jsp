<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 主页</title>
</head>
<body>
	<c:if test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/loginUI">登录</a>
		<a href="${pageContext.request.contextPath }/registerUI">注册</a>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		欢迎你：${sessionScope.user.username }
		<a href="${pageContext.request.contextPath }/logout">注销</a>
	</c:if>
	<h1>这是主页</h1>
</body>
</html>