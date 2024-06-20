<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録</title>
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
    <a href="GroupHomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
  </div>
  <div class="logout">
    <a href="HomeServlet"><img src="./img/images/logout.png" alt="ログアウト" width="130" height="40"></a>
  </div>
</header>
 <form method="post" action="/C3/AddAnimalServlet">

    <table>
      <tr>
        <td>
          <label>写真<br>
          <input type="text" name="img">
          </label>
        </td>
        <td>
          <label>ID<br>
          <input type="text" name="ID" value="(自動採番)" readonly="readonly" style="background-color: lightgray">
          </label>
        </td>

      </tr>
      <tr>
        <td>
          <label>動物名<br>
          <input type="text" name="animal_name" >
          </label>
        </td>
        <td>
         <label>犬か猫か<br>
           <input type="checkbox" name="animal" value="dog">犬<br>
           <input type="checkbox" name="animal" value="cat">猫<br>
         </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>種類<br>
          <input type="text" name="type">
          </label>
        </td>
        <td>
          <label>性別<br>
            <input type="radio" name="gender" value="male">オス<br>
            <input type="radio" name="gender" value="female">メス<br>
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>年齢<br>
          <input type="text" name="age">
          </label>
        </td>
        <td>
          <label>誕生日<br>
          <input type="date" name="birthday">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>保護日<br>
          <input type="date" name="period">
          </label>
        </td>
        <td>
          <label>去勢手術の有無<br>
          <input type="radio" name="is_castration" value="do">有<br>
          <input type="radio" name="is_castration" value="not">無<br>
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <label>備考<br>
          <textarea name="remarks"></textarea>
          </label>
        <td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" id="register" name="submit" value="登録">
          <input type="reset" name="reset" value="リセット">
          <span id="error_message"></span>
        </td>
      </tr>
    </table>
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