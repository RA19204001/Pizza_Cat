<!--浅倉 2/3  -->
<!--大川 2/4  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<h1>カード情報の登録</h1>
<form method='post' action='addCardResult' onSubmit="return check()">
    クレジットカード番号(数字)<input type='text' maxlength='16' pattern="^[0-9]+$" title="半角数字を入力して下さい。" name='creditnumber' required autofocus>${result.message}<br>
    セキュリティ番号<input type='password' minlength='3' maxlength='4' pattern="^[0-9]+$" title="半角数字を入力して下さい。" name='security_code' required><br>
    有効期限(年)<input type='number' name='expiration_year' placeholder="2ｹﾀ" min="00"max="99" required><br>
    有効期限(月)<select name='expiration_month' required>
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
    メールアドレス<input type='text' maxlength='256' name='mail_address' required><br><br>
    <input type='hidden' name='userId' required value="${sessionScope.loginuser.id}"><br>
    <input type='submit' value='登録'>

</form>
<p>${sessionScope.loginuser.id}でログイン中</p>

<p><a href="/PizzaCat/">TOPへ</a></p>

</body>
</html>
