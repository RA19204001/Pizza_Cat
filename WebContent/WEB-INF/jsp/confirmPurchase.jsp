<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>購入の確認</title>

</head>
<body>
<%

%>
<form method="post" action="pay">
	<table>
	<tr><th>商品名</th><th>値段</th><th>数量</th></tr>
	<c:forEach var="product" items="${result}">
	<tr><td>${product.name }</td><td>${puroduct.price}</td><td>${product.amount }</td></tr>
	</c:forEach>
	<tr><th>合計金額</th><td>${ }</td></tr>
	</table>
    <input type='submit' value='支払い'>
</form>
</body>
</html>