package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
			// 個人登録
			public boolean insert(String name,String id,String pw) {

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
						if (name != null ) {
							pStmt.setString(1, name);
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
						if (pw != null ) {
							pStmt.setString(3, pw);
						}
						else {
							pStmt.setString(3, "");
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

			// 団体登録
			public boolean insert1(String id,String pw,String name,String ad,String phone,String email,String remarks) {

				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");

					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);


					// SQL文を完成させる
					if (id != null ) {
						pStmt.setString(1, id);
					}
					else {
						pStmt.setString(1, "");
					}
					if (pw != null ) {
						pStmt.setString(2, pw);
					}
					else {
						pStmt.setString(2, "");
					}
					if (name != null ) {
						pStmt.setString(3, name);
					}
					else {
						pStmt.setString(3, "");
					}
					if (ad != null ) {
						pStmt.setString(4, ad);
					}
					else {
						pStmt.setString(4, "");
					}
					if (phone != null ) {
						pStmt.setString(5,phone);
					}
					else {
						pStmt.setString(5, "");
					}
					if (email != null ) {
						pStmt.setString(6, email);
					}
					else {
						pStmt.setString(6, "");
					}
					if (remarks != null ) {
						pStmt.setString(7, remarks);
					}
					else {
						pStmt.setString(7, "");
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
			
				// 個人ログイン用メソッド
			public boolean isLoginOK(String name,String id,String pw) {
				Connection conn = null;
				boolean loginResult = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

					// SELECT文を準備する
					String sql = "SELECT COUNT(*) FROM Users WHERE name = ? AND id = ? AND pw =?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,name);
					pStmt.setString(2,id);
					pStmt.setString(3,pw);

					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
					rs.next();
					if (rs.getInt("COUNT(*)") == 1) {
						loginResult = true;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					loginResult = false;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							loginResult = false;
						}
					}
				}

				// 結果を返す
				return loginResult;
			}
			
				// 団体ログイン用メソッド
				public boolean isLoginOK1(String id,String pw,String name,String ad,String phone,String email,String remarks) {
					Connection conn = null;
					boolean loginResult = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

						// SELECT文を準備する
						String sql = "SELECT COUNT(*) FROM Users WHERE id = ? AND pw = ? AND name =? AND ad =? AND phone =? AND email =? AND remarks =?" ;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(2,pw);
						pStmt.setString(3,name);
						pStmt.setString(1,ad);
						pStmt.setString(1,phone);
						pStmt.setString(1,email);
						pStmt.setString(1,remarks);

						// SELECT文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
						rs.next();
						if (rs.getInt("COUNT(*)") == 1) {
							loginResult = true;
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						loginResult = false;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								loginResult = false;
							}
						}
					}

					// 結果を返す
					return loginResult;
				}
}			

		