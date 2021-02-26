<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カード情報編集</title>
</head>
<body>
	<h1>カード情報の登録</h1>
<form method='post' action='editCardResult' id="textbox">
    クレジットカード番号(数字)<br><input type='text' maxlength='16' pattern="^[0-9]+$" name='creditnumber' required value="${sessionScope.logincard.card_id}" autofocus>${result.message}<br>
    セキュリティ番号<br><input type='password' minlength='3' maxlength='4' pattern="^[0-9]+$" name='security_code' required><br>
    有効期限(年)<br><input type='number' name='expiration_year' min="00"max="99" required><br>
    有効期限(月)<br><select name='expiration_month' required>
	    			<option value="01">01</option>
					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
    			</select><br>
    メールアドレス<br><input type='text' maxlength='256' name='mail_address' required ><br><br>
    <input type='hidden' name='oldcard_id' required value="${sessionScope.logincard.id}"><br>
    <input type='submit' value='登録' class="btn">

</form>
</body>
</html>