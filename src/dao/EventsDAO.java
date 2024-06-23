package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Events;

public class EventsDAO {
	//譲渡会データの表示
	public List<Events> select(Events card) {
		Connection conn = null;
		List<Events> cardList = new ArrayList<Events>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

			// SQL文を準備する
				String sql = "SELECT event_name, year, month, day, event_place, event_remarks, user_name FROM Events  ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Events record = new Events(
						rs.getInt("id"),
						rs.getString("event_name"),
						rs.getTimestamp("year"),
						rs.getTimestamp("month"),
						rs.getTimestamp("day"),
						rs.getString("event_place"),
						rs.getString("event_remarks"),
						rs.getString("user_name")
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
	//譲渡会名をプルダウン形式で表示
	public List<Events> selectPd() {
		Connection conn = null;
		List<Events> cardList = new ArrayList<Events>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

			// SQL文を準備する
				String sql = "SELECT id, event_name, year, month, day, event_place, event_remarks, user_name FROM Events  ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Events record = new Events(
						rs.getInt("id"),
						rs.getString("event_name"),
						rs.getTimestamp("year"),
						rs.getTimestamp("month"),
						rs.getTimestamp("day"),
						rs.getString("event_place"),
						rs.getString("event_remarks"),
						rs.getString("user_name")
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
	//譲渡会登録
	public boolean insert(Events card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Events VALUES (Null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//sessionスコープで団体id持ってきて名前入れる
				if (card.getEvent_name() != null) {
					pStmt.setString(1, card.getEvent_name());
				}
				else {
					pStmt.setString(1, "");
				}
				if (card.getYear() != null) {
					pStmt.setTimestamp(2, card.getYear());
				}
				else {
					pStmt.setTimestamp(2, null);
				}
				if (card.getMonth() != null) {
					pStmt.setTimestamp(3, card.getMonth());
				}
				else {
					pStmt.setTimestamp(3, null);
				}
				if (card.getDay() != null) {
					pStmt.setTimestamp(4, card.getDay());
				}
				else {
					pStmt.setTimestamp(4, null);
				}
				if (card.getEvent_place() != null) {
					pStmt.setString(5, card.getEvent_place());
				}
				else {
					pStmt.setString(5, "");
				}
				if (card.getEvent_remarks() != null) {
					pStmt.setString(6, card.getEvent_remarks());
				}
				else {
					pStmt.setString(6, "");
				}
				if (card.getUser_name() != null) {
					pStmt.setString(7, card.getUser_name());
				}
				else {
					pStmt.setString(7, "");
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
	//譲渡会更新
	public boolean update(Events card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

			// SQL文を準備する
			//お気に入り登録時

				String sql = "UPDATE Events SET event_name=?, year=?, month=?, day=?, event_place=?, event_remarks=?, user_name=? WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getEvent_name() != null) {
					pStmt.setString(1, card.getEvent_name());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getYear() != null) {
					pStmt.setTimestamp(2, card.getYear());
				}
				else {
					pStmt.setTimestamp(2, null);
				}
				if (card.getMonth() != null) {
					pStmt.setTimestamp(3, card.getMonth());
				}
				else {
					pStmt.setTimestamp(3, null);
				}
				if (card.getDay() != null) {
					pStmt.setTimestamp(4, card.getDay());
				}
				else {
					pStmt.setTimestamp(4, null);
				}
				if (card.getEvent_place() != null) {
					pStmt.setString(5, card.getEvent_place());
				}
				else {
					pStmt.setString(5, null);
				}
				if (card.getEvent_remarks() != null) {
					pStmt.setString(6, card.getEvent_remarks());
				}
				else {
					pStmt.setString(6, null);
				}
				if (card.getUser_name() != null) {
					pStmt.setString(7, card.getUser_name());
				}
				else {
					pStmt.setString(7, null);
				}				
				pStmt.setInt(5, card.getId());
				//更新ボタンを押した譲渡会のidを格納



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
	//譲渡会削除
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
			String sql = "DELETE FROM Events WHERE id=?";
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
