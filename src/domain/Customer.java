package domain;

public class Customer implements java.io.Serializable {

	private Integer customerid;
	private String companyname;
	private String city;
	private String country;

	public Customer() {
	}

	public Customer(String companyname, String city, String country) {
		this.companyname = companyname;
		this.city = city;
		this.country = country;
	}

	public Integer getCustomerid() {
		return this.customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCompanyname() {
		return this.companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
