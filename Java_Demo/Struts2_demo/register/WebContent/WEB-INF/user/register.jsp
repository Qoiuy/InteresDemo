<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<s:fielderror></s:fielderror>
	<form action="${pageContext.request.contextPath}/register" method="post">
	 <div>
                用户名：<input type="text" name="username" value="${username}"/>
        </div>
        <div>
                密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" value="请输入密码"/>
        </div>
        <div>
                邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="email" value="${email }"/>
        </div>
        <div>
                电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="telphone" value="${ telphone}"/>
        </div>
        <div>
                <input type="submit" value="注册"/>
        </div>
	</form>
</body>
</html>