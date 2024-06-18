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

import dao.DmsDAO;
import model.DMs;
import model.Users;

/**
 * Servlet implementation class DmPersonalServlet
 */
@WebServlet("/DmPersonalServlet")
public class DmPersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public DmPersonalServlet() {
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
			response.sendRedirect("/C3/LoginServlet");
			return;
		}
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_personal.jsp");
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

		request.setCharacterEncoding("UTF-8");
		DmsDAO dmsDao = new DmsDAO();

		//セッションスコープからidを取得
		String myId = session.getId();

		//
		List<DMs> talkUserList = dmsDao.select(myId);
		request.setAttribute("talkUserList", talkUserList);

		//
		List<Users> organizationsList = dmsDao.selectOrganization();
		// 表示結果をリクエストスコープに格納する
		request.setAttribute("organizationsList", organizationsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_personal.jsp");
		dispatcher.forward(request, response);

	}

}
