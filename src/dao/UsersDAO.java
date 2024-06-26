package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;
public class UsersDAO {
			// 個人登録
			public boolean insert(String name,String id,String pw) {
				Connection conn = null;
				boolean result = false;
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");
					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Users VALUES (NULL, ?, ?, ?, false, null, null, null, null)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
						if (id != null ) {
							pStmt.setString(1, id);
						}
						else {
							pStmt.setString(1, "");
						}
						if (name != null ) {
							pStmt.setString(2, name);
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
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");
					// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
					String sql = "INSERT INTO Users VALUES (NULL, ?, ?, ?, true, ?, ?, ?, ?)";
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
			public boolean isLoginOK(String id,String pw) {
				Connection conn = null;
				boolean loginResult = false;
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
					// SELECT文を準備する
					String sql = "SELECT COUNT(*) FROM Users WHERE user_id = ? AND user_password =?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,id);
					pStmt.setString(2,pw);
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

			public  List<Users> is_organization(String id,String pw){
				Connection conn = null;
				/*boolean organization = false;*/
				List<Users> cardList = new ArrayList<Users>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
					// SELECT文を準備する
					String sql = "SELECT * FROM Users WHERE user_id = ? AND user_password =?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,id);
					pStmt.setString(2,pw);
					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();
					// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
					while(rs.next()) {
						Users record = new Users(
						rs.getInt("id"),
						 rs.getString("user_id"),
						 rs.getString("user_name"),
						 rs.getString("user_password"),
						 rs.getBoolean("is_organization"),
						 rs.getString("address"),
						 rs.getString("phonenumber"),
						 rs.getString("email"),
						 rs.getString("remarks")
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
				return cardList;
			}


			public  List<Users> is_organization(String user_id,String address,String phonenumber, String email,String remarks){
				Connection conn = null;
				/*boolean organization = false;*/
				List<Users> cardList = new ArrayList<Users>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
					// SELECT文を準備する
					String sql = "SELECT * FROM Users WHERE user_id = ? AND address = ? AND phonenumber = ? AND email = ? AND remarks = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,user_id);
					pStmt.setString(2,address);
					pStmt.setString(3,phonenumber);
					pStmt.setString(4,email);
					pStmt.setString(5,remarks);
					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();
					// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
					while(rs.next()) {
						Users record = new Users(
						rs.getInt("id"),
						 rs.getString("user_id"),
						 rs.getString("user_name"),
						 rs.getString("user_password"),
						 rs.getBoolean("is_organization"),
						 rs.getString("address"),
						 rs.getString("phonenumber"),
						 rs.getString("email"),
						 rs.getString("remarks")
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
				return cardList;
			}


			public  List<Users> select(){
				Connection conn = null;
				/*boolean organization = false;*/
				List<Users> organizationsList = new ArrayList<Users>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
					// SELECT文を準備する
					String sql = "SELECT * FROM Users WHERE is_organization=true";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();
					// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
					while(rs.next()) {
						Users record = new Users(
						rs.getInt("id"),
						 rs.getString("user_id"),
						 rs.getString("user_name"),
						 rs.getString("user_password"),
						 rs.getBoolean("is_organization"),
						 rs.getString("address"),
						 rs.getString("phonenumber"),
						 rs.getString("email"),
						 rs.getString("remarks")
					     );
						organizationsList.add(record);
				}
				}catch (SQLException e) {
					e.printStackTrace();
					organizationsList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					organizationsList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							organizationsList = null;
						}
					}
				}
				return organizationsList;
			}
				public  List<Users> getName(String id){
					Connection conn = null;
					/*boolean organization = false;*/
					List<Users> cardList = new ArrayList<Users>();
					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");
						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
						// SELECT文を準備する
						String sql = "SELECT * FROM Users WHERE id = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1,id);
						// SELECT文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
						while(rs.next()) {
							Users record = new Users(
							rs.getInt("id"),
							 rs.getString("user_id"),
							 rs.getString("user_name"),
							 rs.getString("user_password"),
							 rs.getBoolean("is_organization"),
							 rs.getString("address"),
							 rs.getString("phonenumber"),
							 rs.getString("email"),
							 rs.getString("remarks")
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
					return cardList;
				}

				public  List<Users> getId(String name){
					Connection conn = null;
					/*boolean organization = false;*/
					List<Users> cardList = new ArrayList<Users>();
					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");
						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/c3", "sa", "");
						// SELECT文を準備する
						String sql = "SELECT * FROM Users WHERE user_name = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1,name);
						// SELECT文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
						while(rs.next()) {
							Users record = new Users(
							rs.getInt("id"),
							 rs.getString("user_id"),
							 rs.getString("user_name"),
							 rs.getString("user_password"),
							 rs.getBoolean("is_organization"),
							 rs.getString("address"),
							 rs.getString("phonenumber"),
							 rs.getString("email"),
							 rs.getString("remarks")
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
					return cardList;
				}


			public boolean update(Users card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
					//お気に入り登録時

						String sql = "UPDATE Users SET user_id=?, user_name=?, user_password=?, address=?, phonenumber=?, "
							+ "email=?, remarks=? WHERE id=? AND is_organization=true";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (card.getUser_id() != null) {
							pStmt.setString(1, card.getUser_id());
						}
						else {
							pStmt.setString(1, null);
						}
						if (card.getUser_name() != null) {
							pStmt.setString(2, card.getUser_name());
						}
						else {
							pStmt.setString(2, null);
						}
						if (card.getUser_password() != null) {
							pStmt.setString(3, card.getUser_password());
						}
						else {
							pStmt.setString(3, null);
						}
						if (card.getAddress() != null) {
							pStmt.setString(4, card.getAddress());
						}
						else {
							pStmt.setString(4, null);
						}
						if (card.getPhone_number() != null) {
							pStmt.setString(5, card.getPhone_number());
						}
						else {
							pStmt.setString(5, null);
						}
						if (card.getEmails() != null) {
							pStmt.setString(6, card.getEmails());
						}
						else {
							pStmt.setString(6, null);
						}
						if (card.getRemarks() != null) {
							pStmt.setString(7, card.getRemarks());
						}
						else {
							pStmt.setString(7, null);
						}
						//更新ボタンを押した動物のidを格納
						pStmt.setInt(8, card.getId());


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

			public boolean delete(int id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C3", "sa", "");

					// SQL文を準備する
					String sql = "DELETE FROM Users WHERE id=?";
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

	/*			public static void main(String[] args) {
					// select()のテスト
					System.out.println("---------- select()のテスト ----------");
					UsersDAO iDao = new UsersDAO();
					if (iDao.isLoginOK("orgA", "orgA")) {	// ログイン成功
						List<Users> loginList = iDao.is_organization("orgA", "orgA");
						for(Users loginlist: loginList) {
						if(loginlist.getIs_organization()== true){
			//団体用のホームページ
							System.out.println(loginlist.getUser_name());
						}
						else {
			//個人用
						}
						}
					}
				}*/
			}