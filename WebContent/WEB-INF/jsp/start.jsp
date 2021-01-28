<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head><title>PizzaCat</title></head>
<body>
<%
	session.setAttribute("loginuser",request.getAttribute("result"));
%>
<h1>会員登録をしてね</h1>
<p><a href="addUser">会員登録画面へ</a></p>
<p><a href="login">ログイン</a></p>
<p><a href="logout">ログアウト</a></p>
<p><a href="editUser">ユーザー情報の編集</a></p>
<p>${sessionScope.loginuser.id}でログイン中</p>
</body>
</html>
