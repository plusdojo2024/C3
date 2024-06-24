package model;
import java.io.Serializable;
import java.sql.Date;

public class Individuals implements Serializable {
  private int id;				/*ID*/
  private int animal_id;			/*動物ID*/
  private String animal_name;	/*名前*/
  private String type;			/*犬種・猫種*/
  private int age;			/*年齢*/
  private String gender;		/*性別*/
  private String user_id;		/*ユーザー名*/
  private Date period;			/*保護日*/
  private String remarks;		/*備考*/
  private boolean is_castration;	/*去勢識別*/
  private Date birthday;		/*誕生日*/
  private String img;
  private String kind;/*画像*/


//引数がないコンストラクタ
  public Individuals() {

  }
  //引数があるコンストラクタ
  public Individuals(int id, int animal_id, String animal_name, String type, int age, String    gender, String user_id, Date period, String remarks, boolean is_castration, Date birthday, String img, String kind){
    super();
    this.id = id;
    this.animal_id = animal_id;
    this.animal_name = animal_name;
    this.type = type;
    this.age = age;
    this.gender = gender;
    this.user_id = user_id;
    this.period = period;
    this.remarks = remarks;
    this.is_castration = is_castration;
    this.birthday = birthday;
    this.img = img;
    this.kind = kind;
  }

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAnimal_id() {
	return animal_id;
}
public void setAnimal_id(int animal_id) {
	this.animal_id = animal_id;
}
public String getAnimal_name() {
	return animal_name;
}
public void setAnimal_name(String animal_name) {
	this.animal_name = animal_name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public Date getPeriod() {
	return period;
}
public void setPeriod(Date period) {
	this.period = period;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public boolean getIs_castration() {
	return is_castration;
}
public void setIs_castration(boolean is_castration) {
	this.is_castration = is_castration;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public void setKind(String kind) {
	this.kind = kind;
}
public String getKind() {
	return kind;
}

}
