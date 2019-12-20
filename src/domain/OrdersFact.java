package domain;

import java.math.BigDecimal;

import model.CustomerManager;
import model.EmployeeManager;
import model.ProductManager;
import model.SupplierManager;

public class OrdersFact implements java.io.Serializable {

	private OrdersFactId id;
	private Customer customer;
	private Supplier supplier;
	private Ttime ttime;
	private Employee employee;
	private Product product;
	private BigDecimal price;
	private Integer quantity;

	public OrdersFact() {

	}

	public OrdersFact(OrdersFactId id, Customer customer, Supplier supplier, Ttime ttime, Employee employee, Product product) {
		this.id = id;
		this.customer = customer;
		this.supplier = supplier;
		this.ttime = ttime;
		this.employee = employee;
		this.product = product;
	}

	public OrdersFact(OrdersFactId id, Customer customer, Supplier supplier, Ttime ttime, Employee employee, Product product, BigDecimal price, Integer quantity) {
		this.id = id;
		this.customer = customer;
		this.supplier = supplier;
		this.ttime = ttime;
		this.employee = employee;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public OrdersFactId getId() {
		return this.id;
	}
	public void setId(OrdersFactId id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Ttime getTtime() {
		return this.ttime;
	}
	public void setTtime(Ttime ttime) {
		this.ttime = ttime;
	}

	public Employee getEmployee() {
		return this.employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Product getProduct() {
		return this.product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return this.price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCustomerDetail() {
		if (customer == null)
			return "";
		CustomerManager customerManager = new CustomerManager();
		this.customer = customerManager.load(customer.getCustomerid());
		
		return customer.getCustomerid() + "-" + customer.getCompanyname();
	}

	public String getSupplierDetail() {
		if (supplier == null)
			return "";
		SupplierManager supplierManager = new SupplierManager();
		this.supplier = supplierManager.load(supplier.getSupplierid());
		
		return supplier.getSupplierid() + "-" + supplier.getCompanyname();
	}

	public String getEmployeeDetail() {
		if (employee == null)
			return "";
		EmployeeManager employeeManager = new EmployeeManager();
		this.employee = employeeManager.load(employee.getEmployeeid());
		
		return employee.getEmployeeid() + "-" + employee.getEmployeelastname();
	}

	public String getProductDetail() {
		if (product == null)
			return "";

		ProductManager productManager = new ProductManager();
		this.product = productManager.load(product.getProductid());
		
		return product.getProductid() + "-" + product.getProductname();
	}

	public String getString() {
		return id.getCustomerid() + "-" + id.getSupplierid() + "-" + id.getEmployeeid() + "-" + id.getProductid();
	}
}
