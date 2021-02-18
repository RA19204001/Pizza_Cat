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
<title>会員登録画面</title>
</head>
<body>
<h1>会員登録画面！</h1>
<form name="myform" method='post' action='addUserResult' onSubmit="return check()">
    ID(英数字)<input type='text' maxlength='15' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required autofocus>${result.message}<br>
    パスワード<input type='password' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required><br>
    名前<input type='text' maxlength='20' name='name' required><br>
    住所<input type='text' maxlength='50' name='address' required><br>
    年齢<input type='text' maxlength='3' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='age' required><br>
    電話番号(‐なし)<input type='tel' maxlength='11' pattern="^[0-9]+$" title="半角数字で入力して下さい。" placeholder="09012345678" name='phoneNumber' required><br><br>
    <input type='submit' value='登録'>
</form>

<p><a href="/PizzaCat/">TOPへ</a></p>
</body>
</html>