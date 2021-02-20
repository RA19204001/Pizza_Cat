<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/addCardResult.css">
<title>カード追加完了</title>
</head>
<body>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6">PizzaCat</font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<h1>${result.message}</h1>

<p id="botom"><a href="/PizzaCat/" class="btn">TOPへ</a></p>

</body>
</html>