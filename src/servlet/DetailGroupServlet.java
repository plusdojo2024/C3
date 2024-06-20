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
import dao.NewsDAO;
import model.Individuals;
import model.News;

/**
 * Servlet implementation class DetailGroupServlet
 */
@WebServlet("/DetailGroupServlet")
public class DetailGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String tempId = request.getParameter("id");
				int organizationId = Integer.parseInt(tempId);

				NewsDAO nDao = new NewsDAO();
				List<News> newsList = nDao.select(organizationId);
				request.setAttribute("newsList", newsList);

				IndividualsDAO iDao = new IndividualsDAO();
				List<Individuals> individualList = iDao.select1(organizationId);
				request.setAttribute("individualList", individualList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_animal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
