package actions;

import java.util.List;

import model.TtimeManager;

import com.opensymphony.xwork2.ActionSupport;

import domain.Ttime;

public class TtimeAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	private Ttime ttime;
	private List<Ttime> ttimeList;
	private Integer id;

	private TtimeManager linkController;

	public TtimeAction() {
		linkController = new TtimeManager();
	}

	public String execute() {
		this.ttimeList = linkController.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getTtime());
		try {
			linkController.add();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.ttimeList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		linkController.delete(getId());
		return SUCCESS;
	}

	public Ttime getTtime() {
		return ttime;
	}
	public void setTtime(Ttime ttime) {
		this.ttime = ttime;
	}

	public List<Ttime> getTtimeList() {
		return ttimeList;
	}
	public void setTtimeList(List<Ttime> ttimeList) {
		this.ttimeList = ttimeList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	 
}
