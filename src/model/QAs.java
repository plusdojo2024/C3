package model;
import java.io.Serializable;

public class QAs implements Serializable{
  private int id;				/*質問番号*/
  private String question;		/*質問*/
  private String answer;		/*回答*/


//引数がないコンストラクタ
  public QAs() {

  }
  //引数があるコンストラクタ
  public QAs(int id, String question, String answer){
    super();
       this.id=id;
       this.question = question;
       this.answer = answer;
  }


public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}

