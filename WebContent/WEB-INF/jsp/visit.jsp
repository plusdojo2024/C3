<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>訪問予約</title>
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
    <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
  </div>
  <div class="logout">
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>

  <nav class="nav">
    <ul>
      <li class="list1"><a href="C3/GroupServlet">各団体</a></li>
      <li class="list2"><a href="C3/AnimalSearchServlet">動物検索</a></li>
      <li class="list3"><a href="C3/CalendarServlet">カレンダー</a></li>
      <li class="list4"><a href="C3/QASevlet">Q&amp;A</a></li>
      <li class="list5"><a href="C3/DMSevlet">DM</a></li>
  </ul>
  </nav>
  <!-- ヘッダーここまで -->
</header>

<form method="post" action="/C3/VisitServlet">
  <label>所属団体<br>
    <select>
      <option value="A">A</option>
      <option value="B">B</option>
      <option value="C">C</option>
    </select>
  </label><br>
  <label>個体名<br>
    <input type="text" name="animal_name" >
  </label><br>
  <label>日時<br>
    <input type="date" name="date" >
  </label><br>
  <label>電話番号<br>
    <input type="tel" name="tel" >
  </label><br>
  <label>備考<br>
    <textarea cols="60" rows="10"></textarea>
  </label><br>
  <input type="submit" name="submit" value="申請">
  <input type="reset" name="reset" value="リセット">
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