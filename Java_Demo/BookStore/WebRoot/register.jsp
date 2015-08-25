<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	
	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/register"
			method="post"  onsubmit="return checkForm();">
			<table width="850px" border="0" cellspacing="0">
				<h2>${msg }</h2>
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right;width:20%">会员邮箱</td>
								<td><input type="text" name="mail" id="mail"
									class="txtinput"></td>
								<td><td><span id="mail_msg"></span></td>
							</tr>

							<tr>
								<td style="text-align:right;">会员名</td>
								<td><input type="text" name="username" id="username"
									class="txtinput">
								</td>
								<td><span id="username_msg"></span>
								</td>
							</tr>

							<tr>
								<td style="text-align:right;">密码</td>
								<td><input type="password" name="password" id="password"
									class="txtinput"></td>
								<td><span id="password_msg"></span>
								</td>
							</tr>

							<tr>
								<td style="text-align:right;">重复密码</td>
								<td><input type="password" id="repassword"
									name="repassword" class="txtinput">
								</td>
								<td><span id="repassword_msg"></span>
								</td>
							</tr>

							<tr>
								<td style="text-align:right;width:20%">性别</td>
								<td colspan="2"><input type="radio" name="sex" value="男"
									checked>男&nbsp;&nbsp;<input type="radio" name="sex"
									value="女">女</td>

							</tr>

							<tr>
								<td style="text-align:right;width:20%">联系电话</td>
								<td colspan="2"><input type="text" name="phone"
									class="txtinput" style="width:350px;">
								</td>

							</tr>

							<tr>
								<td style="text-align:right;width:20%">个人介绍</td>
								<td colspan="2"><textarea name="descript" class="txtarea"></textarea>
								</td>
							</tr>
						</table>

						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" name="code" class="textinput" id="codeid" onblur="ajax_code();"  />
								</td>
								<td>&nbsp;<span id="ajax_code"></span></td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/code" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>

						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="images/signup.gif" name="submit" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>

<script type="text/javascript">

	//验证码异步验证
	function ajax_code(){
		var code = document.getElementById("codeid").value;
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.onreadystatechange=function() {
			if(xmlhttp.readyState == 4) {
				if(xmlhttp.status == 200) {
					var data = xmlhttp.responseText;
					if(data != "true"){
						document.getElementById("ajax_code").innerHTML = "<font color='#999999'>验证码输入错误</iifont>";
						changeImage();
						return false;
					}
					else{
						document.getElementById("ajax_code").innerHTML = "<font color='#999999'>验证码输入正确</iifont>";
						return true;
					}
				}
			}
		};
		xmlhttp.open("POST","${pageContext.request.contextPath}/ajaxRegister",true) ;
		xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("code="+code);
	}
	
	//判断异步操作返回值
	function linshi(){
		if(data == "true")
			alert("true");
		else
			alert("false");
	}
	//ajax必备函数
	function  createXmlHttpRequest(){
		   var xmlHttp;
		   try{    //Firefox, Opera 8.0+, Safari
		           xmlHttp=new XMLHttpRequest();
		    }catch (e){
		           try{    //Internet Explorer
		                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		            }catch (e){
		                  try{
		                          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		                  }catch (e){}  
		           }
		    }
		   return xmlHttp;
		 }
	//开不清换一张的实现
	function changeImage() {
		document.getElementById("img").src = "${pageContext.request.contextPath}/code?time="
				+ new Date().getTime();
	}

	function checkForm() {
		//在操作前，将xxx_msg中的信息清空
		document.getElementById("mail_msg").innerHTML="";
		document.getElementById("username_msg").innerHTML="";
		document.getElementById("password_msg").innerHTML="";
		document.getElementById("repassword_msg").innerHTML="";

		//验证email不为空
		var emailvalue = document.getElementById("mail").value;
		if (checkNull(emailvalue)) {
			document.getElementById("mail_msg").innerHTML = "<font color='#999999'>邮箱不能为空</iifont>";
			return false;
		}
		//验证会员名
		var usernamevalue = document.getElementById("username").value;
		if (checkNull(usernamevalue)) {
			document.getElementById("username_msg").innerHTML = "<font color='#999999'>会员名不能为空</font>";
			return false;
		}
		//密码员名
		var passwordvalue = document.getElementById("password").value;
		if (checkNull(passwordvalue)) {
			document.getElementById("password_msg").innerHTML = "<font color='#999999'>密码不能为空</font>";
			return false;
		}
		//重复密码验证
		var repasswordvalue = document.getElementById("repassword").value;
		if (checkNull(repasswordvalue)) {
			document.getElementById("repassword_msg").innerHTML = "<font color='#999999'>重复密码不能为空</font>";
			return false;
		}
		//验证邮箱格式
		if (!checkEmail(emailvalue)) {
			document.getElementById("mail_msg").innerHTML = "<font color='#999999'>邮箱格式不正确</font>";
			return false;
		}
		//验证长度
		if(!checkLength(usernamevalue)){
			document.getElementById("username_msg").innerHTML = "<font color='#999999'>会员名长度必须6位以上</font>";
			return false;
		}

		if(!checkLength(passwordvalue)){
			document.getElementById("password_msg").innerHTML = "<font color='#999999'>密码长度必须6位以上</font>";
			return false;
		}
		//验证密码与重复密码一致
		if(passwordvalue!=repasswordvalue){
			document.getElementById("repassword_msg").innerHTML = "<font color='#999999'>两次密码输入不一致</font>";
			return false;
		}
		return true;
	};

	//验证长度
	function checkLength(value) {
		var reg = /^(\w){6,}$/;
		return reg.test(value);
	}

	//验证邮箱操作
	function checkEmail(value) {
		var reg = /^(\w)+@(\w)+(\.\w+)+$/;
		return reg.test(value);
	};

	//提取一个非空校验的函数
	function checkNull(value) {
		//1.声明非空校验的正则
		var reg = /^\s*$/; //0个或多个空白符
		return reg.test(value);
	};
</script>

</html>
