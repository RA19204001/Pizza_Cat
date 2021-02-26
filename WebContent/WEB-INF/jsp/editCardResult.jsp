<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="bean.Card" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/editCardResult.css">
<title>カード情報の変更完了</title>
</head>
<body>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<%
try{
	Card card = (Card)(request.getAttribute("result"));
	if(card != null){
		session.setAttribute("loginuser",card);
	}
}catch(ClassCastException e){}
%>
<h1>カード情報の変更完了</h1>
<form method='post' action='add'>
</form>

<p id="botom"><a href="/PizzaCat/" class="btn">TOPへ</a></p>
</body>
</html>