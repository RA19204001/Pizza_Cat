<!--浅倉 2/3  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>商品一覧</title></head>
<body>
<form method="post" action="">
<table>
<c:forEach var="menu" items="${result.list}">
<p>${menu.name}</p>
<p>${menu.image}</p>
<p>${menu.explanation}</p>
<p>${menu.price}</p>
</c:forEach>
</table>
</form>

<p><a href="/PizzaCat/">TOPへ</a></p>

</body>
</html>