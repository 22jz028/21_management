package model;

import java.io.Serializable;

public class stockRequest implements Serializable{
    private int stock;
    private int id;

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public stockRequest(){
        this(0, 0);
    }
    public stockRequest(int stock, int id){
        super();
        this.stock = stock;
        this.id = id;
    }
}
