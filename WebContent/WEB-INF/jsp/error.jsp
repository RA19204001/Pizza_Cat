<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<html>

	<head><title>エラーページ</title>

	<style>
			.button {
			  text-decoration: none;
			  text-align: center;
			  font-weight: bold;
			  font-size: 40px;
			  color: #799dec;
			  text-shadow: 0px 4px 2px rgba(0, 0, 0, 0.32), 0px 1px 0px #6182ca, 0px 2px 0px #4f6aa7, 0px 3px 0px #5470ad;
			}
			.button:active {
			  top: 4px;
			  text-shadow: none;
			}
			p
			{
				text-align: center;
				font-size:30px;
				padding: 15;
			}
			body
			{
				background-image: url('css/image/error2.png');
				background-repeat: no-repeat;
				/*margin: 0 0 50% 50%;*/
			}
			.iro
			{
				color: gold;
			}
	</style>
	</head>

	<body>
		<p class="iro">エラーが発生しました。</p>
		<p class="iro">誠に恐縮ではございますが、TOPページへお戻りください。</p>
		<p><a href="/PizzaCat/" class="button">TOPへ</a></p>

	</body>

</html>