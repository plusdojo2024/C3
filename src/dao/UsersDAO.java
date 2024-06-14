package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {
<<<<<<< HEAD
			
			public boolean insert(String name, String id, String password ) {
=======

			public boolean insert(String name,String id,String pw) {
>>>>>>> af0ce1be1311f22fc011d8e7889b65cf65c76fcb
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");

					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);


					// SQL文を完成させる
<<<<<<< HEAD
						
						if (name != null ) {
							pStmt.setString(1, name);
=======

						if (card.getUser_id() != null ) {
							pStmt.setString(1, card.getUser_id());
>>>>>>> af0ce1be1311f22fc011d8e7889b65cf65c76fcb
						}
						else {
							pStmt.setString(1, "");
						}
						if (id != null ) {
							pStmt.setString(2, id);
						}
						else {
							pStmt.setString(2, "");
						}
						if (password != null ) {
						pStmt.setString(3, password);
						}
						else {
							pStmt.setString(3, "");
						}
						
						/* 団体用
						if (card.getIs_organization() != null ) {
							pStmt.setString(4, card.getIs_organization());
						}
						else {
							pStmt.setString(4, "");
						}
						if (card.getAddress() != null ) {
							pStmt.setString(5, card.getAddress());
						}
						else {
							pStmt.setString(5, "");
						}
						if (card.getPhone_number() != null ) {
							pStmt.setString(6, card.getPhone_number());
						}
						else {
							pStmt.setString(6, "");
						}
						if (card.getEmails() != null ) {
							pStmt.setString(7, card.getEmails());
						}
						else {
							pStmt.setString(7, "");
						}
						if (card.getRemarks() != null ) {
							pStmt.setString(8, card.getRemarks());
						}
						else {
							pStmt.setString(8, "");
						}
						*/

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
}
