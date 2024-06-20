<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物一覧</title>
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
    <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>
  <div class="logout">
    <a href="LogoutServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>

 <c:forEach var="e" items="${individualList}" >

    <form method="post" action="/C/UpdateDeleteServlet">
      ※IDは、変更できません。<br>
      ID<input type="text" name="id" value="${e.id}" readonly="readonly"><br>

      写真<input type="text" name="img" value="${e.img}"><br>
      動物名<input type="text" name="animal_name" value="${e.animal_name}"><br>
      犬か猫か<input type="radio" name="kind" value="${e.kind}"><br>
      種類<input type="text" name="type" value="${e.type}"><br>
      年齢<input type="text" name="age" value="${e.age}"><br>
      誕生日<input type="date" name="" value="${e.birthday}"><br>
      保護日<input type="date" name="period" value="${e.period}"><br>
      去勢手術の有無<input type="radio" name="is_castration" value="${e.is_castration}"><br>
      備考<input type="text" name="remarks" value="${e.remarks}"><br>
      <input type="submit" name="submit" value="更新">
      <input type="submit" name="submit" value="削除"><br>
    </form>
    <hr>
  </c:forEach>


<footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</body>
</html>