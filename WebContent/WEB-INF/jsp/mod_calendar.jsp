<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>カレンダー編集</title>
 <link rel="stylesheet" href="/C3/css/mod_calendar.css">
<style >
    body {
      background-color: #FFFAF0; /* 背景色を薄茶色に設定 */
      font-weight: bold; /* または数値 (100 - 900) */
    }
</style>
</head>
<body id ="top">
	<!-- ヘッダー -->
  <header>
    <c:if test="${empty id}"><div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div></c:if>
    <c:if test="${not empty id}"><div class="home">
      <a href="PersonalServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="245"></a>
    </div></c:if>

    <c:if test="${not empty id}">  <div class="logout">
    <a href="LogoutServlet"><img src="./img/images/logout.png" alt="ログアウト" width="150" height="55"></a>
    </div></c:if>
    <table>
      <tr>
        <td>
    <c:if test="${empty id}"><div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div></c:if>
        </td>
        <td>
  <c:if test="${empty id}"><div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="40"></a>
  </div></c:if>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li class="list1"><a href="/C3/GroupServlet">各団体</a></li>
        <li class="list2"><a href="/C3/AnimalSerachServlet">動物検索</a></li>
        <li class="list3"><a href="/C3/CalendarServlet">カレンダー</a></li>
        <li class="list4"><a href="/C3/QAServlet">Q&amp;A</a></li>
    <c:if test="${not empty id}">
        <li class="list5"><a href="/C3/DmPersonalServlet">DM</a></li>
    </c:if>
      </ul>
    </nav>
  <!-- ヘッダーここまで -->
  </header>

 　<main class="mod_calendar">
  <h1>カレンダー編集</h1>
  // 登録テーブル
  <table>
      <tr>
        <td>
          <label>譲渡会名<br>
          <input type="text" name="event_name">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>日時<br>
          <input type="text" name="event_day">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>場所<br>
          <input type="text" name="event_place">
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>備考<br>
          <input type="text" name="event_remarks">
          </label>
        </td>
       </tr>
   </table>
  <div class="regist">
    <input type="submit" id="regist" name="submit" value="登録">
  </div>
  // 更新・削除テーブル
   <table>
      <tr>
        <td>  
          <label>譲渡会名<br>
            <select>
              <c:forEach var="e" items="${organizationsList}" >
              <option value="${e.user_id}">${e.user_name}</option></c:forEach>
            </select>
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>日時<br>
          <input type="text" name="event_day">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>場所<br>
          <input type="text" name="event_place">
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>備考<br>
          <input type="text" name="event_remarks">
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>団体名<br>
          <input type="text" name="user_name">
          </label>
        </td>
       </tr>
   </table>
  <div class="update_delete">
    <input type="submit" id="update" name="submit" value="更新">
    <input type="submit" id="delete" name="submit" value="削除">
  </div>
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