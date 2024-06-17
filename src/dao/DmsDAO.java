package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DMs;
import model.Users;

public class DmsDAO {
	//トーク相手の表示
			public List<DMs> select(String my_id) {
				Connection conn = null;
				List<DMs> cardList = new ArrayList<DMs>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
						String sql = "SELECT * "
								+ "	FROM (SELECT * "
								+ "		FROM(SELECT who_id,MAX(dm_day) as recent_dm_day "
								+ "		FROM(SELECT dm_day, "
								+ "			CASE "
								+ "			WHEN send_id = ? THEN receive_id "
								+ "			WHEN receive_id = ? THEN send_id "
								+ "			END AS who_id "
								+ "			FROM DMS WHERE send_id=? OR receive_id=?) "
								+ "		GROUP BY who_Id) "
								+ "		ORDER BY recent_dm_day DESC) "
								+ "	JOIN USERS ON who_id = USERS.id ";

						PreparedStatement  pStmt = conn.prepareStatement(sql);
						//System.out.println(pStmt.toString());
						// SQL文を完成させる
						//session
						pStmt.setString(1, my_id);
						pStmt.setString(2, my_id);
						pStmt.setString(3, my_id);
						pStmt.setString(4, my_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							DMs record = new DMs(
								rs.getInt("id"),
								rs.getString("who_id"),
								rs.getString("user_name"),
								rs.getTimestamp("recent_dm_day"),
								rs.getString("remarks"),
								rs.getBoolean("is_organization")

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

	//トーク履歴表示
			public List<DMs> selectTalk(String my_id, String your_id) {
				Connection conn = null;
				List<DMs> cardList = new ArrayList<DMs>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
						String sql = "SELECT * FROM DMs\r\n"
								+ "	WHERE (send_id=? AND receive_id=?)\r\n"
								+ "	OR (receive_id=? AND send_id=?)	\r\n"
								+ "		ORDER BY dm_day ASC;\r\n";

						PreparedStatement  pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる
						//session
						pStmt.setString(1, my_id);
						pStmt.setString(2, your_id);
						pStmt.setString(3, my_id);
						pStmt.setString(4, your_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							DMs record = new DMs(
								rs.getInt("id"),
								rs.getString("send_id"),
								rs.getString("receive_id"),
								rs.getTimestamp("dm_day"),
								rs.getString("dm_detail"),
								rs.getBoolean("read")

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
	//団体一覧
			public List<Users> selectOrganization() {
				Connection conn = null;
				List<Users> cardList = new ArrayList<Users>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
						String sql = "SELECT * FROM USERS WHERE is_organization=true ORDER BY id ASC";

						PreparedStatement  pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Users record = new Users(
								rs.getInt("id"),
								rs.getString ("user_id"),	/*ユーザーID*/
								rs.getString("user_name"),		/*ユーザー名*/
								rs.getString("user_password"),	/*パスワード*/
								rs.getBoolean("is_organization"),	/*ユーザー識別*/
								rs.getString("address"),		/*住所*/
								rs.getString("phonenumber"),		/*電話番号*/
								rs.getString("email"),		/*メールアドレス*/
								rs.getString("remarks")
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
	//個人ユーザー一覧
			public List<Users> selectUser() {
				Connection conn = null;
				List<Users> cardList = new ArrayList<Users>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
						String sql = "SELECT * FROM USERS WHERE is_organization=false ORDER BY id ASC";

						PreparedStatement  pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Users record = new Users(
								rs.getInt("id"),
								rs.getString ("user_id"),	/*ユーザーID*/
								rs.getString("user_name"),		/*ユーザー名*/
								rs.getString("user_password"),	/*パスワード*/
								rs.getBoolean("is_organization"),	/*ユーザー識別*/
								rs.getString("address"),		/*住所*/
								rs.getString("phonenumber"),		/*電話番号*/
								rs.getString("email"),		/*メールアドレス*/
								rs.getString("remarks")
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
			//トーク送信
			public boolean insert(String send_id, String receive_id, String dm_detail, boolean read) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");

					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO DMs VALUES (Null, ?, ?, CURRENT_TIMESTAMP, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					//sessionスコープで団体id持ってきて名前入れる
					pStmt.setString(1, send_id);
					pStmt.setString(2, receive_id);
					if (dm_detail != null) {
							pStmt.setString(3, dm_detail);
					}
					else {
						pStmt.setString(3, "");
					}
					pStmt.setBoolean(4, read);


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

			public static void main(String[] args) {
				DmsDAO dao = new DmsDAO();

				// select()のテスト
				System.out.println("---------- selectTalk()のテスト ----------");
				List<DMs> cardList3 = dao.selectTalk("1","2");
				for (DMs card : cardList3) {
					System.out.println(card.getDm_detail());
				}
				System.out.println("---------- selectOrganization()のテスト ----------");
				List<Users> cardList4 = dao.selectOrganization();
				for (Users card : cardList4) {
					System.out.println(card.getUser_name());
				}
		/*		System.out.println("---------- insert()のテスト ----------");
				if (dao.insert("1","2","頑張ろう",true)) {
					System.out.println("登録成功！");
					List<DMs> cardList5 = dao.selectTalk("1","2");
					for (DMs card : cardList5) {
						System.out.println(card.getId());
						System.out.println(card.getSend_id());
						System.out.println(card.getReceive_id());
						System.out.println(card.getDm_day());
						System.out.println(card.getDm_detail());
						System.out.println(card.getRead());


						System.out.println();
				}
				}else {
					System.out.println("登録失敗！");
				}*/
				System.out.println("---------- select()のテスト ----------");
				List<DMs> cardList2 = dao.select("1");
				for (DMs card : cardList2) {
					System.out.println(card.getUser_name());
				}
			}

			}