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

 　<main>
  <h1>カレンダー</h1>
  </main>
  <body>
    <div class="button_center">
  	  <input type="button" id = "prevMonth" value="前の月" >
  	  <input type="button" id = "nextMonth" value="次の月" >
  	</div>
	<div id="calendar"></div>
	<!-- <input type="button" value="カレンダーを表示する" onClick=""> -->
	<script>


	<c:forEach var="e" items="${evList}" >
	    const events = [
			  {
			    date: new Date(2024, 5, 5),
			    event_name: '${e.event_name}',
			    event_day:'',
			    event_place:'場所：${e.event_place}',
			    event_remarks:'備考：${e.event_remarks}',
			    user_name:'団体名：${e.user_name}'
			  },
			  {
				date: new Date(2024, 5, 15),
				event_name: '${e.event_name}',
				event_day:'',
				event_place:'場所：${e.event_place}',
				event_remarks:'備考：${e.event_remarks}',
				user_name:'団体名：${e.user_name}'
			  },
			  {
			    date: new Date(2024, 4, 15),
			    title: 'イベント3',
			  },
			];
	    </c:forEach>
<<<<<<< HEAD
	    
=======

>>>>>>> 4a937b1b22cd547ec4d92a52b693c51c268eb69a
	    $(function() {
	        $(".function").click(function() {
	          $(".1").slideToggle("");
	      });
	        });
	</script>
    <script src="/C3/js/calendar.js"></script>
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




NEW












c3_webアプリ へのメッセージ









