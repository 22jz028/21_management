package model;

public class Management_user{
private int id;
 private String user_name;
 private String passward;
// private Date created_at;
// private Date updated_at;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

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

//public Date getCreated_at() {
//	return created_at;
//}
//
//public void setCreated_at(Date created_at) {
//	this.created_at = created_at;
//}
//
//public Date getUpdated_at() {
//	return updated_at;
//}
//
//public void setUpdated_at(Date updated_at) {
//	this.updated_at = updated_at;
//}

public Management_user(int id, String user_name, String passward) {
	 super();
	 this.id = id;
	 this.user_name = user_name;
	 this.passward = passward;
//	 this.created_at = created_at;
//	 this.updated_at = updated_at;
}


}

