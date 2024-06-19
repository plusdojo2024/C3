package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_group.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		// 改造（ここから）
		String id=request.getParameter("user_id");
		String pw=request.getParameter("password");
		String name=request.getParameter("name");
		String ad=request.getParameter("address");
		String phone=request.getParameter("phonenumber");
		String email=request.getParameter("email");
		String remarks=request.getParameter("organization_remarks");

		// 改造（ここまで）

		// 登録処理を行う
		UsersDAO bDao = new UsersDAO();
		// 改造（ここから）
		if (bDao.insert1(id,pw,name,ad,phone,email,remarks)) {	// 登録成功
			// 改造（ここまで）
			request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/C3/AddGroupServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/AddAnimaiServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);


	}
}
