package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Events implements Serializable{
  private int id;				  	/*ID*/
  private String event_name;		/*名前*/
  private Timestamp event_day;		/*日付*/
  private String event_place;		/*場所*/
  private String event_remarks;		/*備考*/
  private String user_name;			/*ユーザー名*/


//引数がないコンストラクタ
  public Events() {

  }
//引数があるコンストラクタ
  public Events(int id, String event_name,  Timestamp event_day, String event_place,
		         String event_remarks, String user_name) {
       super();
       this.id = id;
       this.event_name = event_name;
       this.event_day = event_day;
       this.event_place =event_place;
       this.event_remarks =event_remarks;
       this.user_name =user_name;

  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

//EL式 ${e.event_name}
public String getEvent_name() {
	return event_name;
}
public void setEvent_name(String event_name) {
	this.event_name = event_name;
}
public Timestamp getEvent_day() {
	return event_day;
}
public void setEvent_day(Timestamp event_day) {
	this.event_day = event_day;
}
//EL式 ${e.year} → java変換　getをつける、先頭を大文字にする。 → e.getYear()
//java式　インスタンス名.getYear();

//EL式 ${e.year}
public String getYear() {
	//this.event_dayのフィールドから年のデータだけを取出して返す処理
	return "2024";
}
/*public void setYear(Timestamp year) {
	this.year = year;
}*/
public String getMonth() {
	return "6";
}
/*public void setMonth(Timestamp month) {
	this.month = month;
}*/
public String getDay() {
	return "24";
}
/*public void setDay(Timestamp day) {
	this.day = day;
}*/
public String getEvent_place() {
	return event_place;
}
public void setEvent_place(String event_place) {
	this.event_place = event_place;
}
public String getEvent_remarks() {
	return event_remarks;
}
public void setEvent_remarks(String event_remarks) {
	this.event_remarks = event_remarks;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
}
