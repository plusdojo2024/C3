<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>団体ホーム</title>
<link rel="stylesheet" href="/C3/css/style.css">
<style>
  body {
    background-color: #FFFAF0; /* 背景色を薄茶色に設定 */
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

<main class="group_manager_home">
  <table>
    <tr>
      <td><a href="C3/AddAnimalServlet"></a></td>
      <td><a href="C3/AnimalServlet"></a></td>
      <td><a href="C3/ModCalendarServlet"></a></td>
    </tr>
    <tr>
      <td><a href="C3/ModGroupNewsServlet"></a></td>
      <td><a href="C3/DmServlet"></a></td>
      <td><a href="C3/ReserveServlet"></a></td>
    </tr>
  </table>
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