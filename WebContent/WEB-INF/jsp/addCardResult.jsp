<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カード追加完了</title>
</head>
<body>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6">PizzaCat</font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<h1>${result.message}</h1>
<form method='post' action='add'>

</form>

<p><a href="/PizzaCat/">TOPへ</a></p>

</body>
</html>