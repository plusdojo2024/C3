<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form method="post" action="/C3/AnimalSearchServlet">
    <table>
      <tr>
        <td>
          <label>所属団体<br>
          <input type="checkbox" name="organization_name" value="A">A<br>
          <input type="checkbox" name="organization_name" value="B">B<br>
          <input type="checkbox" name="organization_name" value="C">C<br>
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
          <label>犬猫<br>
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
        <td colspan="2">
          <input type="submit" id="search" name="submit" value="検索">
          <span id="error_message"></span>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>