package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.News;

	public class NewsDAO {
			// 団体お知らせ検索
			public List<News> select(String id) {
				Connection conn = null;
				List<News> cardList = new ArrayList<News>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM News WHERE user_id=? ORDER BY id";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					pStmt.setString(1, id);
					/*if (card.getNews_title() != null) {
						pStmt.setString(1, "%" + card.getNews_title() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (card.getNews_day() != null) {
						pStmt.setTimestamp(2, null);
					}
					else {
						pStmt.setTimestamp(2, null);
					}
					if (card.getNews_detail() != null) {
						pStmt.setString(3, "%" + card.getNews_detail() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}*/

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						News record = new News(
							rs.getInt("id"),
							rs.getString("news_title"),
							rs.getTimestamp("news_day"),
							rs.getString("news_detail"),
							rs.getString("user_id")
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

			// 管理者お知らせ検索
			public List<News> select1() {
				Connection conn = null;
				List<News> cardList = new ArrayList<News>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM News ORDER BY id";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					/*if (card.getNews_title() != null) {
						pStmt.setString(1, "%" + card.getNews_title() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (card.getNews_day() != null) {
						pStmt.setTimestamp(2, null);
					}
					else {
						pStmt.setTimestamp(2, null);
					}
					if (card.getNews_detail() != null) {
						pStmt.setString(3, "%" + card.getNews_detail() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}*/

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						News record = new News(
							rs.getInt("id"),
							rs.getString("news_title"),
							rs.getTimestamp("news_day"),
							rs.getString("news_detail"),
							rs.getString("user_id")
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

			//団体お知らせ登録
			public boolean insert(News card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO News VALUES (Null, ?, Current_timestamp, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					if (card.getNews_title() != null) {
						pStmt.setString(1, "%" + card.getNews_title() + "%");
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getNews_day() != null) {
						pStmt.setTimestamp(2, null);
					}
					else {
						pStmt.setTimestamp(2, null);
					}
					if (card.getNews_detail() != null) {
						pStmt.setString(3, card.getNews_detail());
					}
					else {
						pStmt.setString(3, null);
					}
					if (card.getUser_id() != null) {
						pStmt.setString(4, card.getUser_id());
					}
					else {
						pStmt.setString(4, null);
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

				//管理者お知らせ登録
				public boolean insert1(News card) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

						// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
						String sql = "INSERT INTO News VALUES (Null, ?, ?, ?, ?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
							if (card.getNews_title() != null) {
								pStmt.setString(1, "%" + card.getNews_title() + "%");
							}
							else {
								pStmt.setString(1, null);
							}
							if (card.getNews_day() != null) {
								pStmt.setTimestamp(2, null);
							}
							else {
								pStmt.setTimestamp(2, null);
							}
							if (card.getNews_detail() != null) {
								pStmt.setString(3, card.getNews_detail());
							}
							else {
								pStmt.setString(3, null);
							}
							if (card.getUser_id() != null) {
								pStmt.setString(4, card.getUser_id());
							}
							else {
								pStmt.setString(4, null);
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


	//団体お知らせ更新
		public boolean update(News card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				//お気に入り登録時

					String sql = "UPDATE News SET news_title=?, news_detail=? WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getNews_title() != null) {
						pStmt.setString(1, card.getNews_title());
					}
					else {
						pStmt.setInt(1, 0);
					}

					if (card.getNews_detail() != null) {
						pStmt.setString(2, card.getNews_detail());
					}
					else {
						pStmt.setString(2, null);
					}

					//更新ボタンを押したお知らせのidを格納
					pStmt.setInt(3, card.getId());


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

		//管理者お知らせ更新
		public boolean update1(News card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				//お気に入り登録時

					String sql = "UPDATE News SET news_title=?, news_day=?, news_detail=? WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getNews_title() != null) {
						pStmt.setString(1, card.getNews_title());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getNews_day() != null) {
						pStmt.setTimestamp(2, card.getNews_day());
					}
					else {
						pStmt.setTimestamp(2, null);
					}
					if (card.getNews_detail() != null) {
						pStmt.setString(3, card.getNews_detail());
					}
					else {
						pStmt.setString(3, null);
					}
					if (card.getUser_id() != null) {
						pStmt.setString(4, card.getUser_id());
					}
					else {
						pStmt.setInt(4, 0);
					}

					//更新ボタンを押した動物のidを格納
					pStmt.setInt(11, card.getId());


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


	//団体お知らせ削除
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
				String sql = "DELETE FROM News WHERE id=?";
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

			//管理者お知らせ削除
			//session
			public boolean delete1(int id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

					// SQL文を準備する
					String sql = "DELETE FROM News WHERE id=?";
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
