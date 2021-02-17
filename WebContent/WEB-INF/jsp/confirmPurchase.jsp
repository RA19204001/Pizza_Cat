<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>購入の確認</title>
<script>
 $(function(){
	    var price = document.getElementsByClassName("price");
	    var amount = document.getElementsByClassName("amount");
	    var total = 0;
	    for (var i = 0;i <= price.length; i++){
	    	total += price * amount;
	    }

	    var result = document.getElementId("result");
	    result.value = total;

 });
</script>
</head>
<body>
<%

%>
<form method="post" action="pay">
	<table>
	<tr><th>商品名</th><th>値段</th><th>数量</th></tr>
	<c:forEach var="product" items="${result}">
	<tr><td>${product.name }</td><td class="price">${puroduct.price}</td><td class="amount">${product.amount}</td></tr>

	</c:forEach>
	</table>
	<h3>合計金額</h3><br>
	<label id="result"></label>
    <input type='submit' value='支払い'>
</form>
</body>
</html>