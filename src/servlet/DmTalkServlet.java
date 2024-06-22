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
import dao.UsersDAO;
import model.DMs;
import model.Users;


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
					response.sendRedirect("/C3/LoginServlet");
					return;
				}
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String yourId = request.getParameter("yourId");
				request.setAttribute("yourId", yourId);
				//System.out.println(yourId);
				DmsDAO dmsDao = new DmsDAO();
				UsersDAO uDao = new UsersDAO();

				//セッションスコープからidを取得
				String myId = String.valueOf(session.getAttribute("number"));
				//System.out.println(myId);
				List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
				//System.out.println(talkList);
				session.setAttribute("talkList", talkList);

				List<Users> orgList = uDao.getName(yourId);
				request.setAttribute("orgList", orgList);
				/*for(Users loginlist: orgList) {
					System.out.println(loginlist.getUser_name());
				}*/

				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_talk.jsp");
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


				DmsDAO dmsDao = new DmsDAO();

				//セッションスコープからidを取得
				String myId = String.valueOf(session.getAttribute("number"));

				/*
				List<DMs> talkUserList = dmsDao.select(myId);
				request.setAttribute("talkUserList", talkUserList);
				*/
				/*
				List<Users> organizationsList = dmsDao.selectOrganization();
				request.setAttribute("organizationsList", organizationsList);
				*/
				//

				if(request.getParameter("DM1")== null) {
					if (request.getParameter("select").equals(request.getParameter("yourId"))) {
						String yourId = request.getParameter("yourId");
						request.setAttribute("yourId",yourId);
				}
				}else {
					if(request.getParameter("DM1").equals("DM")) {
						String yourId = request.getParameter("yourId");
						request.setAttribute("yourId",yourId);
					}else if (request.getParameter("DM1").equals("送信")) {
						String yourId = request.getParameter("yourId2");
						String dmDetail = request.getParameter("dmDetail");
						dmsDao.insert(myId, yourId, dmDetail,true);
					}
				}//






				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_talk.jsp");
				dispatcher.forward(request, response);
			}
	}

