<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!-- お届け先 -->

<html>
	<head>
		<meta charset="UTF-8">
		<title>注文一覧</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script>
		function check(){

			if(window.confirm('削除しますか？')){
				return true;
			}else{
				return false;
			}
		}

			$(function(){
				var button=document.getElementsByClassName("button");
				var flag=document.getElementsByClassName("flag");
				console.log(flag.l)
				for(var i=0;i<flag.length;i++){
					console.log(flag[i]);
					if(flag[i].value=="true"){
						var buttonhide=button[i];
						buttonhide.style.display="none";
					}
				}

			});

		</script>
	</head>
	<body>
	   <p>注文一覧</p>
	   <p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>
	   <table border="1">
	   <tr><th>注文番号</th><th>注文者</th><th>カスタムid</th><th>商品名</th><th>個数</th><th>住所</th><th>配達状況</th><th>配達終了</th><th>支払い方法</th></tr>
			<c:forEach var="order" items="${result.addresseeList}">
				<form method="post" action="doneDelivery"  onSubmit="return check()" >
					<tr><td>${order.order_id}</td><td>${order.user_name}</td><td>${order.custom_id}</td><td>${order.product_name}</td>
					<td>${order.product_amount}</td><td>${order.user_address}</td><td>${order.order_delivery}</td>
					<td><input type="submit" value="配達終了" class="button"></td>
					<td>${order.order_payment}</td></tr>
					<input type="hidden" name="order_id" value="${order.order_id}">
					<input type="hidden" value="${order.order_delivery}" class="flag">
				</form>
			</c:forEach>
		</table>
	</body>
</html>