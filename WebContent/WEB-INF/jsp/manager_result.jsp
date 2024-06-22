<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>アニコン</title>
  <link rel="stylesheet" href="/C3/css/style.css">
  <link rel="stylesheet" href="/C3/css/style.css">
<style>
  body {
    background-color: #FFFAF0; /* 背景色を薄茶色に設定 */
  }
</style>
</head>
<body id="top">
<header>
  <div class="home">
    <a href="ManagerServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
  </div>
</header>
  <main>
<h2>${result.title}</h2>
<hr>
<div class="result">
<p>${result.message}</p>
<a href="${result.backTo}">戻る</a>
</div>
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
