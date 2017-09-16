package Model;

import java.io.Serializable;

public class Criminal extends Person implements Serializable {


private String servingTime;

	public Criminal(){
		super();
		servingTime=null;
	}
	
	public Criminal(String n, String a, String g, Address add, String cnic, String st){
		super(n,a,g,add,cnic);
		servingTime=st;
	}


	public String getServingTime() {
		return servingTime;
	}

	public void setServingTime(String servingTime) {
		this.servingTime = servingTime;
	}
		
}
