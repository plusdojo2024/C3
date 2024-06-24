<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>アニコン(管理者)</title>
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
      <a href="ManagerLoginServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
    <div class="logout">
      <a href="HomeServlet">ユーザーホーム</a>
    </div>
  <!-- ヘッダーここまで -->
  </header>
  <!-- メイン -->

  <main class="login m ">
  <h1>管理者ログイン</h1>
  <form method="post" action="/C3/ManagerLoginServlet" id="login_form">
    <table class="login m">
      <tr>
        <td>
          <label>ID<br>
          <input type="text" name="anicon_id">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="anicon_password">
          </label>
        </td>
      <tr>
      <tr>
        <td colspan="2">
          <input type="submit" name="submit" value="ログイン">
          <input type="reset" name="reset" value="リセット">
          <span id="error_message"></span>
        <td>
      </tr>
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
  </footer>
  <!-- フッターここまで -->
  <!-- JavaScript（ここから） -->
<script>
/* HTML要素をオブジェクトとして取得する */
let formObj = document.getElementById('login_form');
let errorMessageObj = document.getElementById('error_message');

/* [ログイン]ボタンをクリックしたときの処理*/
formObj.onsubmit = function() {
  if (!formObj.anicon_id.value || !formObj.anicon_password.value) {
    errorMessageObj.textContent = '※IDとパスワードを入力してください！';
    return false;
  }
  errorMessageObj.textContent = null;
};

/* [リセット]ボタンをクリックしたときの処理 */
formObj.onreset = function() {
  errorMessageObj.textContent = null;
};
</script>
<!-- JavaScript（ここまで） -->

</body>

</html>