<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>団体詳細</title>
</head>
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
</header>
<body>
<main>
<div class="h1">
  <h1>お知らせ</h1><br>
  <c:forEach var="n" items= "${newsList}" >
  <p>${n.news_title}</p>
  <p style="font-size:1.0rem;">${n.news_detail}</p>
  <p style="font-size:1.0rem;color:#D2B48C;">投稿日：${n.news_day}
</c:forEach></div>

<h1>動物一覧</h1>
<c:forEach var="i" items= "${individualList}">
<div class="groupform" >

      写真：<br>
      所属団体：${i.user_name}<br>
      名前：${i.animal_name}<br>
      ${i.kind}<br>
      種類：${i.type}<br>
      年齢：${i.age}<br>
      性別：${i.gender}<br>
      保護日：${i.period}<br>
      備考：${i.remarks}<br>
      去勢識別：<c:if test="${i.is_castration == true}">済<br></c:if>
      			<c:if test="${i.is_castration == false}">未<br></c:if>
      誕生日：${i.birthday}<br>
      </div>
</c:forEach>
</main>
<footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</body>
</html>