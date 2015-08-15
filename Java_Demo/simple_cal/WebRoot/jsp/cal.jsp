<%@page import="Util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Util.CookieUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>个位数加法计数器</h1>
	<table>
	<a href="/demo/d?num=0"><button>0</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=1"><button>1</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=2"><button>2</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=3"><button>3</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=4"><button>4</button></a> &nbsp;&nbsp;&nbsp;
	<br/>
	<a href="/demo/d?num=5"><button>5</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=6"><button>6</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=7"><button>7</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=8"><button>8</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=9"><button>9</button></a> &nbsp;&nbsp;&nbsp;
	<br/>
	<a href="/demo/d?num=sum"><button>sum</button></a> &nbsp;
	<a href="/demo/d?num=BAK"><button>BAK</button></a> &nbsp;&nbsp;&nbsp;
	<a href="/demo/d?num=CE"><button>CE</button></a> &nbsp;&nbsp;&nbsp;
	<h2>按键记录</h2>
	<%
	
	Cookie cookie = CookieUtil.findCookie(request.getCookies(), "num");
	if(cookie == null){
	
	 %>
	 <h3>没有数据 显示个毛线~</h3>
	 <%
	 	}
	 	else{
	 	%>
	 	<%=cookie.getValue() %>
	 	<% 
	 	
	 	}
	 	
	  %>
	  
	  
	</table>
</body>
</html>