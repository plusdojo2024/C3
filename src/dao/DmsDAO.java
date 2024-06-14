package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DMs;


public class DmsDAO {
	//DMトーク相手表示（個人ユーザー用）
	public List<DMs> selectTalk(DMs card) {
		Connection conn = null;
		List<DMs> cardList = new ArrayList<DMs>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");


			// SQL文を準備する
				String sql = "SELECT  FROM DMs WHERE(send_id=? OR receive_id=?) ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setString(1, card.getSend_id());
				pStmt.setString(2, card.getReceive_id());

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

	//DM送信相手プルダウン（個人ユーザー用）
	public List<DMs> selectPd(DMs card) {
		Connection conn = null;
		List<DMs> cardList = new ArrayList<DMs>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");


			// SQL文を準備する
				String sql = "SELECT  FROM DMs WHERE(send_id=? OR receive_id=?) ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setString(1, card.getSend_id());
				pStmt.setString(2, card.getReceive_id());

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

	//DMトーク履歴表示
	public List<DMs> select(DMs card) {
		Connection conn = null;
		List<DMs> cardList = new ArrayList<DMs>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
				String sql = "SELECT dm_detail FROM DMs WHERE(send_id=? OR receive_id=?) ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setString(1, card.getSend_id());
				pStmt.setString(2, card.getReceive_id());

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

	//DM送信
	public boolean insert(DMs card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO DMs VALUES (Null, ?, ?, CURRENT_TIMESTAMP, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, card.getSend_id());
				pStmt.setString(2, card.getReceive_id());
				pStmt.setString(3, card.getDm_details());
			    pStmt.setBoolean(4, true);

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
