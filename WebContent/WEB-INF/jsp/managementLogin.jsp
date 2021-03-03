<!--浅倉 2/5  -->
<%@ page import ="bean.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>管理者ログインページ</title>
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
</head>
<body>
<%
			try{
				Message message = (Message)(request.getAttribute("result"));
				if(message.getFlag()){
					session.setAttribute("loginmanager",null);
				}
			}catch(ClassCastException e1){

			}catch(Exception e2){

			}

		%>
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