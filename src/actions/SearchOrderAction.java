package actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.CustomerManager;
import model.EmployeeManager;
import model.OrdersFactManager;
import model.ProductManager;
import model.SupplierManager;
import model.TtimeManager;

import com.opensymphony.xwork2.ActionSupport;

import domain.Customer;
import domain.Employee;
import domain.OrdersFact;
import domain.OrdersFactId;
import domain.Product;
import domain.Supplier;
import domain.Ttime;

public class SearchOrderAction extends ActionSupport {

	private CustomerManager customerManager = new CustomerManager();
	private List<Customer> customerList = customerManager.list();
	private SupplierManager supplierManager = new SupplierManager();
	private List<Supplier> supplierList = supplierManager.list();
	private EmployeeManager employeeManager = new EmployeeManager();
	private List<Employee> employeeList = employeeManager.list();
	private TtimeManager timeManager = new TtimeManager();
	private List<Ttime> ttimeList = timeManager.list();
	private ProductManager productManager = new ProductManager();
	private List<Product> productList = productManager.list();

	private List<String> customerListDropDown;
	private List<String> supplierListDropDown;
	private List<String> employeeListDropDown;
	private List<String> ttimeListDropDown;
	private List<String> productListDropDown;

	private List<OrdersFact> odersFactList;
	private int quantity;
	private double price;

	// method to populate the list	
	public void populateLists() {
		customerListDropDown = new ArrayList<String>();
		supplierListDropDown = new ArrayList<String>();
		employeeListDropDown = new ArrayList<String>();
		productListDropDown = new ArrayList<String>();
		
		for (int i = 0; i < customerList.size(); i++) {
			customerListDropDown.add((customerList.get(i).getCustomerid()) + "-" + customerList.get(i).getCompanyname());
		}
		for (int i = 0; i < supplierList.size(); i++) {
			supplierListDropDown.add((supplierList.get(i).getSupplierid()) + "-" + supplierList.get(i).getCompanyname());
		}

		for (int i = 0; i < employeeList.size(); i++) {
			employeeListDropDown.add((employeeList.get(i).getEmployeeid()) + "-" + employeeList.get(i).getEmployeelastname());
		}

		for (int i = 0; i < productList.size(); i++) {
			productListDropDown.add((productList.get(i).getProductid()) + "-" + productList.get(i).getProductname());
		}
	}

	private static final long serialVersionUID = 9149826260758390091L;

	private OrdersFact fact;
	private OrdersFactId id;

	private String customer;
	private String supplier;
	private String employee;
	private String product;

	private String ordersValue;	
	
	public String getOrdersValue() {
		return ordersValue;
	}
	public void setOrdersValue(String ordersValue) {
		this.ordersValue = ordersValue;
	}

	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	private OrdersFactManager linkController;

	public SearchOrderAction() {
		linkController = new OrdersFactManager();
		populateLists();
		this.odersFactList = linkController.list();
	}

	public String execute() {	
		return SUCCESS;
	}

	public OrdersFact getFact() {
		OrdersFact fact = new OrdersFact();
		if(customer==null)return null;
		int customerid = Integer.parseInt(customer.substring(0, customer.indexOf("-")));
		Customer c = customerManager.load(customerid);
		fact.setCustomer(c);

		int supplierid = Integer.parseInt(supplier.substring(0, supplier.indexOf("-")));
		Supplier s = supplierManager.load(supplierid);
		fact.setSupplier(s);

		int productid = Integer.parseInt(product.substring(0, product.indexOf("-")));
		Product p = productManager.load(productid);
		fact.setProduct(p);

		int employeeid = Integer.parseInt(employee.substring(0, employee.indexOf("-")));
		Employee e = employeeManager.load(employeeid);
		fact.setEmployee(e);

		fact.setQuantity(quantity);
		fact.setPrice(new BigDecimal(price + ""));

		OrdersFactId fid = new OrdersFactId(productid, customerid, employeeid, supplierid);
		fact.setId(fid);
		return fact;
	}

	public String search() {		 
		OrdersFact fact = getFact();
		this.odersFactList = linkController.search(fact);
		return SUCCESS;
	}

	public List<String> getCustomerListDropDown() {
		return customerListDropDown;
	}
	 
	public List<String> getSupplierListDropDown() {
		return supplierListDropDown;
	}

	public List<String> getEmployeeListDropDown() {
		return employeeListDropDown;
	} 

	public List<String> getProductListDropDown() {
		return productListDropDown;
	}	 
	public List<OrdersFact> getOdersFactList() {
		return odersFactList;
	}

	public void setOdersFactList(List<OrdersFact> odersFactList) {
		this.odersFactList = odersFactList;
	}

	public void setFact(OrdersFact fact) {
		this.fact = fact;
	}
	public OrdersFactId getId() {
		return id;
	}	
	public void setId(OrdersFactId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}	 
}
