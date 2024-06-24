package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventsDAO;
import model.Events;
import model.Result;

/**
 * Servlet implementation class ModCalendarServlet
 */
@WebServlet("/ModCalendarServlet")
public class ModCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModCalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EventsDAO evDao = new EventsDAO();
		List<Events> evList = evDao.selectPd();
		request.setAttribute("evList", evList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod_calendar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/C3/UserServlet");
					return;
				}

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String event_name = request.getParameter("event_name");
				String tempEvent_day = request.getParameter("event_day");
				//String tempYear = request.getParameter("year");
				//String tempMonth = request.getParameter("month");
				//String tempDay = request.getParameter("day");
				try {
				String event_place = request.getParameter("event_place");
				String event_remarks = request.getParameter("event_remarks");
				String user_name = request.getParameter("user_name");


				EventsDAO EvDao = new EventsDAO();

				// 登録
				if (request.getParameter("submit").equals("登録")) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date edate = sdf.parse(tempEvent_day);
					Timestamp event_day = new Timestamp(edate.getTime());

					if (EvDao.insert(new Events(0, event_name, event_day, event_place, event_remarks, user_name))) {	// 登録成功
					// 改造（ここまで）
						request.setAttribute("result",
								new Result("登録成功", "レコードを1件登録しました。", "/C3/ModCalendarServlet"));
					}
					else {
						request.setAttribute("result",
								new Result("登録失敗", "レコードを登録できませんでした。", "/C3/ModCalendarServlet"));
					}
				// 更新
				}else if (request.getParameter("submit").equals("更新")) {
					String tempId = request.getParameter("Id");
					int id = Integer.parseInt(tempId);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					//Date date = sdf.parse(tempEvent_day);
					//Timestamp eventDay = new Timestamp(date.getTime());
					Date edate = sdf.parse(tempEvent_day);
					Timestamp event_day = new Timestamp(edate.getTime());
					if (EvDao.update(new Events(id, event_name, event_day, event_place, event_remarks, user_name))) {	// 更新成功
					request.setAttribute("result",
					new Result("更新成功", "レコードを1件更新しました。", "/C3/ModCalendarServlet"));
					}
					else {												// 更新失敗
						request.setAttribute("result",
						new Result("更新失敗", "レコードを更新できませんでした。", "/C3/ModCalendarServlet"));
					}
				}
				//削除
				else if (request.getParameter("submit").equals("削除")){ 
					String tempId = request.getParameter("Id");
					int id = Integer.parseInt(tempId);
					if (EvDao.delete(id)) {
						request.setAttribute("result",
						new Result("削除成功", "レコードを1件削除しました。", "/C3/ModCalendarServlet"));
					}
					else {
						request.setAttribute("result",
						new Result("削除失敗", "レコードを削除できませんでした。", "/C3/ModCalendarServlet"));
					}
				}
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
				} catch (ParseException e) {
				    e.printStackTrace();
					}
			}

}
