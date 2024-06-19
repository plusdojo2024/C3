package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Diarys;

public class DiarysDAO {
	//日記一覧
		public List<Diarys> select() {
			Connection conn = null;
			List<Diarys> cardList = new ArrayList<Diarys>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する
					String sql = "SELECT * FROM Diarys  ORDER BY id";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Diarys record = new Diarys(
							rs.getInt("id"),
							rs.getTimestamp("diary_day"),
							rs.getString("user_name"),
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

		public List<Diarys> mySelect(int id) {
			Connection conn = null;
			List<Diarys> cardList = new ArrayList<Diarys>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する
					String sql = "SELECT * FROM Diarys  WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
						pStmt.setInt(1, id);
					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Diarys record = new Diarys(
							rs.getInt("id"),
							rs.getTimestamp("diary_day"),
							rs.getString("user_name"),
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
	//自分の投稿した日記一覧をプルダウン形式で表示
		public List<Diarys> selectPd(String id) {
			Connection conn = null;
			List<Diarys> cardList = new ArrayList<Diarys>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する
					String sql = "SELECT diary_title FROM Diarys WHERE user_id=? ORDER BY id";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					//session
					pStmt.setString(1, id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Diarys record = new Diarys(
							rs.getInt("id"),
							rs.getTimestamp("diary_day"),
							rs.getString("user_name"),
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
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO Diarys VALUES (Null, CURRENT_TIMESTAMP, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				//sessionスコープで団体id持ってきて名前入れる
					if (card.getUser_id() != null) {
						pStmt.setString(1, card.getUser_id());
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
	//日記更新
		public boolean update(Diarys card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する
				//お気に入り登録時

					String sql = "UPDATE Diarys SET diary=?, diary_title=? WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getDiary() != null) {
						pStmt.setString(1, card.getDiary());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getDiary_title() != null) {
						pStmt.setString(2, card.getDiary_title());
					}
					else {
						pStmt.setString(2, null);
					}
					pStmt.setString(3, null);
					//更新ボタンを押した日記のidを格納



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
	//日記削除
				//session
				public boolean delete(int id) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

						// SQL文を準備する
						String sql = "DELETE FROM Diarys WHERE id=?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setInt(1, id);

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
