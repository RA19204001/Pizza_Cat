<!--浅倉 2/5  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>管理者ログインページ</title>
</head>
<body>
<h1>管理者専用ページ</h1>
<h2>ログインしてください</h2>
<form method="post" action="management">
    ID(英数字)<input type='text' maxlength='15' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required autofocus><br>
    パスワード<input type='password' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required><br>
    <input type='submit' value='ログイン'>
</form>

<p style="color :red;">${result.message}</p>

</body>
</html>