package model;

import java.io.Serializable;
import java.sql.Timestamp;


public class DMs implements Serializable{
  private int id;				  	/*ID*/
  private String user_id;		/*送信ユーザーID*/
  private String _id;			/*受信ユーザーID*/
  private Timestamp dm_day;		/*日付*/
  private String dm_details;		/*内容*/
  private boolean read;		/*既読*/

//引数がないコンストラクタ
  public DMs() {

  }
//引数があるコンストラクタ
  public DMs(int id, String user_id,  String _id, Timestamp dm_day,
		         String dm_details, boolean read) {
       super();
       this.id = id;
       this.user_id = user_id;
       this._id = _id;
       this. dm_day = dm_day;
       this.dm_details = dm_details;
       this.read = read;

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
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public Timestamp getDm_day() {
	return dm_day;
}
public void setDm_day(Timestamp dm_day) {
	this.dm_day = dm_day;
}
public String getDm_details() {
	return dm_details;
}
public void setDm_details(String dm_details) {
	this.dm_details = dm_details;
}
public boolean isRead() {
	return read;
}
public void setRead(boolean read) {
	this.read = read;
}
}
