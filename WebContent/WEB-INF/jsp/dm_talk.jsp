<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>DM</title>
  <link rel="stylesheet" href="/C3/css/dm.css">
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
      <a href="DmPersonalServlet"><img src="./img/images/dmtalk.png" alt="Start Chat" width="250" height="247"></a>
    </div>
  </header>
  <body>
  <main>
  <h1>Chat</h1>
   <div id="chat">

   <div style="text-align:center; background-color:#996633; font-size:40px; padding:10px; margin-bottom:15px;">
   <c:forEach var="o" items="${orgList}">${o.user_name}</c:forEach></div>
   <c:forEach var="t" items="${talkList}">
   <c:if test="${t.send_id == number}">
   <div style="text-align:right; margin:15px; font-size:20px;">
   ${t.dm_detail}
   </div></c:if>
<c:if test="${t.send_id != number}">
<div style="display:block; margin-left:0; margin:15px; font-size:20px;">
${t.dm_detail}
</div></c:if>
   </c:forEach>
   </div>


   <form action="/C3/DmTalkServlet" method="post">
    <div id="inputArea">
        <input type="text" id="message" name="dmDetail" placeholder="メッセージを入力...">
        <!-- <button onclick="sendMessage()">送信</button>-->
         <input type="hidden" value="${yourId}" name="yourId2">

        <input type="submit" value="送信" name="DM1">
    </div>
    </form>
  </main>
</body>
  <!-- フッター -->
  <footer>
    <div class="gotop">
      <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
    </div>
    <p class="copyright">&copy; dacho_group</p>
  </footer>
  <!-- フッターここまで -->
</html>