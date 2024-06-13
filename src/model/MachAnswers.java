package model;
import java.io.Serializable;

public class MachAnswers implements Serializable{
  private int answer_number ;
  private String animal_type;
  private String img;
  private boolean a1;
  private boolean a2;
  private boolean a3;
  private boolean a4;
  private boolean a5;
//引数がないコンストラクタ
  public MachAnswers() {

  }
  //引数があるコンストラクタ
  public MachAnswers(int answer_number, String animal_type, String img, boolean a1, boolean a2, boolean a3, boolean a4, boolean a5){
    super();
       this. answer_number = answer_number;
       this.animal_type = animal_type;
       this.img = img;
       this.a1 = a1;
       this.a2 = a2;
       this.a3 = a3;
       this.a4 = a4;
       this.a5 = a5;
  }
public int getAnswer_number() {
	return answer_number;
}
public void setAnswer_number(int answer_number) {
	this.answer_number = answer_number;
}
public String getAnimal_type() {
	return animal_type;
}
public void setAnimal_type(String animal_type) {
	this.animal_type = animal_type;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public boolean isA1() {
	return a1;
}
public void setA1(boolean a1) {
	this.a1 = a1;
}
public boolean isA2() {
	return a2;
}
public void setA2(boolean a2) {
	this.a2 = a2;
}
public boolean isA3() {
	return a3;
}
public void setA3(boolean a3) {
	this.a3 = a3;
}
public boolean isA4() {
	return a4;
}
public void setA4(boolean a4) {
	this.a4 = a4;
}
public boolean isA5() {
	return a5;
}
public void setA5(boolean a5) {
	this.a5 = a5;
}

}
