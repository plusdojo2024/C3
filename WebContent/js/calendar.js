/**
 * 
 */

    const date = new Date();
    let currentYear = date.getFullYear();
    let currentMonth = date.getMonth();
    
	window.onload = function (){
		//カレンダーを表示
		generateCalendar(currentYear, currentMonth);
	}


    const calendarEl = document.getElementById('calendar');

    const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();


    // カレンダー生成処理
    function generateCalendar(year, month) {
    	let calendarHtml = '<table><thead><tr>';
    	for (let i = 0; i < 7; i++) {
    	  calendarHtml += `<th>${['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'][i]}</th>`;
    	}
    	calendarHtml += '</tr></thead><tbody><tr>';

    	for (let i = 1; i <= daysInMonth; i++) {
    	  const dayOfWeek = new Date(currentYear, currentMonth, i).getDay();
    	  if (i === 1) {
    	    calendarHtml += '<tr>';
    	    for (let j = 0; j < dayOfWeek; j++) {
    	      calendarHtml += '<td></td>';
    	    }
    	  }
    	  calendarHtml += `<td data-date=${i}>${i}</td>`;
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
    	
    	 // イベント情報をカレンダーに追加
 		 events.forEach(event => {
  			if (event.date.getFullYear() === year && event.date.getMonth() === month) {
				const dayCell = calendarEl.querySelector(`td[data-date="${event.date.getDate()}"]`);
				dayCell.innerHTML += `<div>${event.event_name}</div>`;
				dayCell.innerHTML += `<div>${event.event_day}</div>`;
				dayCell.innerHTML += `<div>${event.event_place}</div>`;
				dayCell.innerHTML += `<div>${event.event_remarks}</div>`;
				dayCell.innerHTML += `<div>${event.user_name}</div>`;
    		}
 		});
    }
    
    
    

    const prevMonthBtn = document.getElementById('prevMonth');
    const nextMonthBtn = document.getElementById('nextMonth');
    let currentDisplayedMonth = currentMonth;
 
    //ボタンをクリックしたら前の月に移動する処理
    prevMonthBtn.addEventListener('click', () => {
    
      currentDisplayedMonth--;
      currentMonth--;
    
      if (currentDisplayedMonth < 0) {
        currentDisplayedMonth = 11;
        currentMonth = 11;
        currentYear--;
      }
    
      generateCalendar(currentYear, currentDisplayedMonth);
    
    });




    // ボタンをクリックしたら次の月に移動する処理
    nextMonthBtn.addEventListener('click', () => {
    currentYear, currentDisplayedMonth
      currentDisplayedMonth++;
      currentMonth++;
      
      if (currentDisplayedMonth > 11) {
        currentDisplayedMonth = 0;
        currentMonth = 0;
        currentYear++;
      }
      
      generateCalendar(currentYear, currentDisplayedMonth);
    });
	
	
	
	
	
/*	const addEventsBtn = document.getElementById('addEventsBtn');*/
	
/*
	  // イベント情報をカレンダーに追加する処理
    	events.forEach(event => {
    
    		if (event.date.getFullYear() === year && event.date.getMonth() === month) {
      			const dayCell = calendarEl.querySelector(`td[data-date="${event.date.getDate()}"]`);
      			dayCell.innerHTML += `<div>${event.title}</div>`;
 	  		}
  		});   
*/	
/*		// イベントを表示させる処理
		addEventsBtn.addEventListener('click', () => {
    
   	   if (currentDisplayedMonth > 11) {
   	     currentDisplayedMonth = 0;
    	    currentMonth = 0;
   	     currentYear++;
   	   }
      
   	   generateCalendar();
   	 });
*/
	
	
	
	/*
	    // イベント表示処理
    function generateEvent() {
    	let calendarHtml = '<table><thead><tr>';
    	for (let i = 0; i < 7; i++) {
    	  calendarHtml += `<th>${['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'][i]}</th>`;
    	}
    	calendarHtml += '</tr></thead><tbody><tr>';

    	for (let i = 1; i <= daysInMonth; i++) {
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
    }
    */
    
    
    
  
    
