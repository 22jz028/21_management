package model;

import java.io.Serializable;

public class deletRequest implements Serializable{
    private int id;
    
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    public deletRequest(){
        this(0);
    }
    public deletRequest(int id){
        super();
        this.id = id;
        
    }


}
