package model;
import java.io.Serializable;
import java.sql.Timestamp;

public class News implements Serializable{
  private int id;				  	/*ID*/
  private String news_title;		/*タイトル*/
  private Timestamp news_day;			/*日付*/
  private String news_detail;		/*本文*/
  private String user_id;		/*ユーザーID*/

//引数がないコンストラクタ
  public News() {

  }
//引数があるコンストラクタ
  public News(int id, String news_title,  Timestamp news_day, String news_detail,
		         String user_id) {
       super();
       this.id = id;
       this.news_title = news_title;
       this.news_day = news_day;
       this.news_detail = news_detail;
       this.user_id =user_id;

  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNews_title() {
	return news_title;
}
public void setNews_title(String news_title) {
	this.news_title = news_title;
}
public Timestamp getNews_day() {
	return news_day;
}
public void setNews_day(Timestamp news_day) {
	this.news_day = news_day;
}
public String getNews_detail() {
	return news_detail;
}
public void setNews_detail(String news_detail) {
	this.news_detail = news_detail;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}


}

