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
import model.MachQuestions;
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
				String q1 = request.getParameter("question1");
				String q2 = request.getParameter("question2");
				String q3 = request.getParameter("question3");
				String q4 = request.getParameter("question4");
				String q5 = request.getParameter("question5");
				
				// インスタンスを生成
				MachQuestionsDAO mqDao = new MachQuestionsDAO();				
				List<String> machqlist = mqDao.select(new MachQuestions(q1, q2, q3, q4, q5));
				request.setAttribute("machqList", machqlist);


				// 登録する
				if (mqDao.insert(new MachQuestions(q1, q2, q3, q4, q5))) {
					request.setAttribute("result",
					new Result("登録成功", "レコードを1件登録しました。", "/C3/ModMachServlet"));
				}
				else {
					request.setAttribute("result",
					new Result("登録失敗", "レコードを登録できませんでした。", "/C3/ModMuchServlet"));
				}
				
				
				// 更新・削除する
				if (request.getParameter("submit").equals("更新")) { //submitでOK？
					if (mqDao.update(new MachQuestions(q1, q2, q3, q4, q5))) {
						request.setAttribute("result",
						new Result("更新成功", "レコードを1件更新しました。", "/C3/ModMachServlet"));
					}
					else {
						request.setAttribute("result",
						new Result("更新失敗", "レコードを更新できませんでした。", "/C3/ModMachServlet"));
					}
				}
				else {
					if (mqDao.delete()) {
						request.setAttributte("result",
						new Result("削除成功", "レコードを1件削除しました。", "/C3/ModMachServlet"));
					}
					else {
						request.setAttribute("result",
						new Result("削除失敗", "レコードを削除できませんでした。", "/C3/ModMachServlet"));
					}
				
				
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod_mach.jsp");
				dispatcher.forward(request, response);
	
}
