<!--浅倉 2/28  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/displayOrderHistory.css">
<script type="text/javascript">
	$(function(){
	    var price = document.getElementsByClassName("price");
	    var amount = document.getElementsByClassName("amount");
	    var total = 0;
	    for (var i = 0;i < price.length; i++){
	    	total += (Number(price[i].textContent) * Number(amount[i].textContent));
	    }
	    var result = document.getElementById("total");
	    result.innerHTML = total;
	});
</script>
<title>注文履歴詳細</title>
</head>
<body>
<div id="log">
	<h1><a href="/PizzaCat/" id="moji"><img src="css/image/iconlogo.png"></a></h1>
	<h2>注文履歴</h2>
	<h3>合計金額</h3>
	<h3><span id="total"></span>円</h3>

	<table class="border">
	<tr><th>注文日</th><th>商品名</th><th>個数</th><th>値段</th></tr>

	<c:forEach var="history" items="${result.orderHistoryList}">
	<tr><td>${history.order_date}</td><td>${history.product_name}</td>
		<td class="amount">${history.product_amount}</td><td class="price">${history.product_price}</td>
		</tr>
	</c:forEach>
	</table>


	<form method="post" action="orderHistoryDate">
	   <br><br><input type="submit" value="戻る" class="btn2">
	   <input type="hidden" name="user_number" value="${sessionScope.loginuser.number}">
	</form>
	</div>
</body>
</html>