<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>団体お知らせ編集</title>
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
  <div class="home">
    <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>
  <div class="logout">
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>

<form method="post" action="/C3/ModNewsServlet">
  <input type="text" name="news_title" placeholder="題名"><br>
  <textarea cols="60" rows="10" placeholder="内容"></textarea><br>
  <input type="submit" id="register" name="submit" value="登録"><br>
</form>

<form method="post" action="/C3/ModNewsServlet">
  <select>
    <option value="題名1">題名</option>
    <option value="題名２">題名２</option>
  </select><br>
  <input type="text" name="news_title" placeholder="題名"><br>
  <textarea cols="60" rows="10" placeholder="内容"></textarea><br>
  <input type="submit" name="submit" value="更新">
  <input type="submit" name="submit" value="削除">
</form>
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