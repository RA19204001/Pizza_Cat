<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="bean.Sales"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	try{
		Sales sales = (Sales)request.getAttribute("result");
	}catch(ClassCastException e){
		request.setAttribute("result",null);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>売り上げ</h1>
	<p>表示期間を選択</p>
	<form action="showSales" method="post">
		<input type="date" name="startDate" required/>から
		<input type="date" name="endDate" required/>まで
		<br />
		<input type="submit" value="表示">
	</form>
	<table border="1">
	<tr>
	<th>注文日</th><th>注文番号</th><th>注文者番号</th><th>注文者名</th><th>注文詳細番号</th>
	<th>商品紐付け番号</th><th>商品ID</th><th>商品名</th><th>カテゴリ</th><th>値段</th><th>数量</th>
	</tr>

	<c:forEach var="i" items="${result.saleList}">
	<tr>
	<td>${i.order_date}</td><td>${i.order_id}</td><td>${i.user_number}</td><td>${i.user_name}</td>
	<td>${i.orderdetail_id}</td><td>${i.custom_id}</td><td>${i.product_id}</td><td>${i.product_name}</td>
	<td>${i.product_category}</td><td>${i.product_price}</td><td>${i.product_amount}</td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>