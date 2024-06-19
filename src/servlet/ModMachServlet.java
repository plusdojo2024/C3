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

import dao.MachAnswersDAO;
import dao.MachQuestionsDAO;
import dao.QasDAO;
import model.MachQuestions;
import model.QAs;
import model.Result;

/**
 * Servlet implementation class ModMachServlet
 */
@WebServlet("/ModMachServlet")
public class ModMachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModMachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/ManegerServlet");
			return;
		}
		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod_mach.jsp");
		dispatcher.forward(request, response);
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/C3/ManegerServlet");
					return;
				
					// リクエストパラメータを取得する
					request.setCharacterEncoding("UTF-8");
					String  tempqasId = request.getParameter("id");
					int qasId = Integer.parseInt(tempqasId);
					String question = request.getParameter("question");
					String answer = request.getParameter("answer");

					MachQuestionsDAO mqDao = new MachQuestionsDAO();


					if(request.getParameter("submit").equals("登録")) {
						if (mqDao.insert(new MachQuestions(0, question, answer))) {	// 登録成功
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
						if (mqDao.update(new QAs(qasId, question, answer))) {	// 登録成功
							request.setAttribute("result",
							new Result("更新成功！", "レコードを更新しました。", "/C3/ModQAServlet"));
						}
						else {												// 登録失敗
							request.setAttribute("result",
							new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/ModQAServlet"));
						}
					}
					else {

						if(mqDao.delete(qasId)) {
							request.setAttribute("result",
									new Result("削除成功！", "レコードを削除しました。", "/C3/ModQAServlet"));
						}
						else {												// 登録失敗
							request.setAttribute("result",
							new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/ModQAServlet"));
						}
					}

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);

		}

	}
