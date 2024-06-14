package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {
<<<<<<< HEAD
	
=======





>>>>>>> 6aa3371c619831c7a3a0d91298c24348f2d29fe6
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
<<<<<<< HEAD
						
=======


>>>>>>> 6aa3371c619831c7a3a0d91298c24348f2d29fe6
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


public boolean insert1(String id,String pw,String name,String ad,String phone,String email,String remarks) {

	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/doc/C3", "sa", "");

		// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
		String sql = "INSERT INTO Users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, )";
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
}
