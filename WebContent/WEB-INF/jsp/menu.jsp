<!--浅倉 2/3  -->
<!--浅倉 2/5  -->
<!--浅倉 2/9  -->
<!--浅倉 2/10 -->
<!--浅倉 2/16 -->
<!-- 内田2/17 -->
<!--浅倉 2/17 -->
<!--浅倉 2/19 -->
<!-- 染谷 02/20 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="bean.Products"%>
<%@ page import ="java.util.ArrayList"%>
<%
Products pros = (Products)(request.getAttribute("result"));
ArrayList list = pros.getAddList();
if(list != null){
	//ArrayList array = (ArrayList)session.getAttribute("cart");

	//for(int i = 0;i<list.size();i++){
		//array.add(list.get(i));

	//}

	session.setAttribute("cart",list);

	}
//else{
	//	session.setAttribute("cart",new ArrayList());
	//}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="robots" content="noindex,nofollow">
		<link rel="stylesheet" type="text/css" href="css/menu.css">

		<!-- ビューポートの設定 -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- JavaScriptの読み込み -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

		<script>

$(function(){


	//グローバル変数
	var nowModalSyncer = null ;		//現在開かれているモーダルコンテンツ
	var modalClassSyncer = "modal-syncer" ;		//モーダルを開くリンクに付けるクラス名

	//モーダルのリンクを取得する
	var modals = document.getElementsByClassName( modalClassSyncer ) ;

	//モーダルウィンドウを出現させるクリックイベント
	for(var i=0,l=modals.length; l>i; i++){

		//全てのリンクにタッチイベントを設定する
		modals[i].onclick = function(){

			//ボタンからフォーカスを外す
			this.blur() ;

			//ターゲットとなるコンテンツを確認
			var target = this.getAttribute( "data-target" ) ;

			//ターゲットが存在しなければ終了
			if( typeof( target )=="undefined" || !target || target==null ){
				return false ;
			}

			//コンテンツとなる要素を取得
			nowModalSyncer = document.getElementById( target ) ;

			//ターゲットが存在しなければ終了
			if( nowModalSyncer == null ){
				return false ;
			}

			//キーボード操作などにより、オーバーレイが多重起動するのを防止する
			if( $( "#modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない
			//if($("#modal-overlay")[0]) $("#modal-overlay").remove() ;		//現在のモーダルウィンドウを削除して新しく起動する

			//オーバーレイを出現させる
			$( "body" ).append( '<div id="modal-overlay"></div>' ) ;
			$( "#modal-overlay" ).fadeIn( "fast" ) ;

			//コンテンツをセンタリングする
			centeringModalSyncer() ;

			//コンテンツをフェードインする
			$( nowModalSyncer ).fadeIn( "slow" ) ;

			//[#modal-overlay]、または[#modal-close]をクリックしたら…
			$( "#modal-overlay,#modal-close" ).unbind().click( function() {

				//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
				$( "#" + target + ",#modal-overlay" ).fadeOut( "fast" , function() {

					//[#modal-overlay]を削除する
					$( '#modal-overlay' ).remove() ;

				} ) ;

				//現在のコンテンツ情報を削除
				nowModalSyncer = null ;

			} ) ;

		}

	}

	//リサイズされたら、センタリングをする関数[centeringModalSyncer()]を実行する
	$( window ).resize( centeringModalSyncer ) ;

	//センタリングを実行する関数
	function centeringModalSyncer() {

		//モーダルウィンドウが開いてなければ終了
		if( nowModalSyncer == null ) return false ;

		//画面(ウィンドウ)の幅、高さを取得
		var w = $( window ).width() ;
		var h = $( window ).height() ;


		var cw = $( nowModalSyncer ).outerWidth() ;
		var ch = $( nowModalSyncer ).outerHeight() ;

		//センタリングを実行する
		$( nowModalSyncer ).css( {"left": ((w - cw)/2) + "px","top": ((h - ch)/2) + "px"} ) ;

	}


	//side---------------------------------------------------------------------------------------------------------------
	//グローバル変数
	var nowModalsSyncer = null ;		//現在開かれているモーダルコンテンツ
	var modalsClassSyncer = "modals-syncer" ;		//モーダルを開くリンクに付けるクラス名

	//モーダルのリンクを取得する
	var modals2 = document.getElementsByClassName( modalsClassSyncer ) ;

	//モーダルウィンドウを出現させるクリックイベント
	for(var i=0,l=modals2.length; l>i; i++){

		//全てのリンクにタッチイベントを設定する
		modals2[i].onclick = function(){

			//ボタンからフォーカスを外す
			this.blur() ;

			//ターゲットとなるコンテンツを確認
			var targets = this.getAttribute( "data-targets" ) ;

			//ターゲットが存在しなければ終了
			if( typeof( targets )=="undefined" || !targets || targets==null ){
				return false ;
			}

			//コンテンツとなる要素を取得
			nowModalsSyncer = document.getElementById( targets ) ;

			//ターゲットが存在しなければ終了
			if( nowModalsSyncer == null ){
				return false ;
			}

			//キーボード操作などにより、オーバーレイが多重起動するのを防止する
			if( $( "#modals-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない
			//if($("#modals-overlay")[0]) $("#modals-overlay").remove() ;		//現在のモーダルウィンドウを削除して新しく起動する

			//オーバーレイを出現させる
			$( "body" ).append( '<div id="modals-overlay"></div>' ) ;
			$( "#modals-overlay" ).fadeIn( "fast" ) ;

			//コンテンツをセンタリングする
			centeringModalsSyncer() ;

			//コンテンツをフェードインする
			$( nowModalsSyncer ).fadeIn( "slow" ) ;

			//[#modals-overlay]、または[#modals-close]をクリックしたら…
			$( "#modals-overlay,#modals-close" ).unbind().click( function() {

				//[#modals-content]と[#modals-overlay]をフェードアウトした後に…
				$( "#" + targets + ",#modals-overlay" ).fadeOut( "fast" , function() {

					//[#modals-overlay]を削除する
					$( '#modals-overlay' ).remove() ;

				} ) ;

				//現在のコンテンツ情報を削除
				nowModalsSyncer = null ;

			} ) ;

		}

	}

	//リサイズされたら、センタリングをする関数[centeringModalsSyncer()]を実行する
	$( window ).resize( centeringModalsSyncer ) ;

	//センタリングを実行する関数
	function centeringModalsSyncer() {

		//モーダルウィンドウが開いてなければ終了
		if( nowModalsSyncer == null ) return false ;

		//画面(ウィンドウ)の幅、高さを取得
		var w = $( window ).width() ;
		var h = $( window ).height() ;


		var cw = $( nowModalsSyncer ).outerWidth() ;
		var ch = $( nowModalsSyncer ).outerHeight() ;

		//センタリングを実行する
		$( nowModalsSyncer ).css( {"left": ((w - cw)/2) + "px","top": ((h - ch)/2) + "px"} ) ;

	}

	//カートの合計金額の計算
	var price = document.getElementsByClassName("cart_price");
    var amount = document.getElementsByClassName("cart_amount");
    var total = 0;
    for (var i = 0;i < price.length; i++){
    	total += (Number(price[i].textContent) * Number(amount[i].textContent));
	console.log(total);
    }
    var inputresult = document.getElementById("cart_total");
    inputresult.innerHTML=total;

    //カートに商品が入っていなければ購入ボタンを表示しない
    var flagcartbutton=document.getElementsByClassName("cart_price")[0];
    if(typeof flagcartbutton === "undefined"){
		var buybutton=document.getElementById("buy");
		buybutton.style.display="none";
    }

    //サイズと生地の削除ボタンを見えなくする
    if(!(typeof flagcartbutton === "undefined")){
	    cart_id=document.getElementsByClassName("cart_id");
	    for(let i =0;i<cart_id.length;i++){
		    	var hide=cart_id[i];
		    	if(hide.value >= 10001 && hide.value<=10006){
		    		var deletebutton=document.getElementsByClassName("delete")[i];
		    		deletebutton.style.display="none";
		    	}

	    }
    }

    //ピザのサイズと生地（Mサイズとスタンダード）にchecked属性の付与
	var sizeclass=document.getElementsByClassName("optionsize");
    var doughclass=document.getElementsByClassName("optiondough");

    for(let i=0;i<sizeclass.length;i++){

    	if(sizeclass[i].value=="M:1:500:10001"){
    		sizeclass[i].checked=true;
    	}
    }
    for(let i=0;i<doughclass.length;i++){

    	if(doughclass[i].value=="スタンダード:1:0:10003"){
    		doughclass[i].checked=true;
    	}
    }

    //保存されたピザ、サイドのタブの状態を適応　開始
	var tabstatus = sessionStorage.getItem('tabstatus');
    //<input id="TAB-01" type="radio" name="TAB" class="tab-switch" onclick="changetab('tab1')"/>
    //<input id="TAB-02" type="radio" name="TAB" class="tab-switch" onclick="changetab('tab2')"/>
    var tab1 = document.getElementById("TAB-01");
    var tab2 = document.getElementById("TAB-02");

	if(tabstatus == 'tab2'){
		tab2.setAttribute('checked','checked');
	}else{
		tab1.setAttribute('checked','checked');
	}
	//保存されたピザ、サイドのタブの状態を適応　終了
});

//タブの状態を保存する関数
function changetab(status){
	sessionStorage.setItem('tabstatus',status);
}

		</script>
		<style>
@charset "UTF-8";

*{
	margin:0;
	padding:0;
}
a{
    text-decoration:none;
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
}

.buttons-link:hover {
	cursor: pointer ;
	color: #f00 ;
}

.menu {
	flex: 1 0 auto;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100%;
	margin-left: 1%;
	margin-right: 2%;
	background: #EEE;
}

.cart {
	margin-top: 0;
	position: webkit-sticky;
	position: sticky;
	position: fixed;
	right: 0px;
	display: flex;
	justify-content: center;
	top: 10%;
	width: 20%;
	height: 80%;
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

.opimg{
	width:100%;
	heigth:50%;
}
button{
	width:20%;
	heigth:40%;
	background-color:#FFF;
	border:outset;
	content:1px;
}


		</style>

		<title>商品一覧</title>

	</head>
<body>

<header class="header">
	<p><a href="/PizzaCat/" id="moji"><font size="6"><img src="css/image/iconlogo.png"></font></a></p>
	<p class="username">${sessionScope.loginuser.id}様</p>
	<h2>カート</h2>
</header>

<!-- カートの中身と値段の表示 -->
<div class="cart" align="right">


<table>
<tr><th>削除</th><th>商品名</th><th>値段</th><th>個数</th></tr>
   <c:forEach var="cart" items="${sessionScope.cart}">
	<form method="post" action="deleteCart">
		   <tr><td><input type="submit" value="削除" class="delete"></td>
		   <td>${cart.name}</td>
		   <td class="cart_price">${cart.price}</td>
		   <td class="cart_amount">${cart.amount}</td></tr>
		   <input type="hidden" name="delete_id" value="${cart.id}" class="cart_id">
		   <input type="hidden" name="delete_custam_id" value="${cart.custamid}">

		   <c:forEach var="cart" items="${sessionScope.cart}">
	          <input type="hidden" name="cart_name" value="${cart.name}">
	          <input type="hidden" name="cart_price" value="${cart.price}">
	          <input type="hidden" name="cart_id" value="${cart.id}">
	          <input type="hidden" name="cart_amount" value="${cart.amount}">
	          <input type="hidden" name="cart_custamid" value="${cart.custamid}">
	       </c:forEach>
	</form>
</c:forEach>
</table>

</div>
<div class="cart-total">
	<table>
		<form method="post" action="confirmPurchase">
			<tr><td><h3>合計金額</h3></td><td><input type="submit" value="購入" id="buy"></td></tr>
			<tr><td><span>￥</span><span id="cart_total"></span></span></td></tr>

		</form>
	</table>
</div>

<hr style="margin: 3em 0 ;">

<!-- ピザメニューの商品をカートの中に入れる処理 -->
<div class="menu">
<div class="tab-wrap">
    <input id="TAB-01" type="radio" name="TAB" class="tab-switch" onclick="changetab('tab1')" />
    <label class="tab-label" for="TAB-01">
    	<h2 style="width :750px ;">ピザ</h2>
    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.list}" varStatus="status">
        <!-- 1つ目のコンテンツ [開始] -->
        <div id="modal-content-${status.index}" class="modal-content" name="favDialog">
            <!-- モーダルウィンドウのコンテンツ開始 -->
            <img src="pizza/${menu.image}">
            <p>${menu.name}</p>
            <p>${menu.explanation}</p>
            <form method="post" class="dialog" action="addCart" >
            	<c:forEach var="cart" items="${sessionScope.cart}">
				   <input type="hidden" name="cart_name" value="${cart.name}">
				   <input type="hidden" name="cart_price" value="${cart.price}">
				   <input type="hidden" name="cart_id" value="${cart.id}">
				   <input type="hidden" name="cart_amount" value="${cart.amount}">
				   <input type="hidden" name="cart_custamid" value="${cart.custamid}">
				</c:forEach>

            	<input type="hidden" name="amount" value="1">
            	<input type="hidden" name="id" value="${menu.product_id}">
               	<input type="hidden" name="name" value="${menu.name}">
               	<input type="hidden" name="price" value="${menu.price}">
				<br>
				<!-- サイズ -->
				<c:forEach var="option" items="${result.optionList}" begin="0" end="1">
				<label>
					<input type="radio" name="optionSize" value="${option.name}:1:${option.price}:${option.product_id}" class="optionsize" required>${option.name}: \ ${option.price}
					<br>
				</label>
				</c:forEach>
				<br>
				<!-- 生地 -->
				<c:forEach var="option" items="${result.optionList}" begin="2" end="5">
				<label>
					<input type="radio" name="optionDough" value="${option.name}:1:${option.price}:${option.product_id}" class="optiondough" required>${option.name}
					<br>
				</label>
				</c:forEach>
				<br>
				<br>
				<c:forEach var="option" items="${result.optionList}" begin="6">
					<p>${option.name}: \ ${option.price}</p>
                    <select name="option">
                    	<option value="${option.name}:0:${option.price}:${option.product_id}">0個</option>
						<option value="${option.name}:1:${option.price}:${option.product_id}">1個</option>
                        <option value="${option.name}:2:${option.price}:${option.product_id}">2個</option>
                        <option value="${option.name}:3:${option.price}:${option.product_id}">3個</option>
                    </select>
					<br>
				</c:forEach>

				<input type="submit" value="カートに入れる">
            </form>
            <p>${menu.price}</p>

            <p><a id="modal-close" class="button-link">閉じる</a></p>
            <!-- モーダルウィンドウのコンテンツ終了 -->
        </div>
        <!-- 1つ目のコンテンツ [終了] -->



	   	<a class="modal-syncer button-link" data-target="modal-content-${status.index}">
			<button>
		    	<img src="pizza/${menu.image}" class="opimg">
	        	<p>${menu.name}</p>
	        	<p>￥${menu.price}</p>
	    	</button>
	   	</a>




        </c:forEach>
    </div>

    <!-- サイドメニューの商品をカートの中に入れる処理 -->

    <input id="TAB-02" type="radio" name="TAB" class="tab-switch" onclick="changetab('tab2')" />
	    <label class="tab-label" for="TAB-02">
	    	<h2 style="width :750px ;">サイド</h2>
	    </label>
    <div class="tab-content">
        <c:forEach var="menu" items="${result.sideList}" varStatus="status">
        <!-- 1つ目（サイドメニュー）のコンテンツ [開始] -->
        <div id="modals-content-${status.index}" class="modals-content" name="favDialog">
            <!-- モーダルウィンドウのコンテンツ開始 -->
            <img src="pizza/${menu.image}">
            <p>${menu.name}</p>
            <p>${menu.explanation}</p>
            <form method="post" class="dialog" action="addCart" >
            	<c:forEach var="cart" items="${sessionScope.cart}">
				   <input type="hidden" name="cart_name" value="${cart.name}">
				   <input type="hidden" name="cart_price" value="${cart.price}">
				   <input type="hidden" name="cart_id" value="${cart.id}">
				   <input type="hidden" name="cart_amount" value="${cart.amount}">
				   <input type="hidden" name="cart_custamid" value="${cart.custamid}">
				</c:forEach>

            	<input type="text" name="amount" pattern="^[0-9]+$" value="1">
            	<input type="hidden" name="id" value="${menu.product_id}">

                	<input type="hidden" name="name" value="${menu.name}">
                	<input type="hidden" name="price" value="${menu.price}">
					<br>

				<input type="submit" value="カートに入れる">

            </form>
            <p>￥${menu.price}</p>
            <p><a id="modals-close" class="buttons-link">閉じる</a></p>
            <!-- モーダルウィンドウのコンテンツ終了 -->
        </div>
        <!-- 1つ目のコンテンツ [終了] -->


        <a class="modals-syncer buttons-link" data-targets="modals-content-${status.index}">
            <button>
		        <img src="pizza/${menu.image}" class="opimg">
	            <p>${menu.name}</p>
	            <p>￥${menu.price}</p>
            </button>
        </a>


        </c:forEach>
    </div>

</div>
</div>


</body>
</html>
