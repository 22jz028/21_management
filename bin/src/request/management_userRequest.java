package request;

import java.io.Serializable;

public class management_userRequest implements Serializable{
	private String user_name;
	private String passward;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public management_userRequest(String user_name, String passward) {
		super();
		this.user_name = user_name;
		this.passward = passward;
	}
	public management_userRequest() {
		
	}
	
	
}
