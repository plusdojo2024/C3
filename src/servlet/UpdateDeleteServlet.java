package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Result;
import model.Users;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UpdateDeleteServlet")
public class UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()

    public UpdateDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    } */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO uDao = new UsersDAO();
		List<Users> organizationsList = uDao.select();

		// 表示結果をリクエストスコープに格納する
		request.setAttribute("organizationsList", organizationsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_delete_group.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/C3/LoginServlet");
					return;
				}*/

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				int organizationId = Integer.parseInt(request.getParameter("id"));
				String user_id = request.getParameter("user_id");
				String user_password = request.getParameter("user_password");
				String user_name = request.getParameter("user_name");
				String address = request.getParameter("address");
				String phone_number = request.getParameter("phone_number");
				String emails = request.getParameter("emails");
				String remarks = request.getParameter("remarks");


				// 更新または削除を行う
				UsersDAO uDao = new UsersDAO();
				if (request.getParameter("submit").equals("更新")) {
					// ここを改造する
					if (uDao.update(new Users(organizationId,user_id, user_name, user_password,true, address,phone_number, emails, remarks))) {	// 更新成功
					// ここまで
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/C3/UpdateDeleteServlet"));
					}
					else {												// 更新失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/UpdateDeleteServlet"));
					}
				}
				else {
					if (uDao.delete(organizationId)) {	// 削除成功
						request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/C3/UpdateDeleteServlet"));
					}
					else {						// 削除失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/UpdateDeleteServlet"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
	}

}
