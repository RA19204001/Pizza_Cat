<!--浅倉 2/28  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link rel="stylesheet" type="text/css" href="css/orderHistoryDate.css">
		<meta charset="UTF-8">

		<!-- タブアイコン設定 -->
		<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
		<title>注文履歴一覧</title>
	</head>
	<body>
    	<header>
            <p><a href="/PizzaCat/" id="moji"><img src="css/image/iconlogo.png"></a></p>
            <p class="username">${sessionScope.loginuser.id}様</p>
        </header>
		<h1>注文履歴</h1>
		<br>
		<div id="log">
			<table border="1" class="table">
					<tr><th>注文番号</th><th>注文日(クリックで詳細)</th><th>支払い方法</th></tr>
				<c:forEach var="history" items="${result.orderHistoryList}">
					<form method="post" action="displayOrderHistory">
						<tr>
						<td>
							${history.order_id}
						</td>
						<td>
							<input type="submit" value="${history.order_date}" class="lololl">
							<input type="hidden" name="order_id" value="${history.order_id}">
						</td>
						<td>
						  ${history.order_payment}
						</td>
						</tr>
					</form>
				</c:forEach>
			</table>
			<br>
			<a href="/PizzaCat/" class="btn2">戻る</a>
		</div>
	</body>
</html>