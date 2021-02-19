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
	    var amount = document.getElementsByClassName("amount");
	    var total = 0;
	    for (var i = 0;i < price.length; i++){
	    	total += (Number(price[i].textContent) * Number(amount[i].textContent));
		console.log(price[i].textContent);
	    }
	    var result = document.getElementById("result");
	    result.innerHTML = total;
	    var inputresult = document.getElementById("total");
	    inputresult.value=total;

 });
</script>
</head>
<body>

<form method="post" action="pay">
	<input type='hidden' name='user_number' required value="${sessionScope.loginuser.number}">
	<table>
	<tr><th>商品名</th><th>値段</th><th>商品番号</th><th>数量</th></tr>
	<c:forEach var="product" items="${sessionScope.cart}" varStatus="status">
	<input type='hidden' name="custom_id" required value="${status.count}">
	<tr>
	<td><input type='hidden' name="name" required value="${product.name}">${product.name}</td>
	<td class="price"><input type='hidden' name="price" required value="${product.price}">${product.price}</td>
	<td><input type='hidden' name="id" required value="${product.id}">${product.id}</td>
	<td class="amount"><input type='hidden' name="amount" required value="${product.amount}">${product.amount}</td></tr>
	</c:forEach>
	</table>
	<input type="hidden" name="custamid" value="${product.custamid}">
	<h3>合計金額</h3><br>
	<p id="result"></p>
	<input type="hidden" name="total" id="total">
    <input type='submit' value='支払い'>
</form>


<!-- <p><a style="color:#FFEEFF;" href="/PizzaCat/menu">戻る</a></p> -->

</body>
</html>