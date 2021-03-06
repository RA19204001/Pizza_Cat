<!--浅倉 1/29  -->
<!--浅倉 2/3  -->
<!-- 内田2/19 -->
<!--浅倉 2/20  -->
<!--浅倉 2/28  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="bean.User"%>
<%@ page import ="bean.Message"%>

<html>
	<head>
		<!-- タブアイコン設定 -->
		<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
		<!-- cssを適用させる -->
		<link rel="stylesheet" type="text/css" href="css/start.css">

		<title>PizzaCat</title>

		<!-- cssの元の部分（これも封印、のち削除）
		<style type="text/css">
		</style>-->


		<script type="text/javascript" language="javascript">
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

			window.onload = function () {
				var judgment = document.getElementById("change").getAttribute("value");
				var number;
				if(!judgment)
				{
					number = 1;
				}else
				{
					number = 2;
				}
				SelectPage(number);
			};
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
					session.setAttribute("cart",null);

				}
			}catch(ClassCastException e2){}
		}


		%>

		<header>
			<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
			<div id='page1' class='page1'>
			   <ul id="nav">
				<li><p><a href="addUser">会員登録画面へ</a></p></li>
				<li><p><a href="login">ログイン</a></p></li>
			   </ul>
			</div>
			<div id='page2' class='page2'>
			   <ul id="nav">
				<li><p><a href="editUser">ユーザー/カード情報の編集</a></p></li>
			   <li><p><form method="post" action="orderHistoryDate">
				   <input type="submit" value="注文履歴">
				   <input type="hidden" name="user_number" value="${sessionScope.loginuser.number}">
			   </form></p></li>
				<li><p>${sessionScope.loginuser.id}様</p></li>
				<li><p><a href="logout">ログアウト</a></p></li>
			   </ul>
			</div>
			<input id="change" type='hidden' value='${sessionScope.loginuser.id}'>
		</header>

		<div class="menu">
		  <div class="image">

		    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<p><a href="menu" class="menu_button">メニューを見る</a></p>
		  </div>
	    </div>

	</body>
</html>
