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
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="350" height="100"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="logout">
      <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="160"height="40"></a>
  </div>
        </td>
       </tr>
  </table>
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