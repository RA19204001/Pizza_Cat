<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="bean.User"%>
<%@ page import ="bean.Message"%>
<html>
<head><title>PizzaCat</title></head>
<body>
<%
try{
	User user = (User)(request.getAttribute("result"));
	if(user != null){
		session.setAttribute("loginuser",user);
	}
}catch(ClassCastException e){
	try{
		Message message = (Message)(request.getAttribute("result"));
		if(message.getFlag()){
			session.setAttribute("loginuser",null);
		}
	}catch(ClassCastException e2){}
}


%>
<h1>TOP画面</h1>
<p><a href="addUser">会員登録画面へ</a></p>
<p><a href="login">ログイン</a></p>
<p><a href="logout" style=display:none>ログアウト</a></p>
<p><a href="editUser">ユーザー情報の編集</a></p>
<p>${sessionScope.loginuser.id}でログイン中</p>
</body>
</html>
