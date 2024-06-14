<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="/C3/css/style.css">
</head>

<body id="top">
  <!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="home html"><img src="./img/images/logo.png" alt="アニコン" width="350" height="100"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="login">
      <a href="login html"><img src="./img/images/login1.png" alt="ログイン" width="140" height="40"></a>
  </div>
        </td>
      </tr>
   </table>
   <nav class="nav">
      <ul>
        <li><a href="C3/GroupServlet">各団体</a></li>
        <li><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li><a href="C3/CalendarServlet">カレンダー</a></li>
        <li><a href="C3/QASevlet">QandA</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
   </header>

 <form method="post" action="C3/UserServlet">
    <table>
      <tr>
        <td>
          <label>新規ユーザー名<br>
          <input type="text" name="name">
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
<!-- フッター -->
  <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
  </footer>
</body>
</html>