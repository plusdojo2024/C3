<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<style>
  <link rel="stylesheet" href="/C3/css/style.css">
</style>
</head>
<body id ="top">
	<!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div>
        </td>
        <td>
  <div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="40"></a>
  </div>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li><a href="/C3/GroupServlet">各団体</a></li>
        <li><a href="/C3/AnimalSearchServlet">動物検索</a></li>
        <li><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li><a href="/C3/QASevlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
  
 　<main>
  <h1>カレンダー</h1>
  </main>
  <body>
  <button id="prevMonth">前の月</button>
  <button id="nextMonth">次の月</button>
  <div id ="calendar"></div>
 
	<div id="calendar"></div>
	<input type="button" value="test" onClick="	generateCalendar(2024, 6);">
    <script src="/C3/js/calendar.js">
	    const events = [
	  	  {
	  	    date: new Date(currentYear, currentMonth, 5),
	  	    title: 'イベント1',
	  	  },
	  	  {
	  	    date: new Date(currentYear, currentMonth, 15),
	  	    title: 'イベント2',
	  	  },
	  	];
    
    </script>
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