<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <c:if test="${empty individualList}">
    <p>一致するデータはありません。</p>
  </c:if>

  <c:forEach var="e" items="${individualList}" >

      写真
      所属団体<input type="checkbox" name="organization_name" value="${e.organization_name}"><br>
      名前<input type="text" name="name" value="${e.name}"><br>
      種類<input type="text" name="kind" value="${e.kind}"><br>
      年齢<input type="text" name="age" value="${e.age}"><br>
      性別<input type="radio" name="gender" value="${e.gender}"><br>
      保護日<input type="text" name="period" value="${e.period}"><br>
      備考<input type="text" name="remarks" value="${e.remarks}"><br>
      去勢識別<input type="text" name="castration" value="${e.castration}"><br>
      誕生日<input type="text" name="birthday" value="${e.birthday}"><br>
    <hr>
  </c:forEach>

</body>
</html>