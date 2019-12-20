package domain;

public class Product implements java.io.Serializable {

	private Integer productid;
	private String productname;
	private String productcategory;

	public Product() {
	}

	public Product(String productname, String productcategory) {
		this.productname = productname;
		this.productcategory = productcategory;
	}

	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return this.productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductcategory() {
		return this.productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
}
