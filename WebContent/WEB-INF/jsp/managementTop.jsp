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
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
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

    <p><a href="addProducts">商品の追加</a></p>
	<p><a href="editDisplay">商品表示の編集</a></p>
	<p><a href="addressee">お届け先</a></p>
	<p><a href="sales">売り上げの表示</a></p>
	<p><a href="managerlogout">ログアウト</a></p>

<p>${sessionScope.loginmanager.id}でログイン中</p>

</body>
</html>