<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="bean.User" %>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報の変更完了</title>
</head>
<body>
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

<p><a href="/PizzaCat/">TOPへ</a></p>
<p>${sessionScope.loginuser.id}でログイン中</p>
</body>
</html>