package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Events implements Serializable{
  private int id;				  	/*ID*/
  private String event_name;		/*名前*/
  private Timestamp year;			/*年数*/
  private Timestamp month;			/*月*/
  private Timestamp day;			/*日*/
  private String event_place;		/*場所*/
  private String event_remarks;		/*備考*/
  private String user_name;			/*ユーザー名*/


//引数がないコンストラクタ
  public Events() {

  }
//引数があるコンストラクタ
  public Events(int id, String event_name,  Timestamp year,  Timestamp month,  Timestamp day, String event_place,
		         String event_remarks, String user_name) {
       super();
       this.id = id;
       this.event_name = event_name;
       this.year = year;
       this.month = month;
       this.day = day;
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
public String getEvent_name() {
	return event_name;
}
public void setEvent_name(String event_name) {
	this.event_name = event_name;
}
/*public Timestamp getEvent_day() {
	return event_day;
}
public void setEvent_day(Timestamp event_day) {
	this.event_day = event_day;
}*/
public Timestamp getYear() {
	return year;
}
public void setYear(Timestamp year) {
	this.year = year;
}
public Timestamp getMonth() {
	return month;
}
public void setMonth(Timestamp month) {
	this.month = month;
}
public Timestamp getDay() {
	return day;
}
public void setDay(Timestamp day) {
	this.day = day;
}
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
