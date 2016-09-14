package model;

public class AlumniInfoModel {
	private String ID;
	private String name;
	private String info;
	private String url;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public AlumniInfoModel(String iD, String name, String info, String url) {
		super();
		ID = iD;
		this.name = name;
		this.info = info;
		this.url = url;
	}
	
}
