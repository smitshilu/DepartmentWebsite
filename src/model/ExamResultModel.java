package model;

public class ExamResultModel {

	private String id;
	private String examname;
	private String result;
	private String netid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public ExamResultModel(String id, String examname, String result,
			String netid) {
		super();
		this.id = id;
		this.examname = examname;
		this.result = result;
		this.netid = netid;
	}

}
