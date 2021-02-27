<!--大川 2/20 css -->
<!--浅倉 2/27-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="bean.Products"%>
<%@ page import ="java.util.ArrayList"%>

<%
try{
Products pros = (Products)(request.getAttribute("result"));
ArrayList list = pros.getAddList();
if(list != null){
	//ArrayList array = (ArrayList)session.getAttribute("cart");

	//for(int i = 0;i<list.size();i++){
		//array.add(list.get(i));

	//}

	session.setAttribute("cart",list);

	}
}catch(ClassCastException e){

}
//else{
	//	session.setAttribute("cart",new ArrayList());
	//}


%>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/confim.css">
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
	    result.innerHTML = "\\"+total;

	    var inputresult = document.getElementsByClsaa("total");
	    inputresult.value=total;

	  //サイズと生地の削除ボタンを見えなくする
	    var cart_id=document.getElementsByClassName("cart_id");
	    for(let i =0;i<cart_id.length;i++){

		    	var hide=cart_id[i];
		    	console.log(hide.value);
		    	if(hide.value >= 10001 && hide.value<=10006){
		    		var deletebutton=document.getElementsByClassName("delete")[i];
		    		deletebutton.style.display="none";
		    	}

	    }

	    var card_flag = document.getElmentById("card_flag");
		if(card_flag.value==0){
			let card_btn = document.getElmentById("card_btn");
			card_btn.style.display="none";
		}

 });
function dis(){

	 	// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		if(window.confirm('このクレジットカードでよろしいですか？\n')){



		}
		// 「OK」時の処理終了

		// 「キャンセル」時の処理開始
		else{
			return false;
		}
		// 「キャンセル」時の処理終了

}
</script>
</head>
<body>

	<h1 style="color:#2c8005">購入の確認</h1>

	<table id="kakuninn">
	<tr><th>削除</th><th>商品名</th><th>値段</th><th>商品番号</th><th>数量</th></tr>
	<c:forEach var="product" items="${sessionScope.cart}" varStatus="status">
	<input type='hidden' name="custom_id" required value="${status.count}">
	<form method="post" action="deleteCart">
	<tr>
	<td><input type="submit" value="削除" id="saku" class="delete">
	<td><input type='hidden' name="name" required value="${product.name}">${product.name}</td>
	<td class="price"><input type='hidden' name="price" required value="${product.price}">${product.price}</td>
	<td><input type='hidden' name="id" required value="${product.id}">${product.id}</td>
	<td class="amount"><input type='hidden' name="amount" required value="${product.amount}">${product.amount}</td>
	<c:forEach var="cart" items="${sessionScope.cart}">
	          <input type="hidden" name="cart_name" value="${cart.name}">
	          <input type="hidden" name="cart_price" value="${cart.price}">
	          <input type="hidden" name="cart_id" value="${cart.id}">
	          <input type="hidden" name="cart_amount" value="${cart.amount}">
	          <input type="hidden" name="cart_custamid" value="${cart.custamid}">
	 </c:forEach>
	 <input type="hidden" name="delete_id" value="${product.id}" class="cart_id">
	 <input type="hidden" name="delete_custam_id" value="${product.custamid}">
	 <input type="hidden" name="flag" value="flag">
	</form>
	</tr>
	</c:forEach>
	</table>
<form method="post" action="pay">
	<c:forEach var="product" items="${sessionScope.cart}" varStatus="status">
		<input type='hidden' name="name" required value="${product.name}">
		<input type='hidden' name="price" required value="${product.price}">
		<input type='hidden' name='user_number' required value="${sessionScope.loginuser.number}">
		<input type="hidden" name="customid" value="${product.custamid}">
		<input type='hidden' name="id" required value="${product.id}">
		<input type='hidden' name="amount" required value="${product.amount}">
	</c:forEach>
	<h3>合計金額</h3><br>
	<p id="result" class="gra"></p>
	<input type="hidden" name="total" class="total">
    <input type='submit' value='現金で支払う' class="btn">
</form>
<form method="post" action="pay" onsubmit="return dis()">
	<c:forEach var="product" items="${sessionScope.cart}" varStatus="status">
		<input type='hidden' name="name" required value="${product.name}">
		<input type='hidden' name="price" required value="${product.price}">
		<input type='hidden' name='user_number' required value="${sessionScope.loginuser.number}">
		<input type="hidden" name="customid" value="${product.custamid}">
		<input type='hidden' name="id" required value="${product.id}">
		<input type='hidden' name="amount" required value="${product.amount}">
	</c:forEach>
	<input type="hidden" name="total" class="total">
    <input type='submit' value='クレジットカードで支払う' class="btn" id="card_btn">
    <input type="hidden" name="card_id" required value="${sessionScope.loginuser.card_id}" id="card_flag">
</form>

<a href="/PizzaCat/menu" class="btn2">戻&emsp;る</a>

</body>
</html>