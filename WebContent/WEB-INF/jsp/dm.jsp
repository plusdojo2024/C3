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
    <div class="home">
      <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
  <div class="logout">
      <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>

  <!-- ヘッダーここまで -->
  </header>
<body>
<main>
  <h1>団体DM</h1>
   <form action="/C3/DmTalkServlet" method="get">
    <c:forEach var="e" items="${organizationsList}" >
    <option value="">${e.user_name}</option></c:forEach>

   <table class="dm">
      <tr>
        <td>
  <input type="search" name="user_name" list="ユーザー名">
  <datalist id="ユーザー名">
    <option value="ひらちゃん">
    <option value="いりちゃん">
    <option value="水ちゃん">
  </datalist>
  <input type="submit" value="DM">
      </td>
    </tr>
  </table>
</form>
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