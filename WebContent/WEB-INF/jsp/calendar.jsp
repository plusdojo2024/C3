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
  
  
  <!-- カレンダーHTML -->
  <div class="calendar-wrap">

  <!-- 
  <table class="calendar">
    <thead>
      <tr>
        <th class="sun">日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th class="sat">土</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="mute">29</td>
        <td class="mute">30</td>
        <td>1</td>
        <td>2</td>
        <td>3</td>
        <td>4</td>
        <td>5</td>
      </tr>
      <tr>
        <td>6</td>
        <td class="off">7</td>
        <td>8</td>
        <td>9</td>
        <td>10</td>
        <td>11</td>
        <td>12</td>
      </tr>
      <tr>
        <td class="today">13</td>
        <td class="off">14</td>
        <td>15</td>
        <td>16</td>
        <td>17</td>
        <td>18</td>
        <td>19</td>
      </tr>
      <tr>
        <td>20</td>
        <td class="off">21</td>
        <td>22</td>
        <td>23</td>
        <td>24</td>
        <td>25</td>
        <td>26</td>
      </tr>
      <tr>
        <td>27</td>
        <td class="off">28</td>
        <td>29</td>
        <td>30</td>
        <td>31</td>
        <td class="mute">1</td>
        <td class="mute">2</td>
      </tr>
    </tbody>
  </table>
  <table class="calendar">
    <thead>
      <tr>
        <th class="sun">日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th class="sat">土</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="mute">27</td>
        <td class="mute">28</td>
        <td class="mute">29</td>
        <td class="mute">30</td>
        <td class="mute">31</td>
        <td>1</td>
        <td>2</td>
      </tr>
      <tr>
        <td>3</td>
        <td class="off">4</td>
        <td>5</td>
        <td>6</td>
        <td>7</td>
        <td>8</td>
        <td>9</td>
      </tr>
      <tr>
        <td class="today">10</td>
        <td class="off">11</td>
        <td>12</td>
        <td>13</td>
        <td>14</td>
        <td>15</td>
        <td>16</td>
      </tr>
      <tr>
        <td>17</td>
        <td class="off">18</td>
        <td>19</td>
        <td>20</td>
        <td>21</td>
        <td>22</td>
        <td>23</td>
      </tr>
      <tr>
        <td>24</td>
        <td class="off">25</td>
        <td>26</td>
        <td>27</td>
        <td>28</td>
        <td>29</td>
        <td>30</td>
      </tr>
    </tbody>
  </table>
    -->
 
</div>
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