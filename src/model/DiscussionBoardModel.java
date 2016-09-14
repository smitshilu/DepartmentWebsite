package model;

public class DiscussionBoardModel {

	private String id;
	private String netid;
	private String title;
	private String content;
	private String parentid;
	private String datetime;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public DiscussionBoardModel(String id, String netid, String title,
			String content, String parentid, String datetime) {
		super();
		this.id = id;
		this.netid = netid;
		this.title = title;
		this.content = content;
		this.parentid = parentid;
		this.datetime = datetime;
	}

}
