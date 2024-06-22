<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>訪問予約確認</title>
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
  <div class="home">
    <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>
  <div class="logout">
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>

<h2>予約申請一覧</h2>
<c:forEach var="e" items="${rsvList}" >
    <form class="groupform" method="post" action="/C3/ReserveServlet" >
 ${e.user_name}<br>${e.rsv_day}<br>${e.animal_name}<br>${e.reservation_remarks}<br>
 <input type="hidden" value="${e.id}" name="id">
      <input type="submit" name="accept" value="承認"><br>
    </form>
  </c:forEach>
<h2>承認済み</h2>
  <c:forEach var="r" items="${rsvsList}" >
    <form class="groupform" method="post" action="/C3/ReserveServlet" >
 ${r.user_name}<br>${r.rsv_day}<br>${r.animal_name}<br>${r.reservation_remarks}<br>
 <input type="hidden" value="${e.id}" name="id">
    </form>
  </c:forEach>


 <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</body>
</html>