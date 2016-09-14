package model;

public class ExamDetailsModel {
	
	private String ID;
	private String examname;
	private String examdate;
	private String details;
	private String registration;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getExamdate() {
		return examdate;
	}
	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public ExamDetailsModel(String iD, String examname, String examdate,
			String details, String registration) {
		super();
		ID = iD;
		this.examname = examname;
		this.examdate = examdate;
		this.details = details;
		this.registration = registration;
	}
	
}
