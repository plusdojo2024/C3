package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDAO {

			public boolean insert(Users card) {
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

						if (card.getUser_id() != null ) {
							pStmt.setString(1, card.getUser_id());
						}
						else {
							pStmt.setString(1, "");
						}
						if (card.getUser_name() != null ) {
							pStmt.setString(2, card.getUser_name());
						}
						else {
							pStmt.setString(2, "");
						}
						if (card.getUser_password() != null ) {
							pStmt.setString(3, card.getUser_password());
						}
						else {
							pStmt.setString(3, "");
						}
						if (card.getIs_organization() != null ) {
							pStmt.setString(4, card.getIs_organization());
						}
						else {
							pStmt.setString(4, "");
						}
						if (card.getAdress() != null ) {
							pStmt.setString(5, card.getAdress());
						}
						else {
							pStmt.setString(5, "");
						}
						if (card.getPhonenumber() != null ) {
							pStmt.setString(6, card.getPhonenumber());
						}
						else {
							pStmt.setString(6, "");
						}
						if (card.getEmail() != null ) {
							pStmt.setString(7, card.getEmail());
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
