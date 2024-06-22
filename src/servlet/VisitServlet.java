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

import dao.DmsDAO;
import dao.ReservationsDAO;
import model.Reservations;
import model.Result;
import model.Users;

/**
 * Servlet implementation class VisitServlet
 */
@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public VisitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		DmsDAO dmsDao = new DmsDAO();
		List<Users> organizationsList = dmsDao.selectOrganization();
		request.setAttribute("organizationsList", organizationsList);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/visit.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String tempindividualId = request.getParameter("animal_name");
		//System.out.println(animalName);
		int individualId = Integer.parseInt(tempindividualId);
		String tempRsv_day = request.getParameter("rsv_day");
		System.out.println(tempRsv_day);
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(tempRsv_day);
		Timestamp rsv_day = new Timestamp(date.getTime());
		System.out.println(rsv_day);

		String myId = (String)session.getAttribute("id");
		String yourId = request.getParameter("orgId");
		String remarks = request.getParameter("remarks");


		ReservationsDAO rsvDao = new ReservationsDAO();
		//予約送信
		if (rsvDao.insert(new Reservations(0,individualId,null, rsv_day, myId,null, yourId, remarks, false))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/C3/VisitServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/VisitServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		} catch (ParseException e) {
		    e.printStackTrace();
			}
		}

}
