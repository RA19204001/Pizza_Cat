<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <link rel="stylesheet" type="text/css" href="css/editCard.css">
		<meta charset="UTF-8">
		<title>カード情報確認</title>
	</head>
	<body>
        <header>
            <p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
            <p class="username">${sessionScope.loginuser.id}様</p>
        </header>
		<h1>カード情報の確認</h1>
		<h2>カード情報の登録は１枚までです</h2>
		<h2>変更したい場合はカード登録からお願いします</h2>
		<div id="log">
			<c:forEach var="card" items="${result.cardInfo}" ><br>
			    クレジットカード番号(数字)<br><p>${card.creditnumber}</p><br>
			    <!-- セキュリティ番号<br><p>${card.security_code}</p><br> -->
			    有効期限<br><p>${card.expiration_date}</p><br>
			    メールアドレス<br><p>${card.mail_address}</p><br>
			</c:forEach>
		</div>
		<div id="btn23">
		<a href="/PizzaCat/editUser" class="btn">戻る</a>
		</div>
	</body>
</html>