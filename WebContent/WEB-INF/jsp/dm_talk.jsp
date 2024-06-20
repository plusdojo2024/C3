<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <div id="chat"></div>
   <form action="DmTalkServlet">
    <div id="inputArea">
        <input type="text" id="message" placeholder="メッセージを入力...">
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