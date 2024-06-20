<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>動物検索</title>
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
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
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
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QAServlet">Q&amp;A</a></li>
        
      </ul>
    </nav>
  <!-- ヘッダーここまで -->
  </header>

  <form method="post" action="/C3/AnimalSearchServlet">
    <main class="search">
    <table>
      <tr>
        <td>
          <label>所属団体<br>
            <select>
              <c:forEach var="e" items="${organizationsList}" >
              <option value="${e.user_id}">${e.user_name}</option></c:forEach>
            </select>
          </label>
        </td>
        <td>
          <label>名前<br>
          <input type="text" name="name">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>犬か猫か<br>
          <input type="checkbox" name="animal" value="dog">犬<br>
          <input type="checkbox" name="animal" value="cat">猫<br>
          </label>
        </td>
        <td>
          <label>種類<br>
          <input type="text" name="kind">
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>性別<br>
          <input type="radio" name="gender" value="male">オス<br>
          <input type="radio" name="gender" value="female">メス<br>
          </label>
        </td>
        <td>
          <label>年齢<br>
          <input type="text" name="age">
          </label>
        </td>
      </tr>

      <tr>
        <td>
          <input type="submit" id="search" name="submit" value="検索">
        </td>
      </tr>
    </table>
    </main>
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