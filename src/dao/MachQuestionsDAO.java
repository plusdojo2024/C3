package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MachQuestions;

public class MachQuestionsDAO {
	//診断テストのQuestionsを５つ表示
	public List<MachQuestions> select(MachQuestions card) {
		Connection conn = null;
		List<MachQuestions> cardList = new ArrayList<MachQuestions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
				String sql = "SELECT q1, q2, q3, q4, q5 FROM MachQuestions";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					MachQuestions record = new MachQuestions(
						rs.getString("q1"),
						rs.getString("q2"),
						rs.getString("q3"),
						rs.getString("q4"),
						rs.getString("q5")
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
	//Questions登録（未完成）
	public boolean insert(MachQuestions card) {
		Connection conn = null;
		boolean result = false;
	//	int qnum=0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO MachQuestions VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる



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

	//Questions更新
	public boolean update(MachQuestions card) {
		Connection conn = null;
		boolean result = false;
		int qnum=0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する

			if (qnum==1) {
				String sql = "UPDATE MachQuestions SET q1=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ1() != null) {
					pStmt.setString(1, card.getQ1());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==2) {
				String sql = "UPDATE MachQuestions SET q2=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ2() != null) {
					pStmt.setString(1, card.getQ2());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==3) {
				String sql = "UPDATE MachQuestions SET q3=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ3() != null) {
					pStmt.setString(1, card.getQ3());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==4) {
				String sql = "UPDATE MachQuestions SET q4=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ4() != null) {
					pStmt.setString(1, card.getQ4());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==5) {
				String sql = "UPDATE MachQuestions SET q5=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ5() != null) {
					pStmt.setString(1, card.getQ5());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
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
	//Questions削除
	public boolean delete(MachQuestions card) {
		Connection conn = null;
		boolean result = false;
		int qnum=0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			if (qnum==1) {
				String sql = "UPDATE MachQuestions SET q1=null";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==2) {
				String sql = "UPDATE MachQuestions SET q2=null";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==3) {
				String sql = "UPDATE MachQuestions SET q3=null";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==4) {
				String sql = "UPDATE MachQuestions SET q4=null";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			}else if(qnum==5) {
				String sql = "UPDATE MachQuestions SET q5=null";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
				result = true;
				}
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
