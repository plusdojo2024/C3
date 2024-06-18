package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IndividualsDAO;
import model.Individuals;
import model.Result;
/**
 * Servlet implementation class AddAnimaiServlet
 */
@WebServlet("/AddAnimaiServlet")
public class AddAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimalServlet() {
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

				// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_animal.jsp");
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
				String animal_name = request.getParameter("animal_name");
				String tempAnimalId = request.getParameter("kind");
				int animal_id = Integer.parseInt(tempAnimalId);
				String type = request.getParameter("type");
				String gender = request.getParameter("gender");
				   int age = Integer.parseInt(request.getParameter("age"));
				String tmpbirthday = request.getParameter("birthday");
				  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				  	String formattedDate = sdf.format(tmpbirthday);
				  	java.sql.Date birthday = java.sql.Date.valueOf(formattedDate);
/*					try {
						birthday = sdf.parse(tmpbirthday);
					} catch (ParseException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}*/
				String tmpperiod = request.getParameter("period");
				  String formattedDate1 = sdf.format(tmpperiod);
			  	java.sql.Date period = java.sql.Date.valueOf(formattedDate1);
/*				try {
					period = sdf1.parse(tmpperiod);
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}*/
				boolean is_castration = Boolean.parseBoolean(request.getParameter("is_castration"));
				String remarks = request.getParameter("remarks");
				String img = request.getParameter("img");
				String user_name = request.getParameter("user_name");



				// 登録処理を行う
				IndividualsDAO iDao = new IndividualsDAO();
				if (iDao.insert(new Individuals(0,animal_id,animal_name, type, age,gender, user_name, period, remarks,  is_castration, birthday, img))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
				}
				else {												// 登録失敗
					request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/C3/MenuServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);

	}

}
