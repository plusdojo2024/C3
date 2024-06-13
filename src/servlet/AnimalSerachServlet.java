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

/**
 * Servlet implementation class AnimalSerachServlet
 */
@WebServlet("/AnimalSerachServlet")
public class AnimalSerachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalSerachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				String kind = request.getParameter("kind");
				String type = request.getParameter("type");
				String gender = request.getParameter("gender");
				String age = request.getParameter("age");

				// 検索処理を行う
				IndividualsDAO iDao = new IndevidualsDAO();
				List<Bc> cardList = bDao.select(new Bc(organization_name, name, kind, type, gender, age));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animal_search_result.jsp");
				dispatcher.forward(request, response);
			}

	}

