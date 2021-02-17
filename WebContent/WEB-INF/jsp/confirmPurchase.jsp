<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>購入の確認</title>

<!-- JavaScriptの読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
 $(function(){
	    var price = document.getElementsByClassName("price");
	    var total = 0;
	    for (var i = 0;i < price.length; i++){
	    	total += Number(price[i].textContent);
		console.log(price[i].textContent);
	    }
	    var result = document.getElementById("result");
	    result.innerHTML = total;

 });
</script>
</head>
<body>

<form method="post" action="pay">
	<input type='text' name='user_number' required value="${sessionScope.loginuser.number}">
	<table>
	<tr><th>順番</th><th>商品名</th><th>値段</th><th>商品番号</th><th>数量</th></tr>
	<c:forEach var="product" items="${sessionScope.cart}" varStatus="status">
	<tr><td><input type='text' name="custom_id" required value="${status.count}">(${status.count})</td>
	<td><input type='text' name="name" required value="${product.name}">${product.name}</td>
	<td class="price"><input type='text' name="price" required value="${product.price}">${product.price}</td>
	<td><input type='text' name="id" required value="${product.id}">${product.id}</td>
	<td><input type='text' name="amount" required value="${product.amount}">${product.amount}</td></tr>

	</c:forEach>
	</table>
	<h3>合計金額</h3><br>
	<p id="result"></p>
    <input type='submit' value='支払い'>
</form>




</body>
</html>