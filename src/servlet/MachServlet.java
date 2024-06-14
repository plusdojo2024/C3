package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MachQuestionsDAO;
import model.MachQuestions;

/**
 * Servlet implementation class MachServlet
 */
@WebServlet("/MachServlet")
public class MachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 相性診断ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String q1 = request.getParameter("q1");
				String q2 = request.getParameter("q2");
				String q3 = request.getParameter("q3");
				String q4 = request.getParameter("q4");
				String q5 = request.getParameter("q5");

				// 検索処理を行う
				MachQuestionsDAO mqDao = new MachQuestionsDAO();
				List<MachQuestions> cardList = mqDao.select(new MachQuestions());

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach_result.jsp");
				dispatcher.forward(request, response);


	}

}
