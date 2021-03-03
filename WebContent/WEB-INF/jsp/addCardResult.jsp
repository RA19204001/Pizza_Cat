<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">

<link rel="stylesheet" type="text/css" href="css/addCardResult.css">
<title>カード追加完了</title>
</head>
<body>
<%
try{
	User user = (User)(request.getAttribute("result"));
	if(user != null){
		session.setAttribute("loginuser",user);
		System.out.println(user.getName());
	}
}catch(ClassCastException e){
	request.setAttribute("result",null);
}


%>
<header>
<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
<p class="username">${sessionScope.loginuser.id}様</p>
</header>
<h1>${result.message}</h1>

<p id="botom"><a href="/PizzaCat/" class="btn">TOPへ</a></p>

</body>
</html>