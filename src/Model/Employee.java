package Model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

	private Date hireDate;
	private String salary;
	private String rank;
	private String workingHours;
	
	Employee(){
		super();
		hireDate=null;
		salary=null;
		rank=null;
		workingHours=null;
	}
	
	public Employee(String n, String a, String g, Address add,String cn,Date hD, String sal, String r, String wH){
		super(n,a,g,add,cn);
		hireDate=hD;
		salary=sal;
		rank=r;
		workingHours=wH;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	
	
	
	
}
