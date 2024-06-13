package model;
import java.io.Serializable;

public class Animals implements Serializable {
  private String anicon_id;		/*ID*/
  private String anc_password;	/*パスワード*/

//引数がないコンストラクタ
  public Animals() {

  }
  //引数があるコンストラクタ
  public Animals(String anicon_id, String anc_password){
    super();
       this.anicon_id = anicon_id;
       this.anc_password = anc_password;
  }
public String getAnicon_id() {
	return anicon_id;
}
public void setAnicon_id(String anicon_id) {
	this.anicon_id = anicon_id;
}
public String getAnc_password() {
	return anc_password;
}
public void setAnc_password(String anc_password) {
	this.anc_password = anc_password;
}

}
