<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QAServlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>

<!-- メイン -->
  <main>
  <div class="h1">
  <h1>お知らせ</h1><br>
  <div>
  <c:forEach var="e" items= "${newsList}" begin="0" end="0">
  <p>${e.news_title}</p>
  <p style="font-size:1.0rem;">${e.news_detail}</p>
  <p style="font-size:1.0rem;color:#D2B48C;">投稿日：${e.news_day}
</c:forEach>
  <!-- <p>動物感染症が流行しています。</p>
  <p style="font-size:1.5rem;color:#D2B48C;">投稿日：2024/04/25
  <div class="1"><!-- ＋ボタンを押したら表示されるid
  <p>新しい保護施設が追加されました。</p>
  <p style="font-size:1.5rem;color:#D2B48C;">投稿日：2024/03/12-->
  </div>
<div class="1">
<c:forEach var="e" items= "${newsList}" begin="1">
<div>
  <p>${e.news_title}</p>
  <p style="font-size:1.0rem;">${e.news_detail}</p>
  <p style="font-size:1.5rem;color:#D2B48C;">投稿日：${e.news_day}
  </div>
</c:forEach></div>
  <div class="function">
    <img src="./img/images/function.png" alt="" width="60" height="60">
   </div>
   </div>
  <div class="h2">
  <h2>日記</h2><br>

 <c:forEach var="e" items= "${diaryList}" begin="0" end="1">

  <div class="h2">
  <form class="" action="/C3/DiaryServlet" method="get" name="form">
  <input type="hidden" value="${e.id}" name= "diaryId">
    <a id="groupfont" href="/C3/DiaryServlet" onclick="document.form.submit();">

 <!-- <p style="font-size:2rem;"> --> 題名：${e.diary_title}<br>
  <!-- <p style="font-size:1.5rem;color:#D2B48C;"> -->投稿者：${e.user_name}<br>
  <!-- <p style="font-size:1.5rem;color:#D2B48C;"> -->投稿日：${e.diary_day}<br>
  </a><input type="submit" value="詳細">
 </form></div>


</c:forEach>
 <!--   <p style="font-size:2rem;">題名：毎日の散歩
  <p style="font-size:1.5rem;color:#D2B48C;">投稿者：まめっち
  <p style="font-size:1.5rem;color:#D2B48C;">投稿日：2024/06/15-->
  <div class="1"><!-- ＋ボタンを押したら表示されるid -->

  <c:forEach var="e" items= "${diaryList}" begin="2" >
  <div class="h2">
  <form class="" action="/C3/DiaryServlet" method="get" name="a">
  <a id="groupfont" href="" onclick="document.a.submit();">
  題名：${e.diary_title}<br>
  投稿者：${e.user_name}<br>
  投稿日：${e.diary_day}<br></a>
<input type="hidden" value="${e.id}"name="diaryId">
<input type="submit" value="詳細">
  </form></div>
</c:forEach>

  <!--  <p style="font-size:2rem;">題名：我が家の日課
  <p style="font-size:1.5rem;color:#D2B48C;">投稿者：くちぱっち
  <p style="font-size:1.5rem;color:#D2B48C;">投稿日：2024/05/14-->
  </div>
  <div class="function">
    <img src="./img/images/function.png" alt="" width="60" height="60">
   </div>
  </div>


   <div class="mach">
      <a href="MachServlet"><img src="./img/images/mach.png" alt="" width="250" height="250"></a>
   </div>

   <script src="https://code.jquery.com/jquery.min.js"></script>
  <script>
  $(function() {
    $(".function").click(function() {
      $(".1").slideToggle("");
  });
    });
  </script>
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


</body>
</html>