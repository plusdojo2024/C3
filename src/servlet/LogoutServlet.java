package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープを破棄する
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("userName"));
		if(session.getAttribute("userName")==null) {
			session.invalidate();
			// ログインページにリダイレクトする
			response.sendRedirect("/C3/ManagerLoginServlet");
		}else {
		session.invalidate();
		// ログインページにリダイレクトする
		response.sendRedirect("/C3/LoginServlet");
		}
	}

}
/*
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 * Servlet implementation class LogoutServlet

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープを破棄する
		HttpSession session = request.getSession();
		session.invalidate();

		// ログインページにリダイレクトする
		response.sendRedirect("/C3/HomeServlet");
	}

}*/
