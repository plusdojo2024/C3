package model;
import java.io.Serializable;
import java.sql.Timestamp;

public class Diarys implements Serializable{
  private int id;				/*ID*/
  private Timestamp diary_day;		/*投稿日*/
  private String user_id;		/*投稿者ユーザーID*/
  private String diary;			/*本文*/
  private String diary_title;		/*タイトル*/
//引数がないコンストラクタ
  public Diarys() {

  }
  //引数があるコンストラクタ
  public Diarys(int id, Timestamp diary_day, String user_id, String diary, String diary_title){
    super();
       this.id = id;
       this.diary_day = diary_day;
       this.user_id = user_id;
       this.diary = diary;
       this.diary_title = diary_title;
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Timestamp getDiary_day() {
	return diary_day;
}
public void setDiary_day(Timestamp diary_day) {
	this.diary_day = diary_day;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getDiary() {
	return diary;
}
public void setDiary(String diary) {
	this.diary = diary;
}
public String getDiary_title() {
	return diary_title;
}
public void setDiary_title(String diary_title) {
	this.diary_title = diary_title;
}

}
