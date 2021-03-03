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
	<!-- タブアイコン設定 -->
	<link rel="shortcut icon" href="css/image/pizzaicon.ico" type="image/vnd.microsoft.icon">
	<link rel="stylesheet" type="text/css" href="css/menu2.css">
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
		.tab-switch:checked+.tab-label {
		    background: DeepSkyBlue;
		}
		.tab-switch:checked+.tab-label+.tab-content {
		     display: block;
		}
		.tab-switch {
		    display: none;
		}

/*justify-content: center;*/

/*.header{
 width: 100%;
   padding: 10px 0px 10px;
   top: 0;
   display: flex;
   position: sticky;
  position: -webkit-sticky;
  top: 0;
justify-content: stretch;
}*/

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

		.menu {
			flex: 1 0 auto;
			justify-content: stretch;
			height: 100%;
			margin-left: 1%;
			margin-right: 2%;
			background: #EEE;
		}
	</style>

	<title>商品一覧</title>

</head>
<body>


<h1 style="text-align:center;color:#d36015;">商品表示編集</h1>
<h2><a href="/PizzaCat/managementTop">管理者TOPへ</a></h2>

<div class="menu">
<div class="tab-wrap">
    <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" />
    <label class="tab-label" for="TAB-01">
    <header class="header">
    	<h2 style="width :500px ;">表示済みピザ</h2>
    </header>
    </label>
    <div class="tab-content">
    <table>
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
        </table>
    </div>


    <input id="TAB-04" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-04">
    <header class="header">
    	<h2 style="width :500px ;">非表示済みピザ</h2>
    	</header>
    </label>
    <div class="tab-content">
    <table>
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
        </table>
    </div>

    <input id="TAB-02" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-02">
    <header class="header">
    	<h2 style="width :500px ;">表示済みサイド</h2>
    	</header>
    </label>
    <div class="tab-content">
    <table>
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
        </table>
    </div>


    <input id="TAB-05" type="radio" name="TAB" class="tab-switch" />
    <label class="tab-label" for="TAB-05">
    <header class="header">
    	<h2 style="width :500px ;">非表示済みサイド</h2>
    	</header>
    </label>
    <div class="tab-content">
    <table>
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
        </table>
    </div>


    <input id="TAB-03" type="radio" name="TAB" class="tab-switch"/>
    <label class="tab-label" for="TAB-03">
    <header class="header">
    	<h2 style="width :500px ;">表示済みオプション</h2>
    	</header>
    </label>
    <div class="tab-content">
    <table>
        <c:forEach var="menu" items="${result.optionList}" varStatus="status" begin="6">

				<form method="post" action="editDisplayResult" onSubmit="return hidecheck()">
				<button>
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="0">
		        	</button>
		        </form>

        </c:forEach>
        </table>
    </div>


    <input id="TAB-06" type="radio" name="TAB" class="tab-switch" />
    <label class="tab-label" for="TAB-06">
    <header class="header">
    	<h2 style="width :500px ;">非表示済みオプション</h2>
    	</header>
    </label>
    <div class="tab-content">
    <table>
        <c:forEach var="menu" items="${result.hideoptionList}" varStatus="status">
        	<form method="post" action="editDisplayResult" onSubmit="return displaycheck()">
				<button>
		        	<p>${menu.name}</p>
		        	<p>${menu.price}円</p>
		        	<input type="hidden" name="id" value="${menu.product_id}">
		        	<input type="hidden" name="display" value="1">
		        </button>
		     </form>
        </c:forEach>
        </table>
    </div>
    </div>
</div>
<p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>
</body>
</html>
