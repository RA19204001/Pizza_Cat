<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- タブアイコン設定 -->
<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">


<title>商品登録画面</title>

<script type="text/javascript">
	function catChange1(){
		radio = document.getElementsByName('productCat')
		if(radio[0].checked) {
			document.getElementById('pizza').style.display = "";
			document.getElementById('pizzaOption').style.display = "none";
			document.getElementById('side').style.display = "none";

		}else if(radio[1].checked) {
			document.getElementById('pizza').style.display = "none";
			document.getElementById('pizzaOption').style.display = "";
			document.getElementById('side').style.display = "none";

		}else if(radio[2].checked) {
			document.getElementById('pizza').style.display = "none";
			document.getElementById('pizzaOption').style.display = "none";
			document.getElementById('side').style.display = "";
		}

}

window.onload = catChange1;
</script>

</head>
<body>
<h1>商品登録画面！</h1>

<form name="addPizza" method='post' action='addPizza'>
カテゴリー
			<label><input type="radio" name="productCat" value="pizza" onclick="catChange1();" checked="checked" />ピザ</label>
			<label><input type="radio" name="productCat" value="pizzaOption" onclick="catChange1();" />ピザオプション</label>
			<label><input type="radio" name="productCat" value="side" onclick="catChange1();" />サイドメニュー</label>

	<div id="pizza">
		商品名<input type='text' maxlength='15' title="半角英数字を入力して下さい。" name='name' required autofocus><br>
    	画像<input type='file' name="file" accept="image/*" required><br>
    	説明<input type='text' maxlength='500' name='explanation' required><br>
   		値段<input type='text' maxlength='4' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='price' required><br>
    	<input type='submit' value='登録'>
    </div>

    <div id="pizzaOption">
     	商品名<input type='text' maxlength='15' title="半角英数字を入力して下さい。" name='name' required autofocus>${result.message}<br>
    	説明<input type='text' maxlength='500' name='explanation' required><br>
    	値段<input type='text' maxlength='4' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='price' required><br>
    	<input type='submit' value='登録'>
    </div>

    <div id="side">
		商品名<input type='text' maxlength='15' title="半角英数字を入力して下さい。" name='name' required autofocus><br>
    	画像<input type='file' name="file" accept="image/*" required><br>
    	説明<input type='text' maxlength='500' name='explanation' required><br>
   		値段<input type='text' maxlength='4' pattern="^[0-9]+$" title="半角数字で入力して下さい。" name='price' required><br>
    	<input type='submit' value='登録'>
    </div>
</form>>



<p><a href="/PizzaCat/managementTop.jsp">管理者TOPへ</a></p>
</body>
</html>