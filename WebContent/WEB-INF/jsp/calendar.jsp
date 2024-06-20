<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
 <link rel="stylesheet" href="/C3/css/style.css">
<style>
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

	<div id="calendar"></div>
	<input type="button" id = "prevMonth" value="前の月" >
  	<input type="button" id = "nextMonth" value="次の月" >
<<<<<<< HEAD
	<!-- <input type="button" value="カレンダーを表示する" onClick=""> -->
	<input type="button" id ="addEvents" value="イベントを表示">
	<script>
<<<<<<< HEAD


	<c:forEach var="e" items="${evList}" >



=======
>>>>>>> 3b9d292fe12eda215a1f4074ab2d6e359c59a9a9
	    const events = [
			  {
			    date: new Date(2024, 5, 5),
			    event_name: '第1回「ローズガーデン：譲渡会」',
			    event_day:
			    event_place:''
			    event_remarks:''
			    user_name:'ローズガーデン'
			  },
			  {
			    date: new Date(2024, 5, 15),
			    title: 'イベント2',
			  },
			  {
			    date: new Date(2024, 4, 15),
			    title: 'イベント3',
			  },
			];
	    
	    <% List<String>  evlist =
	    		(List<String>)request.getAttribute("evlist"); %>
	    		
	    		<p>テーブルに登録されている譲渡会一覧</p>
	    		<% for(String event_name: evlist) { %>
	    		<%= event_name %><br>
	    		<% } %>
	</script>
    <script src="/C3/js/calendar.js"></script>
=======
	<input type="button" value="カレンダーを表示する" onClick="">
    <script src="/C3/js/calendar.js">

    </script>
>>>>>>> a45883cd406ffd9cbb3db8d93c6b0e48e93e94e3
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
<<<<<<< HEAD


=======
>>>>>>> 3b9d292fe12eda215a1f4074ab2d6e359c59a9a9
  </body>
</html>