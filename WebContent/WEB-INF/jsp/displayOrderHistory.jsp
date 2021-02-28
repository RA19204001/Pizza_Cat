<!--浅倉 2/28  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
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
<title>Insert title here</title>
</head>
<body>
	<h1>注文履歴</h1>
	<p>合計金額</p>
	<span id="total"></span>円

	<table border = "1">
	<tr><th>注文日</th><th>商品名</th><th>個数</th><th>値段</th></tr>

	<c:forEach var="history" items="${result.orderHistoryList}">
	<tr><td>${history.order_date}</td><td>${history.product_name}</td>
		<td class="amount">${history.product_amount}</td><td class="price">${history.product_price}</td>
		</tr>
	</c:forEach>
	</table>


	<form method="post" action="orderHistoryDate">
	   <input type="submit" value="注文履歴">
	   <input type="hidden" name="user_number" value="${sessionScope.loginuser.number}">
	</form>
</body>
</html>