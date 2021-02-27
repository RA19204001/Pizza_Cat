<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カード情報確認</title>
</head>
<body>
	<h1>カード情報の確認</h1>
	<h2>カード情報の登録は一枚までです。</h2>
	<c:forEach var="card" items="${result.cardInfo}">
    クレジットカード番号(数字)<br><p>${card.creditnumber}</p>
    セキュリティ番号<br><p>${card.security_code}</p>
    有効期限<br><p>${card.expiration_date}</p>
    メールアドレス<br><p>${card.mail_address}</p>
</c:forEach>
<a href="/PizzaCat/editUser" class="btn2">戻る</a>
</form>
</body>
</html>