<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>訪問予約確認</title>
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
    <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>
  <div class="logout">
    <a href="LogoutServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>

<!--
<c:forEach var="e" items="${cardList}" >

    <form method="post" action="/C3/ReserveServlet">
      ※番号は、変更できません。<br>
      ID<name="ID" value="${e.number}"><br>
      会社名<input type="text" name="company" value="${e.company}"><br>
      部署名<input type="text" name="department" value="${e.department}"><br>
      役職名<input type="text" name="position" value="${e.position}"><br>
      氏名<input type="text" name="name" value="${e.name}"><br>
      ふりがな<input type="text" name="ruby" value="${e.ruby}"><br>
      郵便番号<input type="text" name="zipcode" value="${e.zipcode}"><br>
      住所<input type="text" name="address" value="${e.address}"><br>
      電話番号<input type="text" name="phone" value="${e.phone}"><br>
      登録日<input type="date" name="date" value="${e.date}"><br>
      備考<input type="text" name="remarks" value="${e.remarks}"><br>
      <input type="submit" name="accept" value="承認"><br>
    </form>
    <hr>
  </c:forEach>
-->


 <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</body>
</html>