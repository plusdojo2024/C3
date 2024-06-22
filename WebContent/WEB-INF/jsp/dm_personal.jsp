<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>DM</title>
  <link rel="stylesheet" href="/C3/css/dm.css">
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

    <nav class="nav">
      <ul>
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QASersvlet">Q&amp;A</a></li>
        <li class="list5"><a href="/C3/DmPersonalServlet">DM</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
<body>
<main>
  <h1>ユーザーDM</h1>
   <form action="/C3/DmTalkServlet" method="get">
   <select name="yourId">
    <c:forEach var="e" items="${organizationsList}" >
    <option value="${e.id}" >${e.user_name}</option>
    </c:forEach>
   </select>
    <input type="submit" value="DM" name="DM1">
  </form>

  <form action="/C3/DmTalkServlet" method="get">
<div style="text-align:center;">
  <c:forEach var="t" items="${talkUserList}">
<input type="submit" value="${t.user_name}" style="background:transparent;  border-color:#fffaf0;" name="select">
<input type="hidden" value="${t.who_id}" name="yourId">
<input type="hidden" value="${t.user_name}" name="yourName"><hr>
    </c:forEach></div></form>

</main>
</body>

<!-- フッター -->
  <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</html>