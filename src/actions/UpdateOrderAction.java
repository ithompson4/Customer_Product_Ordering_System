package actions;

import java.math.BigDecimal;
import java.util.Map;

import model.CustomerManager;
import model.EmployeeManager;
import model.OrdersFactManager;
import model.ProductManager;
import model.SupplierManager;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import domain.OrdersFact;
import domain.OrdersFactId;

public class UpdateOrderAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 9149826260758390091L;
	private SessionMap<String, Object> sessionMap;

	// getters and setters
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

	private String ordersValue;
	private String customer;
	private String supplier;
	private String employee;
	private String product;
	private int quantity;
	private BigDecimal price;

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

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getOrdersValue() {
		return ordersValue;
	}
	public void setOrdersValue(String ordersValue) {
		this.ordersValue = ordersValue;
	}

	public OrdersFact getFact() {
		return fact;
	}
	public void setFact(OrdersFact fact) {
		this.fact = fact;
	}

	private CustomerManager customerManager = new CustomerManager();
	private SupplierManager supplierManager = new SupplierManager();
	private EmployeeManager employeeManager = new EmployeeManager();
	private ProductManager productManager = new ProductManager();
	private OrdersFact fact;

	public UpdateOrderAction() {

	}

	public String populate() {
		if (ordersValue != null) {
			String data[] = ordersValue.split("-");
			fact = loadFact(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[3]), Integer.parseInt(data[2]));
			customer = fact.getCustomerDetail();
			supplier = fact.getSupplierDetail();
			employee = fact.getEmployeeDetail();
			product = fact.getProductDetail();
			quantity = fact.getQuantity();
			price = fact.getPrice();

			sessionMap.put("fact", fact);
		}
		return SUCCESS;
	}

	private String msg = "";

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String updateValues() {
		fact = (OrdersFact) sessionMap.get("fact");
		if (fact != null) {
			fact.setQuantity(quantity);
			fact.setPrice(price);
			OrdersFactManager mngr = new OrdersFactManager();
			try {
				mngr.update(fact);
				msg = "Order updated";
			} catch (Exception e) {
				msg = e.toString();
			}
		}
		return SUCCESS;
	}

	public OrdersFact loadFact(int customerid, int supplierid, int productid, int employeeid) {

		OrdersFactManager mngr = new OrdersFactManager();
		OrdersFactId fid = new OrdersFactId(productid, customerid, employeeid, supplierid);
		OrdersFact fact = mngr.load(fid);

		return fact;
	}

	public void validate() {
		fact = getFact();
		if (fact == null) {
			addActionMessage("Enter orders details");
			return;
		}
		if (fact.getPrice() == null) {
			addFieldError("price", "The price is required");
		}
		if (fact.getQuantity() == 0) {
			addFieldError("quantity", "The quantity is required");
		}
	}
}
