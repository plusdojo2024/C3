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

import dao.ReservationsDAO;
import model.Reservations;
import model.Result;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/C3/LoginServlet");
					return;
				}


		String tempId = (String)session.getAttribute("id");
		int organizationId = Integer.parseInt(tempId);
		request.setCharacterEncoding("UTF-8");
		//String accept = request.getParameter("accept");
		String temprsvId = request.getParameter("rsvid");
		int rsvId = Integer.parseInt(temprsvId);

		ReservationsDAO rsvDao = new ReservationsDAO();
		List<Reservations> rsvList = rsvDao.select(organizationId);
		request.setAttribute("rsvList", rsvList);

		if(request.getParameter("submit").equals("承認")) {
			if (rsvDao.update( rsvId)) {
				request.setAttribute("result",
				new Result("登録成功", "レコードを1件登録しました。", "/C3/ReserveServlet"));
			}
			else {
				request.setAttribute("result",
				new Result("登録失敗", "レコードを登録できませんでした。", "/C3/ReserveServlet"));
			}
		}

	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
	dispatcher.forward(request, response);

	}
}
