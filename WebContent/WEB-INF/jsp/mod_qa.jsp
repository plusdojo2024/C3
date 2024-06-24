<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&amp;A編集</title>
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
    <a href="ManagerServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>

  <div class="logout">
    <a href="HomeServlet"><!-- <img src="./img/images/logout.png" alt="ログアウト" width="130" height="40">-->ユーザーホーム</a>
  </div>
</header>
<main>
<h1>Q&amp;A編集</h1>
<form method="post" action="/C3/ModQAServlet">
 <c:forEach var="e" items="${qaList}" >
    <p>Q${e.question}</p><br>
    <p>Q${e.answer}</p></c:forEach>
  <textarea cols="60" rows="10" placeholder="内容" name="detail"></textarea><br>
  <input type="submit" id="register" name="submit" value="登録"><br>
</form>

<form method="post" action="/C3/ModQAServlet">
  <select name="id">
    <c:forEach var="e" items="${qaList}" >
    <p>Q${e.question}</p><br>
    <p>Q${e.answer}</p></c:forEach>
  </select><br>
  <textarea cols="60" rows="10" placeholder="内容" name="detail"></textarea><br>
  <input type="submit" name="submit" value="更新">
  <input type="submit" name="submit" value="削除">
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