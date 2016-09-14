package model;

public class AnnouncementModel {

	private String id;
	private String netid;
	private String announcement;
	private String type;
	private String email;
	private String link;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public AnnouncementModel(String id, String netid, String announcement,
			String type, String email, String link, String date) {
		super();
		this.id = id;
		this.netid = netid;
		this.announcement = announcement;
		this.type = type;
		this.email = email;
		this.link = link;
		this.date = date;
	}

}
