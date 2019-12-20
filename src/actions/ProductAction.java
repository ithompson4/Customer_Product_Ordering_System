package actions;

import java.util.List;

import model.ProductManager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	private Product product;
	private List<Product> productList;
	private Integer id;

	private ProductManager linkController;

	public ProductAction() {
		linkController = new ProductManager();
	}

	public String execute() {
		this.productList = linkController.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getProduct());
		try {
			linkController.add(getProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.productList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		linkController.delete(getId());
		return SUCCESS;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void validate() {
		if (product == null) {
			addActionMessage("Enter product details");
			return;
		}
		if (Util.isNullorEmpty(product.getProductname())) {
			addFieldError("product.productname", "The product name is required");
		}
		if (Util.isNullorEmpty(product.getProductcategory())) {
			addFieldError("product.productcategory", "The Product Category is required");
		}
	}
}
