package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MachAnswersDAO;
import model.MachAnswers;

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

		/*MachQuestionsDAO mqDao = new MachQuestionsDAO();
		List<MachQuestions> machqlist = mqDao.select();
		request.setAttribute("machqList", machqlist);*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String tmpa1 = request.getParameter("answer1");
		String tmpa2 = request.getParameter("answer2");
		String tmpa3 = request.getParameter("answer3");
		String tmpa4 = request.getParameter("answer4");
		String tmpa5 = request.getParameter("answer5");
		boolean a1,a2,a3,a4,a5;
		System.out.println(tmpa1);
		System.out.println(tmpa2);
		System.out.println(tmpa3);
		System.out.println(tmpa4);
		System.out.println(tmpa5);


		// 検索処理を行う
		if(tmpa1.equals("yes")) {
			a1 = true;
		} else {
			a1 =false;
		}
		if(tmpa2 .equals("yes")) {
			a2 = true;
		} else {
			a2 =false;
		}
		if(tmpa3.equals("yes")) {
			a3 = true;
		} else {
			a3 =false;
		}
		if(tmpa4 .equals("yes")) {
			a4 = true;
		} else {
			a4 =false;
		}
		if(tmpa5.equals("yes")) {
			a5 = true;
		} else {
			a5 =false;
		}
		/*System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);*/

		// インスタンスを作成
		MachAnswersDAO maDao = new MachAnswersDAO();
		if(request.getParameter("mach").equals("診断")) {
			List<MachAnswers> machlist = maDao.select(a1, a2, a3, a4, a5);
			request.setAttribute("machList", machlist);
		}




		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach_result.jsp");
		dispatcher.forward(request, response);
	}
}
