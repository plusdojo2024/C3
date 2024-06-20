<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <a href="PersonalServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
  <div class="logout">
      <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
    <nav class="nav">
      <ul>
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QASersvlet">Q&amp;A</a></li>
        <li class="list5"><a href="/C3/DmPersonalServlet">DM</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
<body>
<main>
  <h1>ユーザーDM</h1>
   <form action="/C3/DmTalkServlet" method="get">
   <table class="dm">
      <tr>
        <td>
  <input type="search" name="user_name" list="団体名">
  <datalist id="団体名">
    <option value="保護団体A">
    <option value="保護団体B">
    <option value="保護団体C">
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