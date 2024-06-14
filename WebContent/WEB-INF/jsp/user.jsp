<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form id="signup_form" action="result.html">
    <table>
      <tr>
        <td>
          <label>新規ユーザー名<br>
          <input type="text" name="name">
          </label>
        </td>
      <tr>
        <td>
          <label>新規ユーザーID<br>
          <input type="text" name="userid">
          </label>
        </td>
       <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="password">
          </label>
        </td>
        <tr>
        <td colspan="2">
          <input type="submit" id="register" name="submit" value="登録">
          <input type="reset" name="reset" value="リセット">
          <span id="error_message"></span>
        </td>
    </table>
</form>
</body>
</html>