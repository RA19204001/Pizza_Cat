<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="bean.User"%>
<%@ page import ="bean.Message"%>
<html>
<head>
<title>PizzaCat</title>
<style type="text/css">
.page1 {
    display:block;
    font-weight:bold;
}
.page2 {
    display:none;
    font-weight:bold;
}

</style>
<script type="text/javascript" language="javascript">
<!--
function SelectPage( page ) {

    var elementPage1 = document.getElementById( "page1" );
    var elementPage2 = document.getElementById( "page2" );

    switch( page ) {
    case 1:
        elementPage1.style.display = 'block';
        elementPage2.style.display = 'none';
        break;

    case 2:
        elementPage1.style.display = 'none';
        elementPage2.style.display = 'block';
        break;
        }
};
// -->
</script>
</head>
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
<input type='button' value='page1を表示' onclick="SelectPage(1);">
<input type='button' value='page2を表示' onclick="SelectPage(2);">
<div id='page1' class='page1'>
<p><a href="addUser">会員登録画面へ</a></p>
<p><a href="login">ログイン</a></p>

</div>
<div id='page2' class='page2'>
<p><a href="logout">ログアウト</a></p>
<p><a href="editUser">ユーザー情報の編集</a></p>

</div>
<p>${sessionScope.loginuser.id}でログイン中</p>
</body>
</html>
