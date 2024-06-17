package model;

import java.io.Serializable;
import java.sql.Timestamp;


public class DMs implements Serializable{
  private int id;				  	/*ID*/
  private String send_id;		/*送信ユーザーID*/
  private String receive_id;			/*受信ユーザーID*/
  private Timestamp dm_day;		/*日付*/
  private String dm_detail;		/*内容*/
  private boolean read;		/*既読*/
  private String user_name;

//引数がないコンストラクタ
  public DMs() {

  }
//引数があるコンストラクタ
  public DMs(int id, String send_id,  String receive_id, Timestamp dm_day,
		         String dm_detail, boolean read) {
       super();
       this.id = id;
       this.send_id = send_id;
       this.receive_id = receive_id;
       this. dm_day = dm_day;
       this.dm_detail = dm_detail;
       this.read = read;

  }

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSend_id() {
	return send_id;
}
public void setSend_id(String send_id) {
	this.send_id = send_id;
}
public String getReceive_id() {
	return receive_id;
}
public void setReceive_id(String receive_id) {
	this.receive_id = receive_id;
}
public Timestamp getDm_day() {
	return dm_day;
}
public void setDm_day(Timestamp dm_day) {
	this.dm_day = dm_day;
}
public String getDm_detail() {
	return dm_detail;
}
public void setDm_details(String dm_detail) {
	this.dm_detail = dm_detail;
}
public boolean getRead() {
	return read;
}
public void setRead(boolean read) {
	this.read = read;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name){
	this.user_name = user_name;
}
}
