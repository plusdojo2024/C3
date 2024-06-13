package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiarysDAO {
	// 日記一覧
		public List<Diarys> select(Diarys card) {
			Connection conn = null;
			List<Diarys> cardList = new ArrayList<Diarys>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
					String sql = "SELECT user_name, diary_day, diary_title, diary FROM Diarys  ORDER BY id";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Diarys record = new Diarys(
							rs.getString("user_name"),
							rs.getTimestamp("diary_day"),
							rs.getString("diary_title"),
							rs.getString("diary")
							);
						cardList.add(record);
					}

			    }catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}
	//日記登録
		public boolean insert(Diarys card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO Diarys VALUES (Null, CURRENT_TIMESTAMP, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				//sessionスコープで団体id持ってきて名前入れる
					if (card.get() != null) {
						pStmt.setString(1, card.get());
					}
					else {
						pStmt.setString(1, "");
					}
					if (card.getDiary() != null) {
						pStmt.setString(2, card.getDiary());
					}
					else {
						pStmt.setString(2, "");
					}
					if (card.getDiary_title() != null) {
						pStmt.setString(3, card.getDiary_title());
					}
					else {
						pStmt.setString(3, "");
					}



					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
}
