<!--浅倉 2/20  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="bean.CardInfo"%>
    <%@ page import ="bean.User"%>
    <%@ page import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/addCardResult.css">
<title>カード追加完了</title>
</head>
<body>
<%
		try{
			CardInfo card = (CardInfo)(request.getAttribute("result"));
			ArrayList list = card.getCardList();
			User user = (User)list.get(0);
			if(user != null){
				session.setAttribute("loginuser",user);
			}
		}catch(ClassCastException e){
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