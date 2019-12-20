package actions;

import java.util.List;

import model.CustomerManager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import domain.Customer;

public class CustomerAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	private Customer customer;
	private List<Customer> customerList;
	private Integer id;

	private CustomerManager linkController;

	public CustomerAction() {
		linkController = new CustomerManager();
	}

	public String execute() {
		this.customerList = linkController.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getCustomer());
		try {
			linkController.add(getCustomer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.customerList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		linkController.delete(getId());
		return SUCCESS;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void validate() {
		if (customer == null) {
			addActionMessage("Enter customer details");
			return;
		}
		if (Util.isNullorEmpty(customer.getCompanyname())) {
			addFieldError("customer.companyname", "The comapny name is required");
		}
		if (Util.isNullorEmpty(customer.getCity())) {
			addFieldError("customer.city", "The customer city is required");
		}
		if (Util.isNullorEmpty(customer.getCity())) {
			addFieldError("customer.country", "The customer country is required");
		}
	}
}
