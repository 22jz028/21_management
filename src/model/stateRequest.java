package model;
import java.io.Serializable;

public class stateRequest implements Serializable{
 private int id;
 private String state;
 
 public int getId() {
	 return id;
 }
 
 public void setId(int id) {
	 this.id = id;
 }
 public String getState() {
	 return state;
 }
 
 public void setState(String state) {
	 this.state = state;
 }
 
 
 
 public stateRequest() {
	 this(0, "");
 }
 public stateRequest(int id, String state) {
	 super();
	 this.id = id;
	 this.state = state;
 }
}
 
 
