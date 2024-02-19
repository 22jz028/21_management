package model;

import java.util.Date;

public class Users {
	private int id;
	private String user_name;
	private String email;
	private String passward;
	private Date created_at;
	private Date updated_at;
	
	public Users(int id, String user_name, String email, String passward, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.email = email;
		this.passward = passward;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	
	public int getId() {
		return id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassward() {
		return passward;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public Users() {}
		
	
}
