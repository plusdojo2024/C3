package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AniconsDAO;
import model.Result;


	/**
	 * Servlet implementation class ManagerLoginServlet
	 */
	@WebServlet("/ManagerLoginServlet")
	public class ManagerLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/anicon_login.jsp");
			dispatcher.forward(request, response);
		}
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("anicon_id");
			String pw = request.getParameter("anicon_password");

			AniconsDAO aDao = new AniconsDAO();
			if (aDao.isLoginOK(id, pw)) {	// ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("/C3/ManagerServlet");
			}
			else {									// ログイン失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result",
				new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/C3/ManagerLoginServlet"));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manager_result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

