package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reservations;

public class ReservationsDAO {

			public boolean insert(Reservations card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");
					
					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Reservations VALUES (null, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
			
					// SQL文を完成させる
					if (card.getIndividual_id() != 0 ) {
						pStmt.setInt(1, card.getIndividual_id());
					}	
					else {
						pStmt.setInt(1, 0);
					}
					if (card.getRsv_day() != null ) {
						pStmt.setTimestamp(2, card.getRsv_day());
					}
					else {
						pStmt.setTimestamp(2, null);
					}
					if (card.getSend_id() != null) {
						pStmt.setString(3, card.getSend_id());
					}
					else {
						pStmt.setString(3, null);
					}
					if (card.getReceive_id() != null ) {
						pStmt.setString(4, card.getReceive_id());
					}
					else {
						pStmt.setString(4, null);
					}
					if (card.getReservation_remarks() != null ) {
						pStmt.setString(5, card.getReservation_remarks());
					}
					else {
						pStmt.setString(5, "");
					}
					if (card.getAccept() != false ) {
						pStmt.setBoolean(6, card.getAccept());
					}
					else {
						pStmt.setString(6, "");
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


			// リストに登録する
			public List<Reservations> select(Reservations card) {
				Connection conn = null;
				List<Reservations> cardList = new ArrayList<Reservations>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3","sa", "");

					// 検索する
						String sql = "SELECT * FROM Reservations WHERE Individual_id LIKE ? AND Animal_name LIKE ? AND Date ? AND Phonenumber ? AND Remarks LIKE ? AND ";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						
						// SQL文を完成させる
						if (card.getIndividual_id() != 0) {
							pStmt.setInt(1, card.getIndividual_id());
						}
						else {
							pStmt.setInt(1,0);
						}
						if (card.getRsv_day() != null) {
							pStmt.setTimestamp(2, card.getRsv_day());
						}
						else {
							pStmt.setTimestamp(2, null);
						}
						if (card.getSend_id() != null) {
							pStmt.setString(3, card.getSend_id());
						}
						else {
							pStmt.setString(3, null);
						}
						if (card.getReceive_id() != null) {
							pStmt.setString(4, card.getReceive_id());
						}
						else {
							pStmt.setString(4, null);
						}
						if (card.getReservation_remarks() != null) {
							pStmt.setString(5, "%" + card.getReservation_remarks() + "%");
						}
						else {
							pStmt.setString(5, "%");
						}
						if (card.getAccept() != false ) {
							pStmt.setBoolean(6, card.getAccept());
						}
						else {
							pStmt.setString(6, "");
						}
							
						
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Reservations record = new Reservations(
								rs.getInt("id"),
								rs.getInt("individual_id"),
								rs.getTimestamp("rsv_day"),
								rs.getString("send_id"),
								rs.getString("receive_id"),
								rs.getString("Reservation_remarks"),
								rs.getBoolean("accept")
								);
							cardList.add(record);
						}
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
			}				
