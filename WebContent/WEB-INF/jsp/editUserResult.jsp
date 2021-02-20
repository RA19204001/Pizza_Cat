<!--浅倉 1/29  -->
<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="bean.User" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/editUserResult.css">
<title>ユーザー情報の変更完了</title>
</head>
<body>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6">PizzaCat</font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<%
try{
	User user = (User)(request.getAttribute("result"));
	if(user != null){
		session.setAttribute("loginuser",user);
	}
}catch(ClassCastException e){}
%>
<h1>ユーザー情報の変更完了</h1>
<form method='post' action='add'>
</form>

<p id="botom"><a href="/PizzaCat/" class="btn">TOPへ</a></p>
</body>
</html>