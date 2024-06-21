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


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String orgId = request.getParameter("orgId");
		String name = request.getParameter("name");
		String kind=null;
		String gender= null;
		try {
		String tempAnimalId = request.getParameter("animal");
		if(request.getParameter("animal") == null) {
			kind=null;
		}else {
			if(tempAnimalId.equals("dog")) {
				kind="犬";
			}else if(tempAnimalId.equals("cat")) {
				kind="猫";
			}
		}
		}
		catch (NumberFormatException e) {
			//e.printStackTrace();

		}
		String type = request.getParameter("kind");
		if(request.getParameter("gender") == null) {
			gender=null;
		}else {
			if(request.getParameter("gender").equals("male")) {
				gender="オス";
			}else if(request.getParameter("gender").equals("female")) {
				gender="メス";
				}
		}
		System.out.println(gender);


		//String tmpage = request.getParameter("age");
		//int age = Integer.parseInt(tmpage);

		// 検索処理を行う
		IndividualsDAO iDao = new IndividualsDAO();
		List<Individuals> individualList = iDao.select(new Individuals(0, 0, name, type, 0, gender, orgId, null, null, false, null, null,kind));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("individualList", individualList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animal_search_result.jsp");
		dispatcher.forward(request, response);
	}

}
