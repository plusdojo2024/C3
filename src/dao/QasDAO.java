package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QAs;

public class QasDAO {
	// 質問検索
		public List<QAs> select(QAs card) {
			Connection conn = null;
			List<QAs> cardList = new ArrayList<QAs>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
					String sql = "SELECT * FROM QAs WHERE Question LIKE ? AND Answer LIKE ? AND ORDER BY number";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる

					if (card.getQuestion() != null) {
						pStmt.setString(1, "%" + card.getQuestion() + "%");
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getAnswer() != null) {
						pStmt.setString(2, "%" + card.getAnswer() + "%");
					}
					else {
						pStmt.setString(2, null);
					}

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						QAs record = new QAs(
							rs.getString("question"),
							rs.getString("answer")
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
	// 質問登録
		public boolean insert(QAs card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO QAs VALUES (Null, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					if (card.getQuestion() != null) {
						pStmt.setString(1, card.getQuestion());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getAnswer() != null) {
						pStmt.setString(2, card.getAnswer());
					}
					else {
						pStmt.setString(2, null);
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
	//質問更新
		public boolean update(QAs card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");

				// SQL文を準備する
				//お気に入り登録時

					String sql = "UPDATE QAs SET question=?, answer=? WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getQuestion() !=null) {
						pStmt.setString(1, card.getQuestion());
					}
					else {
						pStmt.setInt(1, 0);
					}
					if (card.getAnswer() != null) {
						pStmt.setString(2, card.getAnswer());
					}
					else {
						pStmt.setString(2, card.getAnswer());
					}
					//更新ボタンを押した質問のidを格納
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

	//質問削除
		//session
		public boolean delete(int id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM QAs WHERE id=?";
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

