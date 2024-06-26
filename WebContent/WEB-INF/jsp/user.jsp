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
      font-weight: bold; /* または数値 (100 - 900) */
    }
    </style>

</head>
<body id="top">
  <!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div>
    <nav class="nav">
      <ul>
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QAServlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
<!-- メイン -->
  <main class="user n">
  <h1>新規登録</h1>
  <form method="post" action="/C3/UserServlet" name="addUser">
    <table>
      <tr>
        <td>
          <label>新規ユーザー名<br>
          <input type="text" name="user_name">
          </label>
        </td>
      <tr>
        <td>
          <label>新規ユーザーID<br>
          <input type="text" name="user_id">
          </label>
        </td>
       <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="user_password">
          </label>
        </td>
       <tr>
        <td colspan="2">
          <input type="submit" id="register" name="submit" value="登録">
          <input type="reset" name="reset" value="リセット">
          <span id="error_message"></span>
        </td>
    </table>
  </form>
  </main>
  <!-- メインここまで -->
<!-- フッター -->
  <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  <!-- フッターここまで -->
  </footer>


<script>
  'use strict';
  let form = document.getElementById("addUser");
form.onsubmit = function(){
	if(!form.user_id.value || !form.user_name.value || !form.user_id.value || !form.user_password.value){
		window.alert("すべて入力してください。")
		event.preventDefault;
	    return false;
	}
}
</script>
</body>
</html>