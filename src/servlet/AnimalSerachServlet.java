package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndividualsDAO;
import dao.UsersDAO;
import model.Individuals;
import model.Users;

/**
 * Servlet implementation class AnimalSearchServlet
 */
@WebServlet("/AnimalSerachServlet")
public class AnimalSerachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersDAO uDao = new UsersDAO();
		List<Users> organizationsList = uDao.select();
		request.setAttribute("organizationsList", organizationsList);

		// 検索ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animal_search.jsp");
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
		String organization_name = request.getParameter("organization_name");
		String name = request.getParameter("name");
		String tempAnimalId = request.getParameter("kind");
		int kind = Integer.parseInt(tempAnimalId);
		String type = request.getParameter("type");
		String gender = request.getParameter("gender");
		String tmpage = request.getParameter("age");
		int age = Integer.parseInt(tmpage);

		// 検索処理を行う
		IndividualsDAO iDao = new IndividualsDAO();
		List<Individuals> individualList = iDao.select(new Individuals(0, kind, name, type, age, gender, organization_name, null, null, false, null, null));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("individualList", individualList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animal_search_result.jsp");
		dispatcher.forward(request, response);
	}

}
