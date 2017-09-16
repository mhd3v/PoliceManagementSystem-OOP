package Model;

import java.io.Serializable;

public class Address implements Serializable {

	private String houseNo;
	private String streetNo;
	private String town;
	private String city;
	
	Address(){
		houseNo=null;
		streetNo=null;
		town=null;
		city=null;	
	}
	
	public Address(String h, String s, String t, String c){
		houseNo=h;
		streetNo=s;
		town=t;
		city=c;	
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
