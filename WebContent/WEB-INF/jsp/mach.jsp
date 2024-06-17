<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相性診断</title>
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
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login1.png" alt="ログイン" width="140" height="40"></a>
  </div>
        </td>
        <td>
  <div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="33"></a>
  </div>
        </td>
      </tr>
  </table>

    <nav class="nav">
      <ul>
        <li><a href="C3/GroupServlet">各団体</a></li>
        <li><a href="C3/AnimalSearchServlet">動物検索</a></li>
        <li><a href="C3/CalendarServlet">カレンダー</a></li>
        <li><a href="C3/QASevlet">Q&amp;A</a></li>
    </ul>
  </nav>
  <!-- ヘッダーここまで -->
  </header>
  <main>
  <h1>相性診断</h1>
  
  <!-- １問目 -->
  <p>「スポーツは観るより、やる方だ」</p>
  <p>YES</p><input type="radio" name="answer1" value="yes">
  <p>NO</p><input type="radio" name="answer1" value="no">
  
  <!-- 2問目 -->
  <p>「友達は多い方が良いと考えるほうだ」</p>
  <p>YES</p><input type="radio" name="answer2" value="yes">
  <p>NO</p><input type="radio" name="answer2" value="no">
  
  <!-- 3問目 -->
  <p>「人を従えるより、従う方が好きだ」</p>
  <p>YES</p><input type="radio" name="answer3" value="yes">
  <p>NO</p><input type="radio" name="answer3" value="no">
  
  <!-- 4問目 -->
  <p>「腹が立っても顔には出さない方だ」</p>
  <p>YES</p><input type="radio" name="answer4" value="yes">
  <p>NO</p><input type="radio" name="answer4" value="no">
  
  <!-- 5問目 -->
  <p>「初対面の人とも上手く打ち解けられる方だ」</p>
  <p>YES</p><input type="radio" name="answer5" value="yes">
  <p>NO</p><input type="radio" name="answer5" value="no">
  </main>
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