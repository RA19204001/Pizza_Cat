<!--浅倉 1/29  -->
<!--大川 2/20 css -->
<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Login</title></head>
<body>
<header>
		<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
</header>
<h1>ログイン</h1>
<!-- <span class="class">ログイン</span> -->
<form name="myform" method='post' action='start' onSubmit="return check()" id="log">
    <label style="color :red;">${result.message}</label><br>
    ID<br><input type='text' maxlength='15' placeholder="登録されたID" pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id'required autofocus><br>
    <tr><td><label class="mame">※英数字</label></td></tr><br><br>
    パスワード<br><input type='password' maxlength='20' placeholder="登録されたパスワード" pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required><br><br><br>
    <input type='submit' value='ログイン' class="btn">
</form>


<!-- <p style="font-size:25px;"> </p> -->
<p id="botom">
<a href="/PizzaCat/addUser" class="btn">アカウント持ってない方はこちらから作成</a>
</p>


</body>
</html>