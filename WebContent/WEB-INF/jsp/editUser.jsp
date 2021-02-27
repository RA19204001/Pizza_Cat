<!--浅倉 1/29  -->
<!-- 内田 2/20 -->
<!-- 浅倉 2/20 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <!-- css適用 -->
        <link rel="stylesheet" type="text/css" href="css/editUser.css">

        <meta charset="UTF-8">
        <title>ユーザー情報の変更</title>
	</head>
	<body>
	<header>
		<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
		<p class="username">${sessionScope.loginuser.id}様</p>
	</header>
		<h1>ユーザー情報の変更</h1>
		<br>
		<form name="myform" method='post' action='editUserResult' onSubmit="return check()" id="log"><br>
		    <label style="color :red;">${result.message}</label><br>
		    ID<br><input type='text' maxlength='15' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required value="${sessionScope.loginuser.id}"  autofocus><br>
		    <tr><td><label class="kome">※半角英数字15文字</label></td></tr><br><br>
		    パスワード<br><input type='password' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required value="${sessionScope.loginuser.pass}"><br>
		    <tr><td><label class="kome">※半角英数字20文字</label></td></tr><br><br>
		    パスワード(確認用)<br><input type='password' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass2' required ><br>
		    <tr><td><label class="kome">※半角英数字20文字</label></td></tr><br><br>
		    名前<br><input type='text' maxlength='20' name='name' required value="${sessionScope.loginuser.name}"><br>
		    <tr><td><label class="kome">※20文字</label></td></tr><br><br>
		    住所<br><input type='text' maxlength='50' name='address' required value="${sessionScope.loginuser.address}"><br><br>
		    年齢<br><input type='text' maxlength='3' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='age' required value="${sessionScope.loginuser.age}"><br><br>
		    電話番号<br><input type='tel' maxlength='11' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='phoneNumber' required value="${sessionScope.loginuser.phoneNumber}"><br>
		    <tr><td><label class="kome">※‐(ハイフン)なし</label></td></tr><br><br>
		    <input type='hidden' name='oldId' required value="${sessionScope.loginuser.id}"><br>
		    <input type='submit' value='変更する' class="btn">
		</form>
		<div class="botom1">
		  <a href="addCard" class="btn">カード登録画面へ</a>
		  <form method="post" name="form1" action="editCard">
		    <input type="hidden" name="card_id" value="${sessionScope.loginuser.card_id}">
		    <a href="javascript:form1.submit()" class="btn">カード情報確認画面へ</a>
		  </form>
		</div>
		<br>

	</body>
</html>