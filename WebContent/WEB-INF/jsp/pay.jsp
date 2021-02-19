<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支払い完了しました</title>
<%
session.setAttribute("cart",null);
%>
</head>
<body>
<h1>購入完了しました</h1>
<h2><table>
	<tr><th>商品名</th><th>値段</th><th>数量</th></tr>
	<c:forEach var="product" items="${result.list}">
	<tr><td>${product.name}</td><td>${product.price}</td><td>${product.amount}</td></tr>
	</c:forEach>
	</table></h2>
<h2>${result.total}</h2>
<p><a href="/PizzaCat/">TOPへ</a></p>
</body>
</html>