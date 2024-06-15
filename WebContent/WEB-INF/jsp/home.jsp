<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>アニコン</title>
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
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div>
        </td>
        <td>
  <div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="40"></a>
  </div>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li class="list1"><a href="C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li class="list3"><a href="C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="C3/QASevlet">Q&ampA</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>

<!-- メイン -->
  <main>
  <h1>お知らせ</h1>
  <h2>日記</h2>
   <div class="mach">
      <a href="MachServlet"><img src="./img/images/mach.png" alt="" width="250" height="250"></a>
   </div>
  </main>
  <!-- メインここまで -->

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