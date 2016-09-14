package model;

public class GetProfileModel {

	private String netid;
	private String fname;
	private String lname;
	private String yearofadmission;
	private String major;
	private String program;
	private String advisorname;
	private String advisornumber;
	private String advisoremail;

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

	public String getYearofadmission() {
		return yearofadmission;
	}

	public void setYearofadmission(String yearofadmission) {
		this.yearofadmission = yearofadmission;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getAdvisorname() {
		return advisorname;
	}

	public void setAdvisorname(String advisorname) {
		this.advisorname = advisorname;
	}

	public String getAdvisornumber() {
		return advisornumber;
	}

	public void setAdvisornumber(String advisornumber) {
		this.advisornumber = advisornumber;
	}

	public String getAdvisoremail() {
		return advisoremail;
	}

	public void setAdvisoremail(String advisoremail) {
		this.advisoremail = advisoremail;
	}

	public GetProfileModel(String netid, String fname, String lname,
			String yearofadmission, String major, String program,
			String advisorname, String advisornumber, String advisoremail) {
		super();
		this.netid = netid;
		this.fname = fname;
		this.lname = lname;
		this.yearofadmission = yearofadmission;
		this.major = major;
		this.program = program;
		this.advisorname = advisorname;
		this.advisornumber = advisornumber;
		this.advisoremail = advisoremail;
	}

	public GetProfileModel(String netid, String fname, String lname,
			String yearofadmission, String major, String program) {
		super();
		this.netid = netid;
		this.fname = fname;
		this.lname = lname;
		this.yearofadmission = yearofadmission;
		this.major = major;
		this.program = program;
	}

}
