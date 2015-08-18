<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录</h1>
<h2>${msg }</h2>
	<form action="/day12/login" method="post" onsubmit="return checkUser()">
	username:<input type="text" name="username" id="usernameid"/>
	<br/>
	password:<input type="text" name="password" id="passwordid"/>
	<br/>
	<input  type="submit" value="login"/>
	
	</form>

</body>

<script type="text/javascript">

	function checkUser(){
	
		var username = document.getElementById("usernameid").value;
		var password = document.getElementById("passwordid").value;
		
		if (username == ""){
		alert("username 不能为空");
			return false;
		}
		if (password == ""){
		alert("password 不能为空");
			return false;
		}
		return true;
	}
</script>
</html>