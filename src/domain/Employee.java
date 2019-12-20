package domain;

public class Employee implements java.io.Serializable {

	private Integer employeeid;
	private String employeelastname;
	private String mgrlastname;

	public Employee() {
	}

	public Employee(String employeelastname, String mgrlastname) {
		this.employeelastname = employeelastname;
		this.mgrlastname = mgrlastname;

	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeelastname() {
		return this.employeelastname;
	}
	public void setEmployeelastname(String employeelastname) {
		this.employeelastname = employeelastname;
	}

	public String getMgrlastname() {
		return this.mgrlastname;
	}
	public void setMgrlastname(String mgrlastname) {
		this.mgrlastname = mgrlastname;
	}
}
