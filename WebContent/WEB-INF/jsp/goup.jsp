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
        <li class="list1"><a href="C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li class="list3"><a href="C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="C3/QASevlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
<body>
    <form action="group-servlet" method="post">
        <input type="hidden" name="user_id" value="user_id" ><br>
        <input type="hidden" name="address" value="address" ><br>
        <input type="hidden" name="phonenumber" value="phonenumber" ><br>
        <input type="hidden" name="email" value="email" ><br>
        <input type="hidden" name="remarks" value="remarks" ><br>
    </form>
</body>
</html>