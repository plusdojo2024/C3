package model;
import java.io.Serializable;
import java.sql.Timestamp;

public class Reservations implements Serializable{
  private int id;
  private int individual_id;
  private String animal_name;
  private Timestamp rsv_day;
  private String send_id;
  private String user_name;
  private String receive_id;
  private String reservation_remarks;
  private boolean accept;
//引数がないコンストラクタ
  public Reservations() {

  }
  //引数があるコンストラクタ
  public Reservations(int id, int individual_id, String animal_name, Timestamp rsv_day, String send_id,String user_name,  String receive_id, String reservation_remarks, boolean accept){
    super();
       this. id= id;
       this.individual_id = individual_id;
       this.animal_name = animal_name;
       this.rsv_day = rsv_day;
       this.send_id = send_id;
       this.user_name = user_name;
       this.receive_id = receive_id;
       this.reservation_remarks = reservation_remarks;
       this.accept = accept;
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIndividual_id() {
	return individual_id;
}
public void setAnimal_name(String animal_name) {
	this.animal_name = animal_name;
}
public String getAnimal_name() {
	return animal_name;
}
public void setIndividual_id(int individual_id) {
	this.individual_id = individual_id;
}
public Timestamp getRsv_day() {
	return rsv_day;
}
public void setRsv_day(Timestamp rsv_day) {
	this.rsv_day = rsv_day;
}
public String getSend_id() {
	return send_id;
}
public void setSend_id(String send_id) {
	this.send_id = send_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getReceive_id() {
	return receive_id;
}
public void setReceive_id(String receive_id) {
	this.receive_id = receive_id;
}
public String getReservation_remarks() {
	return reservation_remarks;
}
public void setReservation_remarks(String reservation_remarks) {
	this.reservation_remarks = reservation_remarks;
}
public boolean getAccept() {
	return accept;
}
public void setAccept(boolean accept) {
	this.accept = accept;
}

}
