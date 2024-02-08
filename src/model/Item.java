package model;

import java.util.Date;

public class Item {
private int id;
 private String product_name;
 private int price;
 private String description;
 private int stock;
 private Date created_at;
 private Date updated_at;
 private String image;
 private String material;
 private String sizename;
 private String category;
	
 public Item(int id, String product_name, int price, String description, int stock, Date created_at, Date updated_at,
		 String image, String material, String sizename, String category) {
	 super();
	 this.id = id;
	 this.product_name = product_name;
	 this.price = price;
	 this.description = description;
	 this.stock = stock;
	 this.created_at = created_at;
	 this.updated_at = updated_at;
	 this.image = image;
	 this.material = material;
	 this.sizename = sizename;
	 this.category = category;
 }
public Item () {
}


public int getId() {
	return id;
}
public String getProduct_name() {
	return product_name;
}


public int getPrice() {
	return price;
}


public String getDescription() {
	return description;
}


public int getStock() {
	return stock;
}


public Date getCreated_at() {
	return created_at;
}


public Date getUpdated_at() {
	return updated_at;
}


public String getImage() {
	return image;
}

public String getMaterial() {
	return material;
}

public String getSizename() {
	return sizename;
}

public String getCategory() {
	return category;
}




}

