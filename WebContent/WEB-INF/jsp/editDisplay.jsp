<!--浅倉 2/3  -->
<!--浅倉 2/5  -->
<!--浅倉 2/9  -->
<!--浅倉 2/10 -->
<!--浅倉 2/16 -->
<!-- 内田2/17 -->
<!--浅倉 2/17 -->
<!--浅倉 2/19 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script>
			function hidecheck(){

				if(window.confirm('非表示にしていい？')){
					return true;
				}else{
					return false;
				}
			}
			function displaycheck(){

				if(window.confirm('表示していい？')){
					return true;
				}else{
					return false;
				}
			}
		</script>
		<meta name="robots" content="noindex,nofollow">

		<!-- ビューポートの設定 -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- JavaScriptの読み込み -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

	<style>
		@charset "UTF-8";

		*{
			margin:0;
			padding:0;
		}

		/* ここまでデモページ用のコード */

		.modal-content {
			width: 50% ;
			height :70%;
			margin: 0 ;
			padding: 10px 20px ;
			border: 2px solid #aaa ;
			background: #fff ;
			position: fixed ;
			display: none ;
			z-index: 2 ;
			overflow-y: scroll;
			overflow-y: hidden visible;

		}

		#modal-overlay {
			z-index: 1 ;
			display: none ;
			position: fixed ;
			top: 0 ;
			left: 0 ;
			width: 100% ;
			height: 120% ;
			background-color: rgba( 0,0,0, 0.75 ) ;
		}

		.button-link {
			color: #00f ;
			text-decoration: underline ;
		}

		.button-link:hover {
			cursor: pointer ;
			color: #f00 ;
		}


		.tab-wrap {
		    display: flex;
		    flex-wrap: wrap;
		}
		.tab-label {
		    color: White;
		    background: LightGray;
		    margin-right: 5px;
		    padding: 3px 12px;
		    order: -1;
		}
		.tab-content {
		    width: 100%;
		    display: none;
		}
		/* アクティブなタブ */
		.tab-switch:checked+.tab-label {
		    background: DeepSkyBlue;
		}
		.tab-switch:checked+.tab-label+.tab-content {
		     display: block;
		}
		/* ラジオボタン非表示 */
		.tab-switch {
		    display: none;
		}


		/*size*/
		.modals-content {
			width: 50% ;
			margin: 0 ;
			padding: 10px 20px ;
			border: 2px solid #aaa ;
			background: #fff ;
			position: fixed ;
			display: none ;
			z-index: 2 ;
		}

		#modals-overlay {
			z-index: 1 ;
			display: none ;
			position: fixed ;
			top: 0 ;
			left: 0 ;
			width: 100% ;
			height: 120% ;
			background-color: rgba( 0,0,0, 0.75 ) ;
		}

		.buttons-link {
			color: #00f ;
			text-decoration: underline ;
		}

		.buttons-link:hover {
			cursor: pointer ;
			color: #f00 ;
		}



		.cart {
			margin-top: 0;
			position: webkit-sticky;
			position: sticky;
			position: fixed;
			right: 0px;
			display: flex;
			justify-content: center;
			top: 0px;
			width: 20%;
			height: 90%;
			color: rgb(114, 36, 50);
			background: #FFF;
			overflow-y: scroll;
			overflow-y: hidden visible;
		}
		.cart-total{
			position: webkit-sticky;
			position: sticky;
			position: fixed;
			bottom:0px;
			right: 0px;
			display: flex;
			width: 20%;
			height: 10%;
			color: rgb(114, 36, 50);
			background: #FEFEFE;
			border-style: ridge;
		}

		img{
			width:50%;
			heigth:50%;
		}
		button{
			width:20%;
			heigth:40%;
			background-color:#FFF;
			border:outset;
			content:1px;
			padding:0px;
		}
	</style>

	<title>商品一覧</title>

</head>
<body>


<h1 style="text-align:center;color:#d36015;">商品表示編集</h1>


<div class="tab-wrap">
    <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" />
    <label class="tab-label" for="TAB-01">
    	<h2 style="width :500px ;">表示済みピザ</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.list}" varStatus="status">
			<form method="post" action="editDisplayResult" onSubmit="return hidecheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="0">
		        	</button>
		        </form>
        </c:forEach>
    </div>

    <input id="TAB-02" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-02">
    	<h2 style="width :500px ;">表示済みサイド</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.sideList}" varStatus="status">
				<form method="post" action="editDisplayResult" onSubmit="return hidecheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="0">
		        	</button>
		        </form>
        </c:forEach>
    </div>

    <input id="TAB-03" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-03">
    	<h2 style="width :500px ;">表示済みオプション</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.optionList}" varStatus="status" begin="6">

				<form method="post" action="editDisplayResult" onSubmit="return hidecheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="0">
		        	</button>
		        </form>

        </c:forEach>
    </div>

    <input id="TAB-04" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-04">
    	<h2 style="width :500px ;">非表示済みピザ</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.hidepizzaList}" varStatus="status">
			<form method="post" action="editDisplayResult" onSubmit="return displaycheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="1">
		        	</button>
		        </form>
        </c:forEach>
    </div>

    <input id="TAB-05" type="radio" name="TAB" class="tab-switch" />
    <label class="tab-label" for="TAB-05">
    	<h2 style="width :500px ;">非表示済みサイド</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.hidesideList}" varStatus="status">

				<form method="post" action="editDisplayResult" onSubmit="return displaycheck()">
					<form method="post" action="editDisplayResult" onSubmit="return displaycheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="1">
		        	</button>
		        </form>
			   </form>
        </c:forEach>
    </div>

    <input id="TAB-06" type="radio" name="TAB" class="tab-switch" />
    <label class="tab-label" for="TAB-06">
    	<h2 style="width :500px ;">非表示済みオプション</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.hideoptionList}" varStatus="status">
        	<form method="post" action="editDisplayResult" onSubmit="return displaycheck()">
				<button>
			    	<img src="pizza/${menu.image}">
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="1">
		        </button>
		     </form>
        </c:forEach>
    </div>
</div>
<p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>
</body>
</html>
