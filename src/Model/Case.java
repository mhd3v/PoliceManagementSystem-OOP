package Model;

import java.io.Serializable;

public class Case implements Serializable {

	private String name;
	private String gender;
	private String id;
	private Address location;
	private Time t;
	private Date d;
	private String Description;
	
	Case(){
		name = null;
		gender = null;
		id=null;
		location=null;
		t=null;
		d=null;
		Description=null;
	}
	
	public Case(String n, String g,String i, Address add, Time time, Date d1, String d){
		name = n;
		gender = g;
		id=i;
		location=add;
		t=time;
		this.d = d1;
		Description=d;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public Time getT() {
		return t;
	}

	public void setT(Time t) {
		this.t = t;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
