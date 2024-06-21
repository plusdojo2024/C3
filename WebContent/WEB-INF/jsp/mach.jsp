<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相性診断</title>
<link rel="stylesheet" href="/C3/css/style.css">
<style>
    body {
      background-color: #FFFAF0; /* 背景色を薄茶色に設定 */
      font-weight: bold; /* または数値 (100 - 900) */
    }
    </style>
</head>
<body id="top">
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
  <h1>相性診断</h1>


  <!-- １問目 -->
  <form action="/C3/MachServlet" method="post">
  <p>Q1「スポーツは観るより、やる方だ」</p>
  <span>
  YES<input type="radio" name="answer1" value="yes">
  NO<input type="radio" name="answer1" value="no">
  </span>
  <!-- 2問目 -->
  <p>Q2「友達は多い方が良いと考えるほうだ」</p>
  <span>
  YES<input type="radio" name="answer2" value="yes">
  NO<input type="radio" name="answer2" value="no">
  </span>
  <!-- 3問目 -->
  <p>Q3「人を従えるより、従う方が好きだ」</p>
  <span>
  YES<input type="radio" name="answer3" value="yes">
  NO<input type="radio" name="answer3" value="no">
  </span>
  <!-- 4問目 -->
  <p>Q4「腹が立っても顔には出さない方だ」</p>
  <span>
  YES<input type="radio" name="answer4" value="yes">
  NO<input type="radio" name="answer4" value="no">
  </span>
  <!-- 5問目 -->
  <p>Q5「初対面の人とも上手く打ち解けられる方だ」</p>
  <span>
  YES<input type="radio" name="answer5" value="yes">
  NO<input type="radio" name="answer5" value="no"><br>
  </span>
  <input type="submit" value="診断" name="mach">
</form>
  </main>
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