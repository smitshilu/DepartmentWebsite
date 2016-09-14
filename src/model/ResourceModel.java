package model;

public class ResourceModel {

	private String resourcename;
	private String resourcetype;
	private String resourcedetails;

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getResourcedetails() {
		return resourcedetails;
	}

	public void setResourcedetails(String resourcedetails) {
		this.resourcedetails = resourcedetails;
	}

	public ResourceModel(String resourcename, String resourcetype,
			String resourcedetails) {
		super();
		this.resourcename = resourcename;
		this.resourcetype = resourcetype;
		this.resourcedetails = resourcedetails;
	}

}
