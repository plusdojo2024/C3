package model;
import java.io.Serializable;

public class Animals implements Serializable {
  private int id;		/*ID*/
  private String kind;	/*種類*/

//引数がないコンストラクタ
  public Animals() {

  }
  //引数があるコンストラクタ
  public Animals(int id, String kind){
    super();
       this.id = id;
       this.kind =kind;
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}

}
