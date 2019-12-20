package actions;

import java.util.List;

import model.EmployeeManager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import domain.Employee;

public class EmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	private Employee employee;
	private List<Employee> employeeList;
	private Integer id;

	private EmployeeManager linkController;

	public EmployeeAction() {
		linkController = new EmployeeManager();
	}

	public String execute() {
		this.employeeList = linkController.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getEmployee());
		try {
			linkController.add(getEmployee());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.employeeList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		linkController.delete(getId());
		return SUCCESS;
	}

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void validate() {
		if (employee == null) {
			addActionMessage("Enter employee details");
			return;
		}
		if (Util.isNullorEmpty(employee.getEmployeelastname())) {
			addFieldError("employee.employeelastname", "The employee last name is required");
		}
		if (Util.isNullorEmpty(employee.getMgrlastname())) {
			addFieldError("employee.mgrlastname", "The manager's last name is required");
		}
	}
}
