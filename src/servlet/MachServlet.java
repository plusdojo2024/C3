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
		// POSTリクエストに対する処理
		doGet(request, response);

		/*// リクエストパラメータを取得する
		Boolean A1 = false;
		Boolean A2 = false;
		Boolean A3 = false;
		Boolean A4 = false;
		Boolean A5 = false;
		}
	
		// 検索処理を行う

		
		// 検索結果をリクエストスコープに格納する

		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mach_result.jsp");
		dispatcher.forward(request, response);

}
*/