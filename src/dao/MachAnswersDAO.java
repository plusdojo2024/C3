package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MachAnswers;

public class MachAnswersDAO {
		//診断結果を表示
		public List<MachAnswers> select(MachAnswers card) {
			Connection conn = null;
			List<MachAnswers> cardList = new ArrayList<MachAnswers>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
					String sql = "SELECT animal_type, img FROM MachAnswers WHERE(a1=? AND a2=? AND a3=? AND a4=? AND a5=?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					pStmt.setBoolean(1, card.getA1());
					pStmt.setBoolean(2, card.getA2());
					pStmt.setBoolean(3, card.getA3());
					pStmt.setBoolean(4, card.getA4());
					pStmt.setBoolean(5, card.getA5());
					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						MachAnswers record = new MachAnswers(
							rs.getInt("answer_number"),
							rs.getString("animal_type"),
							rs.getString("img"),
							rs.getBoolean("q1"),
							rs.getBoolean("q2"),
							rs.getBoolean("q3"),
							rs.getBoolean("q4"),
							rs.getBoolean("q5")
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
}
