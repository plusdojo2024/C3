package model;
import java.io.Serializable;

public class Anicons implements Serializable {
  private String anicon_id;		/*ID*/
  private String anicon_password;	/*パスワード*/

//引数がないコンストラクタ
  public Anicons() {

  }
  //引数があるコンストラクタ
  public Anicons(String anicon_id, String anc_password){
    super();
       this.anicon_id = anicon_id;
       this.anicon_password = anc_password;
  }
public String getAnicon_id() {
	return anicon_id;
}
public void setAnicon_id(String anicon_id) {
	this.anicon_id = anicon_id;
}
public String getAnicon_password() {
	return anicon_password;
}
public void setAnc_password(String anicon_password) {
	this.anicon_password = anicon_password;
}

}