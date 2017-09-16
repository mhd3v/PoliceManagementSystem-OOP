package Model;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private String age;
	private String gender;
	private Address address;
	private String cnic;
	
	Person(){
		name=null;
		age=null;
		gender=null;
		address=null;
		cnic=null;
	}
	
	Person(String n, String a, String g, Address add,String cn){
		name=n;
		age=a;
		gender=g;
		address=add;
		cnic=cn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	
	
	
	
}

