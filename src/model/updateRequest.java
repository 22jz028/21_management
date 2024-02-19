package model;

import java.io.Serializable;

public class updateRequest implements Serializable {
    private int id;
    private String product_name;
    private int price;
    private String description;
    private String image;
    private String material;
    private String sizename;  
    private String category;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getProduct_name(){
        return product_name;
    }
    public void setproduct_name(String product_name){
        this.product_name = product_name;
    }
    public int getPrice(){
        return price;
    }
    public void price(int price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void description(String description){
        this.description = description;
    }
    public String getImage(){
        return image;
    }
    public void image(String image){
        this.image = image;
    }
    public String getMaterial(){
        return material;
    }
    public void material(String material){
        this.material = material;
    }
    public String getSizename(){
        return sizename;
    }
    public void sizename(String sizename){
        this.sizename = sizename;
    }
    public String getCategory() {
    	return category;
    }
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public updateRequest(){
        this(0, "", 0, "", "", "", "", "");
    }
    public updateRequest(int id, String product_name, int price, String description, String image, String material, String sizename, String category){
        super();
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.material = material;
        this.sizename = sizename;
        this.category = category;
    }
}
