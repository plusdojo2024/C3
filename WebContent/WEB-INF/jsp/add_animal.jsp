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
          <label>動物名<br>
          <input type="text" name="animal_name" >
          </label>
        </td>
        <td>
          <label>犬か猫か<br>
          <input type="radio" name="kind">
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
          <input type="radio" name="gender">
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
          <input type="text" name="birthday">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>保護期間<br>
          <input type="text" name="period">
          </label>
        </td>
        <td>
          <label>去勢手術の有無<br>
          <input type="radio" name="is_castration">
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
</body>
</html>