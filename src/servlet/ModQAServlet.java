package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QasDAO;
import model.QAs;
import model.Result;

/**
 * Servlet implementation class ModQAServlet
 */
@WebServlet("/ModQAServlet")
public class ModQAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModQAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				HttpSession session = request.getSession();

				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/.jsp");
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
				String  tempqasId = request.getParameter("id");
				int qasId = Integer.parseInt(tempqasId);
				String question = request.getParameter("question");
				String answer = request.getParameter("answer");

				QasDAO qasDao = new QasDAO();


				if(request.getParameter("submit").equals("登録")) {
					if (qasDao.insert(new QAs(0, question, answer))) {	// 登録成功
						request.setAttribute("result",
						new Result("登録成功！", "レコードを登録しました。", "/C3/ModQAServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/ModQAServlet"));
					}
				}
				else if (request.getParameter("submit").equals("更新")) {
					// ここを改造する
					if (qasDao.update(new QAs(qasId, question, answer))) {	// 登録成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/C3/ModQAServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/ModQAServlet"));
					}
				}
				else {

					if(qasDao.delete(qasId)) {
						request.setAttribute("result",
								new Result("削除成功！", "レコードを削除しました。", "/C3/ModQAServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/ModQAServlet"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manager_result.jsp");
				dispatcher.forward(request, response);

	}

}
