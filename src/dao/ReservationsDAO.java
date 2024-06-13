package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Reservations;
import model.Users;

public class ReservationsDAO {

			public boolean insert(Users card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");
					
					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Reservations VALUES (?, ?, ?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
			
					// SQL文を完成させる
					if (card.getUser_name() != null ) {//団体名
						pStmt.setString(1, card.getUser_name());
					}
					else {
						pStmt.setString(1, "");
					}
					if (card.getAnimal_name() != null ) {//個体名
						pStmt.setString(2, card.getAnimal_name());
					}
					else {
						pStmt.setString(2, "");
					}
					if (card.getRsv_day() != null ) {//日時
						pStmt.setString(3, card.getRsv_day());
					}
					else {
						pStmt.setString(3, "");
					}
					if (card.getPhonenumber() != null ) {//電話番号
						pStmt.setString(4, card.getPhonenumber());
					}
					else {
						pStmt.setString(4, "");
					}
					if (card.getReservation_remarks() != null ) {//備考
						pStmt.setString(5, card.getReservation_remarks());
					}
					else {
						pStmt.setString(5, "");
					}
					
					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;						
					}}
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
			public List<Reservations> select(Reservations card) {
				Connection conn = null;
				List<Reservations> cardList = new ArrayList<Reservations>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3","sa", "");

					// SQL文を準備する
						String sql = "SELECT * FROM Reservations WHERE User_name LIKE ? AND Animal_name LIKE ? AND Date ? AND Phonenumber ? AND Remarks LIKE ? AND ";
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
						if (card.getRsv_day() != null) {
							pStmt.setString(3, "%" + card.getRsv_day() + "%");
						}
						else {
							pStmt.setString(3, "%");
						}
						if (card.getPhonenumber() != null) {
							pStmt.setString(4, "%" + card.getPhonenumber() + "%");
						}
						else {
							pStmt.setString(4, "%");
						}
						if (card.getReservation_remarks() != null) {
							pStmt.setString(5, "%" + card.getReservation_remarks() + "%");
						}
						else {
							pStmt.setString(5, "%");
						
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Reservations record = new Reservations(
								rs.getString("user_name"),
								rs.getString("animal_name"),
								rs.getTimestamp("Rsv_day"),
								rs.getString("Phonenumber"),
								rs.getString("Reservation_remarks")
								);
							cardList.add(record);
						}

				    catch (SQLException e) {
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
