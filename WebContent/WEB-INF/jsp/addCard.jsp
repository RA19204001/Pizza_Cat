<!--浅倉 2/3  -->
<!--大川 2/4  -->
<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/addCard.css">
<script>
	//確認用のダイヤルログ
	function check(){

		if(window.confirm('登録内容はこれでよろしいですか？')){
			return true;
		}else{
			return false;
		}
	}
</script>
<title>カード情報登録画面</title>
</head>
<body>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6">PizzaCat</font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<h1>カード情報の登録</h1>
<form method='post' action='addCardResult' onSubmit="return check()" id="textbox">
    クレジットカード番号(数字)<br><input type='text' maxlength='16' pattern="^[0-9]+$" placeholder="半角数字を入力して下さい。" name='creditnumber' required autofocus><br>
    セキュリティ番号<br><input type='password' minlength='3' maxlength='4' pattern="^[0-9]+$" placeholder="半角数字を入力して下さい。" name='security_code' required><br>
    有効期限(年)<br><input type='number' name='expiration_year' placeholder="下2桁" min="00"max="99" required><br>
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
    メールアドレス<br><input type='text' maxlength='256' name='mail_address' required placeholder="例:tarou1234@gmail.com"><br><br>
    <input type='hidden' name='userId' required value="${sessionScope.loginuser.id}"><br>
    ${result.message}<br>
    <input type='submit' value='登録' class="btn">

</form>


</body>
</html>
