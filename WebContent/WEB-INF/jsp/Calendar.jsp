<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<link rel="stylesheet" href="/C3/css/style.css">
</head>
<body id ="top">
	<!-- ヘッダー -->
  <header>
    <div class="home">
      <a href="HomeServlet"><img src="./img/images/logo.png" alt="アニコン" width="250" height="247"></a>
    </div>
    <table>
      <tr>
        <td>
    <div class="login">
      <a href="LoginServlet"><img src="./img/images/login.png" alt="ログイン" width="130" height="50"></a>
  </div>
        </td>
        <td>
  <div class="Add">
      <a href="UserServlet"><img src="./img/images/Add.png" alt="新規登録" width="130" height="40"></a>
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
  <h1>カレンダー</h1>
  </main>
  <body>
  <button id ='prevMonth'>前の月</button>
  <button id ='nextMonth'>次の月</button>
  
    <script>
    const calendarEl = document.getElementBtId('calendar');
    const date = new Date();
    const currentYear = date.getFullYear();
    const curretMonth = date.getMonth();
    const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDtae();
    const prevMonthBth = document.getElementById('prevMonth');
    const nextMonthBtn = document.getElementById('nextMonth');
    let currentDisplayedMonth = currentMonth;
    
    const events = [
    	{
    		date: new Date(currentYear, currentMonth, 5),
    		title: 'イベント1',
    	},
    	{
    		date: new Date(currentYear, currentMonth, 15),
    		title: 'イベント2',
    	},   	
    ];
    
    
    // カレンダーのHTML構造を生成
    let calendarHtml = '<table><thead><tr>';
    for (let i = 0; i < 7; i++) {
    	calendarHtml +='<th>${['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'][i]}</th>';
    }
    calendarHtml += '</tr></thead><tbody><tr>';
    
    for (let i  = 1; i <= daysInMonth; i++) {
    	const dayOfWeek = new Date(currentYear, currentMonth, i).getDay();
    	  if (i === 1) {
    		    calendarHtml += '<tr>';
    		    for (let j = 0; j < dayOfWeek; j++) {
    		      calendarHtml += '<td></td>';
    		    }
    		  }
    		  calendarHtml += `<td>${i}</td>`;
    		  if (dayOfWeek === 6) {
    		    calendarHtml += '</tr>';
    		    if (i < daysInMonth) {
    		      calendarHtml += '<tr>';
    		    }
    		  } else if (i === daysInMonth) {
    		    for (let j = dayOfWeek + 1; j <= 6; j++) {
    		      calendarHtml += '<td></td>';
    		    }
    		    calendarHtml += '</tr>';
    		  }
    		}
    		calendarHtml += '</tbody></table>';
    		calendarEl.innerHTML = calendarHtml;
    		
    		function generateCalendar(year, month) {
    			  // カレンダー生成処理
    			}

    			prevMonthBtn.addEventListener('click', () => {
    			  currentDisplayedMonth--;
    			  if (currentDisplayedMonth < 0) {
    			    currentDisplayedMonth = 11;
    			    currentYear--;
    			  }
    			  generateCalendar(currentYear, currentDisplayedMonth);
    			});

    			nextMonthBtn.addEventListener('click', () => {
    			  currentDisplayedMonth++;
    			  if (currentDisplayedMonth > 11) {
    			    currentDisplayedMonth = 0;
    			    currentYear++;
    			  }
    			  generateCalendar(currentYear, currentDisplayedMonth);
    			});
    			
    			// イベント情報をカレンダーに追加
    			events.forEach(event => {
    				if (event.date.getFullYear() === year && event.date.getMonth() === month)  {
    					const dayCell = calendarEl.querySelector(''td[date-date="${event.date.getDate()}"]');
    					dayCell.innerHTML += '<div>${event.title}</div>';
    				}
    			});
    		}
    </script>
  </body>
  <!-- メインここまで -->
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