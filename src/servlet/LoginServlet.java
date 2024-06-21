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

import dao.UsersDAO;
import model.Result;
import model.Users;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_password");
        /*id = "orgA";
        pw = "orgA";*/
		//isLoginOKは使わない
		//loginIDがあれば個人か団体か判断、なければnullをかえす
		// ログイン処理を行う
		UsersDAO iDao = new UsersDAO();
		if (iDao.isLoginOK(id, pw)) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			List<Users> loginList = iDao.is_organization(id, pw);
			for(Users loginlist: loginList) {
				session.setAttribute("userName",loginlist.getUser_name());
			if(loginlist.getIs_organization()== true){
//団体用のホームページ
				System.out.println(loginList);
				System.out.println(loginlist.getIs_organization());
				response.sendRedirect("/C3/GroupHomeServlet");
			}
			else if(loginlist.getIs_organization()== false) {
//個人用
				response.sendRedirect("/C3/PersonalServlet");
			}
			}

		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/C3/LoginServlet"));
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}