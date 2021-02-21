<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!-- お届け先 -->

<html>
	<head>
		<meta charset="UTF-8">
		<title>注文一覧</title>
	</head>
	<body>
	   <p>注文一覧</p>
	   <p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>
	   <table border="1">
	   <tr><th>注文者</th><th>カスタムid</th><th>商品名</th><th>個数</th><th>住所</th><th>配達状況</th></tr>
			<c:forEach var="order" items="${result.addresseeList}">
				<form method="post" action="doneDelivery">
					<tr><td>${order.user_name}</td><td>${order.custom_id}</td><td>${order.product_name}</td>
					<td>${order.product_amount}</td><td>${order.user_address}</td><td>${order.order_delivery}</td>
					<td><input type="submit" value="配達終了"></td></tr>
				</form>
			</c:forEach>
		</table>
	</body>
</html>