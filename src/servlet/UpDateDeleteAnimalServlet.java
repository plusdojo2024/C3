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

import dao.IndividualsDAO;
import model.Individuals;
import model.Result;

/**
 * Servlet implementation class UpDateDeleteAnimalServlet
 */
@WebServlet("/UpDateDeleteAnimalServlet")
public class UpDateDeleteAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/LoginServlet");
			return;
		}
		IndividualsDAO iDao = new IndividualsDAO();
		String myId = String.valueOf(session.getAttribute("number"));
		List<Individuals> individualList = iDao.select1(myId);
		request.setAttribute("individualList", individualList);
		System.out.println(myId);
		System.out.println(individualList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animal.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C3/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String animal_name = request.getParameter("animal_name");
		String type = request.getParameter("type");
		//String gender = request.getParameter("gender");
		   int age = Integer.parseInt(request.getParameter("age"));
		String tmpbirthday = request.getParameter("birthday");
		  	java.sql.Date birthday = java.sql.Date.valueOf(tmpbirthday);
		  	boolean is_castration = Boolean.parseBoolean(request.getParameter("is_castration"));
		String remarks = request.getParameter("remarks");



		// 更新または削除を行う
		IndividualsDAO iDao = new IndividualsDAO();
		if (request.getParameter("submit").equals("更新")) {
			// ここを改造する
			if (iDao.update(new Individuals(id,0,animal_name, type, age,null, null, null, remarks,  is_castration, birthday, null, null,null))) {	// 更新成功
			// ここまで
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "/C3/UpDateDeleteAnimalServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/UpDateDeleteAnimalServlet"));
			}
		}
		else {
			if (iDao.delete(id)) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/C3/UpDateDeleteAnimalServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/UpDateDeleteAnimalServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
}