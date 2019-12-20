package domain;

public class OrdersFactId implements java.io.Serializable {

	private int productid;
	private int customerid;
	private int employeeid;
	private int supplierid;

	public OrdersFactId() {
	}

	public OrdersFactId(int productid, int customerid, int employeeid, int supplierid) {
		this.productid = productid;
		this.customerid = customerid;
		this.employeeid = employeeid;
		this.supplierid = supplierid;
	}

	public int getProductid() {
		return this.productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCustomerid() {
		return this.customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getEmployeeid() {
		return this.employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getSupplierid() {
		return this.supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdersFactId))
			return false;
		OrdersFactId castOther = (OrdersFactId) other;

		return (this.getProductid() == castOther.getProductid()) && (this.getCustomerid() == castOther.getCustomerid())
				&& (this.getEmployeeid() == castOther.getEmployeeid()) && (this.getSupplierid() == castOther.getSupplierid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductid();
		result = 37 * result + this.getCustomerid();
		result = 37 * result + this.getEmployeeid();
		result = 37 * result + this.getSupplierid();
		return result;
	}
}
