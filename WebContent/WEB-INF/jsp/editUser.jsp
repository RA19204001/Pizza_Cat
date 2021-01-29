<!--浅倉 1/29  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報の変更</title>
</head>
<body>
<h1>ユーザー情報の変更</h1>
<form name="myform" method='post' action='editUserResult' onSubmit="return check()">
    ID(英数字)<input type='text' maxlength='15' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='id' required autofocus value="${sessionScope.loginuser.id}">${result.message}<br>
    パスワード<input type='text' maxlength='20' pattern="^[0-9A-Za-z]+$" title="半角英数字を入力して下さい。" name='pass' required value="${sessionScope.loginuser.pass}"><br>
    名前<input type='text' maxlength='20' name='name' required value="${sessionScope.loginuser.name}"><br>
    住所<input type='text' maxlength='50' name='address' required value="${sessionScope.loginuser.address}"><br>
    年齢<input type='text' maxlength='3' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='age' required value="${sessionScope.loginuser.age}"><br>
    電話番号<input type='text' maxlength='11' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='phoneNumber' required value="${sessionScope.loginuser.phoneNumber}"><br><br>
    oldId<input type='text' name='oldId' required value="${sessionScope.loginuser.id}">${result.message}<br>
    <input type='submit' value='変更する'>
</form>
<p><a href="addCard">カード登録画面へ</a></p>
<p>${sessionScope.loginuser.id}でログイン中</p>

</body>
</html>