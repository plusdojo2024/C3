package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Result;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/AddGroupServlet")
public class AddGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/ManagerLoginServlet");
			return;
		}
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_group.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/ManagerLoginServlet");
			return;
		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		// 改造（ここから）
		String user_id=request.getParameter("user_id");
		String user_password=request.getParameter("user_password");
		String user_name=request.getParameter("user_name");
		String address=request.getParameter("address");
		String phone_number=request.getParameter("phone_number");
		String emails=request.getParameter("emails");
		String remarks=request.getParameter("remarks");

		// 改造（ここまで）

		// 登録処理を行う
		UsersDAO bDao = new UsersDAO();
		// 改造（ここから）
		if (bDao.insert1(user_id,user_password,user_name,address,phone_number,emails,remarks)) {	// 登録成功
			// 改造（ここまで）
			request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/C3/AddGroupServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/AddAnimaiServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manager_result.jsp");
		dispatcher.forward(request, response);


	}
}
