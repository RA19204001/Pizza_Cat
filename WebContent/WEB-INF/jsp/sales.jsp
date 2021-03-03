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
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">

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
</head>
<body>
	<h1>売り上げ</h1>
	<p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>
	<p>表示期間を選択</p>
	<form action="showSales" method="post">
		<input type="date" name="startDate" required/>から
		<input type="date" name="endDate" required/>まで
		<br />
		<input type="submit" value="表示">
	</form>
	<p>この期間での売り上げ</p>
	<span id="total"></span>円
	<table border="1">
	<tr>
	<th>注文日</th><th>注文番号</th><th>注文者番号</th><th>注文者名</th><th>注文詳細番号</th>
	<th>商品紐付け番号</th><th>商品ID</th><th>商品名</th><th>カテゴリ</th><th>値段</th><th>数量</th><th>支払い方法</th>
	</tr>

	<c:forEach var="i" items="${result.saleList}">
	<tr>
	<td>${i.order_date}</td><td>${i.order_id}</td><td>${i.user_number}</td><td>${i.user_name}</td>
	<td>${i.orderdetail_id}</td><td>${i.custom_id}</td><td>${i.product_id}</td><td>${i.product_name}</td>
	<td>${i.product_category}</td><td class="price">${i.product_price}</td><td class="amount">${i.product_amount}</td>
	<td>${i.order_payment}</td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>