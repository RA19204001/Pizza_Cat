<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="bean.User" %>
<html>
<head><title>PizzaCat</title></head>
<body>
<%
try{
	User user = (User)(request.getAttribute("result"));
	if(user != null){
		session.setAttribute("loginuser",user);
	}
}catch(ClassCastException e){}
%>
<h1>会員登録をしてね</h1>
<p><a href="addUser">会員登録画面へ</a></p>
<p><a href="login">ログイン</a></p>
<p><a href="logout">ログアウト</a></p>
<p><a href="editUser">ユーザー情報の編集</a></p>
<p>${sessionScope.loginuser.id}でログイン中</p>
</body>
</html>
