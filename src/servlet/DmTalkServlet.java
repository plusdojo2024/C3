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

import dao.DmsDAO;
import model.DMs;


/**
 * Servlet implementation class DmTalkServlet
 */
@WebServlet("/DmTalkServlet")
public class DmTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public DmTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}
				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String yourId = request.getParameter("yourId");
				String dmDetail = request.getParameter("dmDetail");
				DmsDAO dmsDao = new DmsDAO();

				//セッションスコープからidを取得
				String myId = session.getId();

				/*
				List<DMs> talkUserList = dmsDao.select(myId);
				request.setAttribute("talkUserList", talkUserList);
				*/
				/*
				List<Users> organizationsList = dmsDao.selectOrganization();
				request.setAttribute("organizationsList", organizationsList);
				*/
				//
				List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
				request.setAttribute("talkList", talkList);

				//
				dmsDao.insert(myId, yourId, dmDetail,true);






				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_talk.jsp");
				dispatcher.forward(request, response);
			}
	}

