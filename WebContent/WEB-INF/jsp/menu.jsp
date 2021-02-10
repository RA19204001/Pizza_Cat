<!--浅倉 2/3  -->
<!--浅倉 2/5  -->
<!--浅倉 2/9  -->
<!--浅倉 2/10 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="robots" content="noindex,nofollow">

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

} ) ;

		</script>
		<style>
@charset "UTF-8";

/* ここまでデモページ用のコード */

.modal-content {
	width: 50% ;
	margin: 0 ;
	padding: 10px 20px ;
	border: 2px solid #aaa ;
	background: #fff ;
	position: fixed ;
	display: none ;
	z-index: 2 ;
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

		</style>

		<title>商品一覧「</title>

	</head>
<body>



<h1 style="text-align:center;color:#d36015;">メニュー</h1>

<HR style="margin: 3em 0 ;">
<c:forEach var="menu" items="${result.list}" varStatus="status">
<!-- 1つ目のコンテンツ [開始] -->
<div id="modal-content-${status.index}" class="modal-content" name="favDialog">
	<!-- モーダルウィンドウのコンテンツ開始 -->
	<p>${menu.name}</p>
	<img src="../pizza/${menu.image}"><!-- 画像が映らない！ -->
	<p>${menu.explanation}</p>
	<p>${menu.price}</p>
	<p><a id="modal-close" class="button-link">閉じる</a></p>
	<!-- モーダルウィンドウのコンテンツ終了 -->
</div>
<!-- 1つ目のコンテンツ [終了] -->


<p><a class="modal-syncer button-link" data-target="modal-content-${status.index}">
	<menu>
	<button>
  	<form method="post" action="">
	<table>
	<p>${menu.name}</p>
	<img src="../pizza/${menu.image}"><!-- 画像が映らない！ -->
	<p>${menu.explanation}</p>
	<p>${menu.price}</p>
	</table>
	</form>
	</button>
</menu>
</a></p>


<HR style="margin: 3em 0 ;">

	</c:forEach>

<p><a href="/PizzaCat/">TOPへ</a></p>
<p><a href="/PizzaCat/managementTop">管理者TOPへ</a></p>

</body>
</html>
