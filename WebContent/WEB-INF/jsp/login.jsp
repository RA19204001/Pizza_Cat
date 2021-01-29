<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head><title>Login</title></head>
<body>
<h1>ログイン</h1>
<form name="myform" method='post' action='start' onSubmit="return check()">
    ID(英数字)<input type='text' maxlength='15' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required autofocus><br>
    パスワード<input type='password' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required><br>
    <input type='submit' value='ログイン'>
</form>

<p style="color :red;">${result.message}</p>

<p><a href="/PizzaCat/">TOPへ</a></p>
</body>
</html>