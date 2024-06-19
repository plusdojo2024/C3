<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>管理者ホーム</title>
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
  <div class="logout">
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>

<main class="group_manager_home">
  <table border="1">
    <tr>
      <td><a href="C3/AddGroupServlet">団体登録</a></td>
      <td><a href="C3/UpdateDeleteGroupServlet">団体更新・削除</a></td>
      <td><a href="C3/ModMachServlet">相性診断編集</a></td>
    </tr>
    <tr>
      <td><a href="C3/ModNewsServlet">お知らせ編集</a></td>
      <td><a href="C3/ModQAServlet">Q&amp;A編集</a></td>
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