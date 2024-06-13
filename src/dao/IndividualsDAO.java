package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndividualsDAO {
	// 動物検索

		public List<Individuals> select(Individuals card) {
			Connection conn = null;
			List<Individuals> cardList = new ArrayList<Individuals>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
					String sql = "SELECT * FROM Individuals WHERE user_name LIKE ? AND animal_name LIKE ? AND kind LIKE ? AND type LIKE ? AND gender LIKE ? AND "
								+ " age LIKE ORDER BY number";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる

					if (card.getUser_name() != null) {
						pStmt.setString(1, "%" + card.getUser_name() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (card.getAnimal_name() != null) {
						pStmt.setString(2, "%" + card.getAnimal_name() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}
					if (card.getKind() != null) {
						pStmt.setString(3, "%" + card.getKind() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}
					if (card.getType() != null) {
						pStmt.setString(4, "%" + card.getType() + "%");
					}
					else {
						pStmt.setString(4, "%");
					}
					if (card.getGender() != null) {
						pStmt.setString(5, "%" + card.getGender() + "%");
					}
					else {
						pStmt.setString(5, "%");
					}
					if (card.getAge() != null) {
						pStmt.setInt(6, "%" + card.getAge() + "%");
					}

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Individuals record = new Individuals(
							rs.getString("user_name"),
							rs.getString("animal_name"),
							rs.getString("kind"),
							rs.getString("type"),
							rs.getString("gender"),
							rs.getInt("age")
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
	//動物登録
		public boolean insert(Individuals card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO Individuals VALUES (Null, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					//犬かネコか
					if (card.get() != null) {
						pStmt.setInt(1, card.get());
					}
					else {
						pStmt.setInt(1, "");
					}
					if (card.getAnimal_name() != null) {
						pStmt.setString(2, card.getAnimal_name());
					}
					else {
						pStmt.setString(2, "");
					}
					if (card.getType() != null) {
						pStmt.setString(3, card.getType());
					}
					else {
						pStmt.setString(3, "");
					}
					if (card.getAge() != null) {
						pStmt.setString(4, card.getAge());
					}
					else {
						pStmt.setString(4, "");
					}
					if (card.getGender() != null) {
						pStmt.setInt(5, card.getGender());
					}
					else {
						pStmt.setString(5, "");
					}
					//sessionスコープで団体id持ってきて名前入れる
					if (card.get() != null) {
						pStmt.setString(6, card.get());
					}
					else {
						pStmt.setString(6, "");
					}
					if (card.getRemarks() != null) {
						pStmt.setString(7, card.getRemarks());
					}
					else {
						pStmt.setString(7, "");
					}
					if (card.getIs_castration() != null) {
						pStmt.setBoolean(8, card.getIs_castration());
					}
					else {
						pStmt.setBoolean(8, "");
					}
					if (card.getBirthday() != null) {
						pStmt.setDate(9, card.getBirthday());
					}
					else {
						pStmt.setDate(9, "");
					}
					if (card.getImg() != null) {
						pStmt.setString(10, card.getImg());
					}
					else {
						pStmt.setString(10, "");
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
	//動物更新
		public boolean update(Individuals card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				//お気に入り登録時

					String sql = "UPDATE Individuals SET animal_id=?, animal_name=?, type=?, age=?, gender=?, "
						+ "user_name=?, remarks=?, is_castration=?, birthday=?, img=? WHERE id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getAnimal_id() != null) {
						pStmt.setInt(1, card.getAnimal_id());
					}
					else {
						pStmt.setInt(1, null);
					}
					if (card.getAnimal_name() != nul) {
						pStmt.setString(2, card.getAnimal_name());
					}
					else {
						pStmt.setString(2, null);
					}
					if (card.getType() != null) {
						pStmt.setString(3, card.getType());
					}
					else {
						pStmt.setString(3, null);
					}
					if (card.getAge() != null) {
						pStmt.setInt(4, card.getAge());
					}
					else {
						pStmt.setInt(4, null);
					}
					if (card.getGender() != null) {
						pStmt.setString(5, card.getGender());
					}
					else {
						pStmt.setString(5, null);
					}
					if (card.getUser_name() != null) {
						pStmt.setString(6, card.getUser_name());
					}
					else {
						pStmt.setString(6, null);
					}
					if (card.getRemarks() != null) {
						pStmt.setString(7, card.getRemarks());
					}
					else {
						pStmt.setString(7, null);
					}
					if (card.getIs_castration() != null) {
						pStmt.setBoolean(8, card.getIs_castration());
					}
					else {
					pStmt.setBoolean(8, null);
					}
					if (card.getBirthday() != null) {
						pStmt.setDate(9, card.getBirthday());
					}
					else {
						pStmt.setDate(9, null);
					}
					if (card.getImg() != null) {
						pStmt.setString(10, card.getImg());
					}
					else {
						pStmt.setString(10, null);
					}
					//更新ボタンを押した動物のidを格納
					pStmt.setInt(11, null);


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

	//削除
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
				String sql = "DELETE FROM Bc WHERE id=?";
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
