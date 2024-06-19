<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>団体詳細登録</title>
<link rel="stylesheet" href="/C3/css/style.css">
</head>
<body id="top">
  <!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
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
        <li><a href="/C3/GroupServlet">各団体</a></li>
        <li><a href="/C3/AnimalSearchServlet">動物検索</a></li>
        <li><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li><a href="/C3/QASevlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
<main>
  <h1>団体登録</h1>
</main>
    <form method="post" action="/C3/ManagerServlet">
※番号は自動採番されます。<br>

新規団体ユーザーID<input type="text" name="user_id"><br>
パスワード<input type="text" name="user_password"><br>
団体名<input type="text" name="user_name"><br>
住所<input type="text" name="adress"><br>
電話番号<input type="text" name="phonenumber"><br>
メールアドレス<input type="text" name="email"><br>
備考<input type="text" name="remarks"><br>
<input type="submit" name="regist" value="登録">
<input type="reset" name="reset" value="リセット">
</form>
<div class="mach">
      <a href="MachServlet"><img src="./img/images/mach.png" alt="" width="250" height="250"></a>
   </div>
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