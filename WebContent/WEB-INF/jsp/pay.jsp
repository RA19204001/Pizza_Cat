<!--大川 2/20 css -->
<!--浅倉 2/27-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/result.css">
		<!-- タブアイコン設定 -->
		<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
		<title>支払い完了しました</title>
		<%
		session.setAttribute("cart",null);
		session.setAttribute("cr",null);
		%>
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
		    result.innerHTML = "\\"+total;

		    var inputresult = document.getElementsByClassName("total");
		    inputresult.value=total;


		});
		</script>
	</head>
	<body>
		<header>
	        <p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
	        <p class="username">${sessionScope.loginuser.id}様</p>
        </header>
		<h1>購入が確定しました</h1>
		<br>
		<div id="log">
			<h2>
				<table class="table">
					<tr><th>商品名</th><th>数量</th><th>値段</th></tr>
					<c:forEach var="product" items="${result.list}">
					    <tr><td>${product.name}</td><td>${product.amount}</td><td>${product.price}</td></tr>
					</c:forEach>
				</table>
			</h2>
			<p>----------------------------------------------</p>
			<h2>合計&emsp;&emsp;&emsp;￥${result.total}</h2><br>
			<input type="hidden" name="total" class="total">
			<p><a href="/PizzaCat/" class="btn">TOPへ</a></p>
		</div>
    </body>
</html>