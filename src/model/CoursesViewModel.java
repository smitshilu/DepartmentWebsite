package model;

public class CoursesViewModel {

	private String coursenumber;
	private String coursename;
	private String instructor;
	private String netid;
	private String courseinfo;
	private String term;
	public String getCoursenumber() {
		return coursenumber;
	}
	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getCourseinfo() {
		return courseinfo;
	}
	public void setCourseinfo(String courseinfo) {
		this.courseinfo = courseinfo;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public CoursesViewModel(String coursenumber, String coursename,
			String instructor, String netid, String courseinfo, String term) {
		super();
		this.coursenumber = coursenumber;
		this.coursename = coursename;
		this.instructor = instructor;
		this.netid = netid;
		this.courseinfo = courseinfo;
		this.term = term;
	}

}
