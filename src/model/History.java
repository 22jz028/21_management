package model;

import java.util.Date;

 public class History {
 private int id;
 private String product_name;
 private int item_number;
 private Date created_at;
 private Date updated_at;
 private int user_id;
 private String state;
	
 public History(int id, String product_name, int item_number, Date created_at, Date updated_at, int user_id, String state
		 ) {
	 super();
	 this.id = id;
	 this.product_name = product_name;
	 this.item_number = item_number;
	 this.created_at = created_at;
	 this.updated_at = updated_at;
	 this.user_id = user_id;
	 this.state = state;
 }
 public History() {
 }

public int getId() {
	return id;
}

public String getProduct_name() {
	return product_name;
}

public int getItem_number() {
	return item_number;
}

public Date getCreated_at() {
	return created_at;
}

public Date getUpdated_at() {
	return updated_at;
}
public int getUser_id() {
	return user_id;
}

public String getState() {
	return state;
}


}

