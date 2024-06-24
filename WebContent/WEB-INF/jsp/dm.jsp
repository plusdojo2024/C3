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
      <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div></c:if>

    <c:if test="${not empty id}">  <div class="logout">
    <a href="LogoutServlet"><img src="./img/images/logout.png" alt="ログアウト" width="150" height="55"></a>
    </div></c:if>





  <!-- ヘッダーここまで -->
  </header>
<body>
<main>
  <h1>団体DM</h1>


    <form action="/C3/DmTalkServlet" method="get">
  <input type="search" name="user_name" list="ユーザー名">
  <datalist id="ユーザー名">
    <c:forEach var="e" items="${userList}">
    <option value="${e.user_name}"></option>
    <input type="hidden" value="${e.id}" name="yourId">
    </c:forEach>
  </datalist>
  <input type="submit" value="DM" name="DM2"></form>


<div style="text-align:center;">
  <c:forEach var="t" items="${talkUserList}">
  <form action="/C3/DmTalkServlet" method="get" style="margin:15px;">
<input type="submit" value="${t.user_name}" style="background:transparent;  border-color:#fffaf0;" name="select">
<input type="hidden" value="${t.who_id}" name="yourId">
<input type="hidden" value="${t.user_name}" name="yourName"><hr>
 </form>   </c:forEach></div>

   <table class="dm">
      <tr>
        <td>

      </td>
    </tr>
  </table>
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