package domain;

public class Supplier implements java.io.Serializable {

	private Integer supplierid;
	private String companyname;
	private String country;

	public Supplier() {
	}

	public Supplier(String companyname, String country) {
		this.companyname = companyname;
		this.country = country;
	}

	public Integer getSupplierid() {
		return this.supplierid;
	}
	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}

	public String getCompanyname() {
		return this.companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
