package model;

public class PhDStudentStatusModel {

	private String netid;
	private String numberofsemester;
	private String status;

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getNumberofsemester() {
		return numberofsemester;
	}

	public void setNumberofsemester(String numberofsemester) {
		this.numberofsemester = numberofsemester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PhDStudentStatusModel(String netid, String numberofsemester,
			String status) {
		super();
		this.netid = netid;
		this.numberofsemester = numberofsemester;
		this.status = status;
	}

}
