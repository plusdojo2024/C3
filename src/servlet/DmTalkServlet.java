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
				//System.out.println(yourId);
				//request.setAttribute("yourId", yourId);
				DmsDAO dmsDao = new DmsDAO();
				UsersDAO uDao = new UsersDAO();

				//セッションスコープからidを取得
				String myId = String.valueOf(session.getAttribute("number"));



				if(request.getParameter("DM1")== null && request.getParameter("DM2")== null) {
					if (request.getParameter("select").equals(request.getParameter("yourName"))) {
						yourId = request.getParameter("yourId");
						request.setAttribute("yourId",yourId);
						List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
						//System.out.println(talkList);
						request.setAttribute("talkList", talkList);
						//System.out.println(yourId);
						List<Users> orgList = uDao.getName(yourId);
						request.setAttribute("orgList", orgList);
						/*for(Users loginlist: orgList) {
							System.out.println(loginlist.getUser_name());
						}*/
					}
				}else if(request.getParameter("DM2")== null && request.getParameter("DM1").equals("DM")){
					if(request.getParameter("DM1").equals("DM")) {
						 yourId = request.getParameter("yourId");
						request.setAttribute("yourId",yourId);
						List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
						//System.out.println(talkList);
						request.setAttribute("talkList", talkList);

						List<Users> orgList = uDao.getName(yourId);
						request.setAttribute("orgList", orgList);
						/*for(Users loginlist: orgList) {
							System.out.printrequest.getParameter("DM1").equals("DM")ln(loginlist.getUser_name());
							System.out.println(yourId);
						}*/
					}
				}else if(request.getParameter("DM1")==null && request.getParameter("DM2").equals("DM")) {
						String yourName = request.getParameter("user_name");
						//System.out.println(yourName);
						List<Users> orgList = uDao.getId(yourName);
						//request.setAttribute("orgList", orgList);
						for(Users loginlist: orgList) {
							//System.out.println("ID："+loginlist.getId());
							yourId = String.valueOf(loginlist.getId());
							request.setAttribute("yourId",yourId);
							List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
							//System.out.println("id:"+yourId);
							request.setAttribute("talkList", talkList);

							 orgList = uDao.getName(yourId);
							request.setAttribute("orgList", orgList);
						}

					}


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
				UsersDAO uDao = new UsersDAO();


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

						request.setAttribute("yourId",yourId);
						List<DMs> talkList = dmsDao.selectTalk(myId,yourId);
						//System.out.println(talkList);
						request.setAttribute("talkList", talkList);
						List<Users> orgList = uDao.getName(yourId);
						request.setAttribute("orgList", orgList);
						for(Users loginlist: orgList) {
						System.out.println(loginlist.getUser_name());
						System.out.println(yourId);
					}
					}
				}//






				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dm_talk.jsp");
				dispatcher.forward(request, response);
			}
	}

