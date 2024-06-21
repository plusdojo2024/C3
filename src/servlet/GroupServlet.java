package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);*/
		request.setCharacterEncoding("UTF-8");
		UsersDAO uDao = new UsersDAO();
		List<Users> organizationsList = uDao.select();
		// 表示結果をリクエストスコープに格納する
		request.setAttribute("organizationsList", organizationsList);



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String remarks = request.getParameter("remarks");
		UsersDAO uDao = new UsersDAO();
		List<Users> organizationsList = uDao.is_organization( user_id, address, phonenumber,  email, remarks);

		// 表示結果をリクエストスコープに格納する
		request.setAttribute("organizationsList", organizationsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);

	}

}
