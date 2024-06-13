package model;

import java.io.Serializable;

public class Users implements Serializable {
  private int id;			/*ID*/
  private String user_id;	/*ユーザーID*/
  private String user_name;		/*ユーザー名*/
  private String user_password;	/*パスワード*/
  private String is_organization;	/*ユーザー識別*/
  private String address;		/*住所*/
  private String phone_number;		/*電話番号*/
  private String emails;		/*メールアドレス*/
  private String remarks;		/*備考*/

//引数がないコンストラクタ
  public Users() {

  }
  //引数があるコンストラクタ
  public Users(int id,String user_id, String user_name,String user_password,
  String is_organization, String address, String phone_number,String emails, String remarks){
    super();
      	 this.id = id;
      	 this.user_id = user_id;
      	 this.user_name = user_name;
      	 this.user_password = user_password;
      	 this.is_organization = is_organization;
      	 this.address = address;
      	 this.phone_number = phone_number;
      	 this.emails = emails;
      	 this.remarks = remarks;
  }

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public String getIs_organization() {
	return is_organization;
}
public void setIs_organization(String is_organization) {
	this.is_organization = is_organization;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
public String getEmails() {
	return emails;
}
public void setEmails(String emails) {
	this.emails = emails;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}

}
