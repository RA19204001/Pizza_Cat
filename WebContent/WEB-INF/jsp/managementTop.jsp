<!--浅倉 2/5  -->
<!--大川 2/5  -->
<!--大川 2/10  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="bean.Manager"%>
<%@ page import ="bean.Message"%>
<html>
<head>
<title>管理者トップページ</title>
</head>
<body>

<%
try{
	Manager manager = (Manager)(request.getAttribute("result"));
	if(manager != null){
		session.setAttribute("loginmanager",manager);
	}
}catch(ClassCastException e){
	try{
		Message message = (Message)(request.getAttribute("result"));
		if(message.getFlag()){
			session.setAttribute("loginmanager",null);
		}
	}catch(ClassCastException e2){}
}


%>
<h1>管理者専用ページ</h1>
<h2>あなたがジャンプマスターです<br>□で飛ぶ</h2>

    <p><a href="addProducts">商品の追加</a></p>
	<p><a href="editDisplay">商品表示の編集</a></p>
	<p><a href="managerlogout">ログアウト</a></p>

<p>${sessionScope.loginmanager.id}でログイン中</p>

</body>
</html>