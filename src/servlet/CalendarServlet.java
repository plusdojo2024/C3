package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventsDAO;
import dao.ReservationsDAO;
import model.Events;
import model.Reservations;
/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
	/*	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/CalenderServlet");
			return;
		}*/
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");

				EventsDAO evDao = new EventsDAO();
				ReservationsDAO rsvDao = new ReservationsDAO();
				List<Reservations> rsvList = rsvDao.select1();
				request.setAttribute("rsvList", rsvList);
				List<Events> evList = evDao.selectPd();
				request.setAttribute("evList", evList);
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
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




	}
}
