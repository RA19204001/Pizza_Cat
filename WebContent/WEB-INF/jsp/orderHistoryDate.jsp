<!--浅倉 2/28  -->
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
	<table>
		<form method="post" action="displayOrderHistory">
				<tr><th>注文番号</th><th>注文日</th></tr>
			<c:forEach var="history" items="${result.orderHistoryList}">
				<tr>
				<td>
					${history.order_id}
				</td>
				<td>
					<input type="submit" value="${history.order_date}">
					<input type="hidden" name="order_id" value="${history.order_id}">
				</td>
				</tr>
			</c:forEach>
		</form>
	</table>
</body>
</html>