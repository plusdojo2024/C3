<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
 <link rel="stylesheet" href="/C3/css/calendar.css">
<style >
    body {
      background-color: #FFFAF0; /* 背景色を薄茶色に設定 */
      font-weight: bold; /* または数値 (100 - 900) */
    }
</style>
</head>
<body id ="top">
	<!-- ヘッダー -->
  <header>
    <c:if test="${empty id}"><div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div></c:if>
    <c:if test="${not empty id}"><div class="home">
      <a href="PersonalServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div></c:if>

    <c:if test="${not empty id}">  <div class="logout">
    <a href="LogoutServlet"><img src="./img/images/logout.png" alt="ログアウト" width="150" height="55"></a>
    </div></c:if>
    <table>
      <tr>
        <td>
    <c:if test="${empty id}"><div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div></c:if>
        </td>
        <td>
  <c:if test="${empty id}"><div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="40"></a>
  </div></c:if>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QAServlet">Q&amp;A</a></li>
    <c:if test="${not empty id}">
        <li class="list5"><a href="/C3/DmPersonalServlet">DM</a></li>
    </c:if>
      </ul>
    </nav>
  <!-- ヘッダーここまで -->
  </header>

 　<main class="calendar">
  <h1>カレンダー</h1>
    <div class="button_center">
  	  <input type="button" id = "prevMonth" value="前の月" >
  	  <input type="button" id = "nextMonth" value="次の月" >
  	</div>
	<div id="calendar"></div>
	<script>

		const events = [
		<c:forEach var="e" items="${evList}" >
			  {
			    id			:'${e.id}',
			    
			    event_name	: '[譲渡会名]:${e.event_name}',
			    
			    //                クラス名(引数1 ,引数2,、引数3)
			    //date		: new Date ( 2024, 5   , 15 ),
			    
			    date	    : new Date (${e.year}, ${e.month}, ${e.day}),
			    
			    //date		: new Date(${e.year}, ${e.month}, ${e.day})
			    
			    //event_day	:'${e.event_day}',
			    
			    event_place	:'[場所]${e.event_place}',
			    
			    event_remarks:'[備考]：${e.event_remarks}',
			    
			    user_name	:'[団体名]：${e.user_name}'
			  },
	    </c:forEach>
		];

	    
	    //date: new Date(2024, 5, 15),
	
		//const events = [ {event}, {event}, {event} ];
		//const events = [ {event}, {event}, {event} ];
		//const events = [ {event}, {event}, {event} ];
		//const events = [ {event}, {event}, {event} ];
		
		//const events = [ 
		//foreach evList
		//	{event}, 
		///foreach
		//	];
	
		//例：evListの中身が10個
		//const events = [ {event}, {event}, {event}, {event}, {event}, {event}, {event}, {event}, {event}, {event}, ];
		
		
		// カレンダーnullを許さない

  		'use strict';
		let form = document.getElementById("addGroup");
		form.onsubmit = function(){
		if(!form.event_name.value || !form.event_day.value || !form.event_place.value || !form.user_name.value){
		window.alert("備考以外はすべて入力してください。")
		event.preventDefault;
	    return false;
	}
}

	    </script>
    <script src="/C3/js/calendar.js"></script>
  </main>
  </body>
  <!-- メインここまで -->

  <!-- フッター -->
    <footer>
      <div class="gotop">
        <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
      </div>
      <p class="copyright">&copy; dacho_group</p>
    </footer>
  <!-- フッターここまで -->


  </body>
</html>