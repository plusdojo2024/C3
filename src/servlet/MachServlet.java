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
		// GETリクエストに対する処理
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

	
		// 検索処理を行う
		if(tmpa1 == "yes") {
			boolean a1 = true;			
		} else {
			boolean a1 =false;
		}
		if(tmpa2  == "yes") {
			boolean a2 = true;
		} else {
			boolean a2 =false;
		}
		if(tmpa3 == "yes") {
			boolean a3 = true;			
		} else {
			boolean a3 =false;
		}
		if(tmpa4 == "yes") {
			boolean a4 = true;			
		} else {
			boolean a4 =false;
		}
		if(tmpa5 == "yes") {
			boolean a5 = true;			
		} else {
			boolean a5 =false;
		}
		
		// インスタンスを作成
		MachAnswersDAO maDao = new MachAnswersDAO();
		
		List<String> machlist = maDao.select(a1, a2, a3, a4, a5);
		request.setAttribute("machList", machlist);
		
		
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach_result.jsp");
		dispatcher.forward(request, response);

}
