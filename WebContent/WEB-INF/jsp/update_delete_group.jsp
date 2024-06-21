<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>団体更新・削除</title>
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
      <a href="ManagerServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
    <div class="logout">
      <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
    </div>
  <!-- ヘッダーここまで -->
  </header>
<main>
  <h1>団体更新・削除</h1>
</main>


<c:forEach var="e" items="${organizationsList}" >
  <form method="post" action="/C3/UpdateDeleteServlet">
    団体ユーザーID<input type="text" name="user_id" value="${e.user_id}"><br>
    パスワード<input type="text" name="user_password" value="${e.user_password}"><br>
    団体名<input type="text" name="user_name" value="${e.user_name}"><br>
    住所<input type="text" name="adress" value="${e.address}"><br>
    電話番号<input type="text" name="phonen_number" value="${e.phone_number}"><br>
    メールアドレス<input type="text" name="emails" value="${e.emails}"><br>
    備考<input type="text" name="remarks" value="${e.remarks}"><br>
    <input type="submit" name="submit" value="更新">
    <input type="submit" name="submit" value="削除"><br>
  </form>
</c:forEach>
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