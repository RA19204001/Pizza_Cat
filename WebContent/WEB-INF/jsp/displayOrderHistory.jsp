<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注文履歴</h1>
	<table border = "1">
	<tr><th>注文日</th><th>商品名</th><th>個数</th><th>値段</th><th>配達状況</th></tr>
	<c:forEach var="history" items="result.orderHistoryList">
	<tr><td>${history.order_date}</td><td>${history.product_name}</td>
		<td>${history.product_amount}</td><td>${history.product_price}</td>
		<td>${history.order_delivery}</td></tr>
	</c:forEach>
	</table>
</body>
</html>