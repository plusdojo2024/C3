<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>訪問予約</title>
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

<form method="post" action="/C3/VisitServlet" name="visit">
  <label>所属団体<br>
    <select name="orgId">
      <c:forEach var="e" items="${organizationsList}" >
      <option value="${e.id}">${e.user_name}</option></c:forEach>
    </select>
  </label><br>
  <label>動物名<br>
    <input type="text" name="animal_name" >
  </label><br>
  <label>日時<br>
    <input type="date" name="rsv_day" >
  </label><br>
  <label>電話番号<br>
    <input type="tel" name="phone_number" >
  </label><br>
  <label>備考<br>
    <textarea cols="60" rows="10" name="remarks"></textarea>
  </label><br>
  <input type="submit" name="submit" value="申請">
  <input type="reset" name="reset" value="リセット">
</form>


<!-- フッター -->
<footer>
  <div class="gotop">
    <a href="#top"><img src="./img/images/nikukyu.png" alt="トップページへ戻る" width="60" height="60"></a>
  </div>
  <p class="copyright">&copy; dacho_group</p>
</footer>
<!-- フッターここまで -->

  <script>
  'use strict';
  let form = document.getElementById("visit");
form.onsubmit = function(){
	if(!form.user_id.value || !form.orgId.value || !form.animal_name.value || !form.rsv_day.value || !form.phone_number.value){
		window.alert("備考以外はすべて入力してください。")
		event.preventDefault;
	    return false;
	}
}

//2. 表示/非表示を一気に更新する（表示条件は、引数と一致する id のサブBOX）
var dispSubBox = function(subId) {
  [...document.querySelectorAll(".subbox2")].forEach(function(elm){
    elm.style.display = elm.id===subId ? "inline": "none"
  });
}
dispSubBox(); // 一致する id がないので全て 非表示になる。

// 1. select.subbox の操作で値が変わると発火するイベント
//document.getElementById("cate").addEventListener("cange", function(event){
document.getElementById("cate").addEventListener("change", function(event){
  var elm = event.target; // select#id になる。
  //console.log( elm.id ); // "cate"
  //console.log( elm.value ); // サブBOXに与えた id と同じ
  dispSubBox( elm.value ); // 全更新：一致idだけ表示
});
</script>
</body>
</html>