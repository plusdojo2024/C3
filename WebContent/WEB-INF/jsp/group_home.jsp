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
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="150" height="55"></a>
  </div>
</header>

<main class="group_manager_home">
  <table border="1">
    <tr>
      <td><a href="C3/AddAnimalServlet">動物登録</a></td>
      <td><a href="C3/AnimalServlet">動物一覧(更新・削除)</a></td>
      <td><a href="C3/ModCalendarServlet">カレンダー編集</a></td>
    </tr>
    <tr>
      <td><a href="C3/ModGroupNewsServlet">団体お知らせ編集</a></td>
      <td><a href="C3/DmServlet">DM</a></td>
      <td><a href="C3/ReserveServlet">訪問予約確認</a></td>
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