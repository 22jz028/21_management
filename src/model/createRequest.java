package model;

import java.io.Serializable;

public class createRequest implements Serializable{
    private String product_name;
    private int price;
    private String description;
    private int stock;
    private String image;
    private String material;
    private String sizename; 
    private String category;
    
    
    public String getProduct_name(){
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public String getSizename(){
        return sizename;
    }
    public void setSizename(String sizename){
        this.sizename = sizename;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public createRequest(){
        this("", 0, "", 0, "", "", "", "");
    }
    public createRequest(String product_name, int price, String description, int stock, String image, String material, String sizename, String category){
        super();
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.image = image;
        this.material = material;
        this.sizename = sizename;
        this.category = category;
    }


}
