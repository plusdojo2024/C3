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

import dao.NewsDAO;
import model.News;
import model.Result;

/**
 * Servlet implementation class ModNewsServlet
 */
@WebServlet("/ModNewsServlet")
public class ModNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}*/
		NewsDAO nDao = new NewsDAO();
		List<News> newsList = nDao.select1();
		request.setAttribute("newsList", newsList);
				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod_news.jsp");
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
				String tempnewsId = request.getParameter("id");
				int newsId = Integer.parseInt(tempnewsId);
				String myId = (String)session.getAttribute("id");
				String newsTitle = request.getParameter("title");
				String newsDetail = request.getParameter("detail");

				NewsDAO nDao = new NewsDAO();

				List<News> nList = nDao.select1();
				request.setAttribute("nList", nList);


				if(request.getParameter("submit").equals("登録")) {
					if (nDao.insert1(new News(0, newsTitle, null, newsDetail, myId))) {	// 登録成功
						request.setAttribute("result",
						new Result("登録成功！", "レコードを登録しました。", "/C3/ModNewsServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/ModNewsServlet"));
					}
				}
				else if (request.getParameter("submit").equals("更新")) {
					// ここを改造する
					if (nDao.update1(new News(newsId, newsTitle, null, newsDetail, myId))) {	// 登録成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/C3/ModNewsServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/ModNewsServlet"));
					}
				}
				else {

					if (nDao.delete1(newsId)) {	// 登録成功
						request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/C3/ModNewsServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/ModNewsServlet"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
	}

}
