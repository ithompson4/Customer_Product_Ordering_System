package domain;

import java.util.Date;

public class Ttime implements java.io.Serializable {

	private Integer timeid;
	private Date tdate;

	public Ttime() {
		tdate = new Date();
	}

	public Ttime(Date tdate) {
		this.tdate = tdate;
	}

	public Integer getTimeid() {
		return this.timeid;
	}
	public void setTimeid(Integer timeid) {
		this.timeid = timeid;
	}

	public Date getTdate() {
		return this.tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
}
