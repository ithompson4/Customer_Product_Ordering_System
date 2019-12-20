package actions;

import java.util.List;

import model.SupplierManager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import domain.Supplier;

public class SupplierAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	private Supplier supplier;
	private List<Supplier> supplierList;
	private Integer id;

	private SupplierManager linkController;

	public SupplierAction() {
		linkController = new SupplierManager();
	}

	public String execute() {
		this.supplierList = linkController.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getSupplier());
		try {
			linkController.add(getSupplier());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.supplierList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		linkController.delete(getId());
		return SUCCESS;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}
	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void validate() {
		if (supplier == null) {
			addActionMessage("Enter supplier details");
			return;
		}
		if (Util.isNullorEmpty(supplier.getCompanyname())) {
			addFieldError("supplier.companyname", "The comapny name is required");
		}
		if (Util.isNullorEmpty(supplier.getCountry())) {
			addFieldError("supplier.country", "The supplier country is required");
		}
	}
}
