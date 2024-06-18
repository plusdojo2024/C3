package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C3/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int number = Integer.parseInt(request.getParameter("number"));

		String animal_name = request.getParameter("animal_name");
		String tempAnimalId = request.getParameter("kind");
		int animal_id = Integer.parseInt(tempAnimalId);
		String type = request.getParameter("type");
		String gender = request.getParameter("gender");
		   int age = Integer.parseInt(request.getParameter("age"));
		String tmpbirthday = request.getParameter("birthday");
		  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  	String formattedDate = sdf.format(tmpbirthday);
		  	java.sql.Date birthday = java.sql.Date.valueOf(formattedDate);
		String tmpperiod = request.getParameter("period");
		  String formattedDate1 = sdf.format(tmpperiod);
	  	java.sql.Date period = java.sql.Date.valueOf(formattedDate1);
		boolean is_castration = Boolean.parseBoolean(request.getParameter("is_castration"));
		String remarks = request.getParameter("remarks");
		String img = request.getParameter("img");
		String user_name = request.getParameter("user_name");


		// 更新または削除を行う
		IndividualsDAO bDao = new IndividualsDAO();
		if (request.getParameter("submit").equals("更新")) {
			// ここを改造する
			if (bDao.update(new Individuals(0,animal_id,animal_name, type, age,gender, user_name, period, remarks,  is_castration, birthday, img))) {	// 更新成功
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
			if (bDao.delete(number)) {	// 削除成功
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