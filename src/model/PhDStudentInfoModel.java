package model;

public class PhDStudentInfoModel {

	private String netid;
	private String fname;
	private String lname;

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public PhDStudentInfoModel(String netid, String fname, String lname) {
		super();
		this.netid = netid;
		this.fname = fname;
		this.lname = lname;
	}

}
