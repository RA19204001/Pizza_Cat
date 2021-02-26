<!--大川 2/20 css -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/user.css">
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
<title>会員登録画面</title>
</head>
<body>
<p><a href="/PizzaCat/" id="moji"><font size="6">PizzaCat</font></a></p>
<h1>会員登録</h1>
<form name="myform" method='post' action='addUserResult' onSubmit="return check()"  id="log">
    ID<br><input type='text' maxlength='15' placeholder="ID" pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required autofocus>${result.message}<br>
    <tr><td><label class="kome">※半角英数字15文字</label></td></tr><br><br>
    パスワード<br><input type='password' maxlength='20' placeholder="パスワード" pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required><br>
    <tr><td><label class="kome">※半角英数字20文字</label></td></tr><br><br>
    名前<br><input type='text' maxlength='20' placeholder="例）ピザキャト子" name='name' required><br>
    <tr><td><label class="kome">※20文字</label></td></tr><br><br>
    住所<br><input type='text' maxlength='50' placeholder="例）東京都〇〇区〇〇〇-〇-〇" name='address' required><br><br><br>
    年齢<br><input type='text' maxlength='3' placeholder="例）20" pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='age' required><br><br><br>
    電話番号<br><input type='tel' maxlength='11' pattern="^[0-9]+$" title="半角数字で入力して下さい。" placeholder="例）09012345678" name='phoneNumber' required><br>
    <tr><td><label class="kome">※‐(ハイフン)なし</label></td></tr><br><br>
    <input type='submit' value='登録' class="btn"><br><br>
</form>

</body>
</html>