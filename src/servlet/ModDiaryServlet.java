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

import dao.DiarysDAO;
import model.Diarys;
import model.Result;

/**
 * Servlet implementation class ModDiaryServlet
 */
@WebServlet("/ModDiaryServlet")
public class ModDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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

				//String myId = (String)session.getAttribute("id");
				String myNumber = String.valueOf(session.getAttribute("number"));
				DiarysDAO dDao = new DiarysDAO();
				List<Diarys> diaryList = dDao.select();
				request.setAttribute("diaryList", diaryList);

				List<Diarys> myDiaryList = dDao.selectPd(myNumber);
				request.setAttribute("diarysList", myDiaryList);

				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod_diary.jsp");
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

				String myId = (String)session.getAttribute("id");
				String myNumber = String.valueOf(session.getAttribute("number"));
				System.out.println(myNumber);
				String myName = (String)session.getAttribute("userName");
				String diaryTitle = request.getParameter("diary_title");
				String diaryDetail = request.getParameter("diary");

				DiarysDAO dDao = new DiarysDAO();




				if(request.getParameter("submit").equals("登録")) {
					if (dDao.insert(new Diarys(0, null, myNumber, diaryTitle, diaryDetail, myName))) {	// 登録成功
						request.setAttribute("result",
						new Result("登録成功！", "レコードを登録しました。", "/C3/ModDiaryServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/ModDiaryServlet"));
					}
				}
				else if (request.getParameter("submit").equals("更新")) {
					String tempdiaryId = request.getParameter("id");
					int diaryId = Integer.parseInt(tempdiaryId);
					if (dDao.update(new Diarys(diaryId, null, myId, diaryTitle, diaryDetail,myName))) {	// 登録成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/C3/ModDiaryServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/C3/ModDiaryServlet"));
					}
				}
				else {
					String tempdiaryId = request.getParameter("id");
					int diaryId = Integer.parseInt(tempdiaryId);
					if (dDao.delete(diaryId)) {	// 登録成功

						request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/C3/ModDiaryServlet"));
					}
					else {												// 登録失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/C3/ModDiaryServlet"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
	}

}
