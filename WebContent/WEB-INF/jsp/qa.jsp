<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>DM</title>
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
<body>
<main>
  <h1>Q&amp;A<br>-飼育の心得と必需品リスト-</h1>
 <!-- <c:forEach var="e" items="${qaList}" >
 <p>Q${e.question}</p><br>
 <p>Q${e.answer}</p>
</c:forEach>-->
<div class="qa-font">

<p style="color:#663300;font-size:1.5rem;">Q1.譲渡する前に何を用意しておく？<br></p>
<p style="font-size:1.3rem;">A.犬：餌皿、ハウス、歯ブラシ、リード、首輪、トイレ用品、ドッグフード、お風呂セット<br>
猫：餌皿、お風呂セット、歯ブラシ、トイレ用品、カリカリ、ゲージorキャットタワー<br><br><br></p>



<p style="color:#663300;font-size:1.5rem;">Q2.上記の物を用意するには犬猫を飼うための費用はどのくらい必要？<br></p>
<p style="font-size:1.3rem;">A.犬猫約10万円<br><br><br></p>



<p style="color:#663300;font-size:1.5rem;">Q3.毎日はみがきはするべき？<br></p>
<p style="font-size:1.3rem;">A.子犬、子猫のうちから慣らす事が重要です。<br>
   歯石がつかないように、また歯と歯茎を健康に保つために、歯みがきはできれば毎日行いましょう。<br><br><br></p>


<p style="color:#663300;font-size:1.5rem;">Q4.去勢手術と避妊手術って何？<br></p>
<p style="font-size:1.3rem;">A.去勢手術とはオス猫を対象とした精巣を摘出するための手術です。性ホルモンの影響で、オス猫は精巣腫瘍を発症する確率が上がります。
   精巣腫瘍は高齢になるほど命の危険が高まりますので、なるべく成熟する前に去勢手術をすることが大切です。<br>
   避妊手術とはメス猫を対象とした子宮か卵巣を摘出するための手術です。生殖器系疾患（乳がん、卵巣腫瘍など）の予防、望まない妊娠の防ぐ為に行います。<br><br><br></p>

<p style="color:#663300;font-size:1.5rem;">Q5.去勢や避妊手術の助成金がもらえる地域がある<br></p>
<p style="font-size:1.3rem;">A.お住いの市町村によっては「去勢」や「避妊」の手術の際に補助金がもらえることがあります。<br>
   「ぜんこく 犬猫助成金リスト」では補助金がもらえる市町村がまとめられています。確認しておきましょう。<br><br></p>
</div>
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