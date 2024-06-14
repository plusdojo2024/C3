<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>アニコン</title>
  <link rel="stylesheet" href="/C3/css/style.css">
</head>
<body id="top">
  <!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="350" height="100"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login1.png" alt="ログイン" width="140" height="40"></a>
  </div>
        </td>
        <td>
  <div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="33"></a>
  </div>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li><a href="C3/GroupServlet">各団体</a></li>
        <li><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li><a href="C3/CalendarServlet">カレンダー</a></li>
        <li><a href="C3/QASevlet">Q&ampA</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
  <!-- メイン -->

  <main class="login m ">
  <h2>ログイン</h2>
  <form method="post" action="/C3/LoginServlet">
    <table class="login m">
      <tr>
        <td>
          <label>ユーザーID<br>
          <input type="text" name="id">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="pw">
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

/* [ログイン]ボタンをクリックしたときの処理 */
formObj.onsubmit = function() {
  if (!formObj.id.value || !formObj.pw.value) {
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