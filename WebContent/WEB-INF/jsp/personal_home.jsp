<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>個人ユーザーホーム</title>
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
   <nav class="nav">
      <ul>
        <li class="list1"><a href="C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li class="list3"><a href="C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="C3/QASevlet">Q&amp;A</a></li>
    </ul>
  </nav>
</header>

  <main class="home p">
  <div class="diary">
      <a href="DiaryServlet"><img src="./img/images/diary.png" alt="" width="250" height="250"></a>
   </div>

   <div class="visit">
      <a href="VisitServlet"><img src="./img/images/visit.png" alt="" width="250" height="250"></a>
   </div>

  <div class="mach">
      <a href="MachServlet"><img src="./img/images/mach.png" alt="" width="250" height="250"></a>
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