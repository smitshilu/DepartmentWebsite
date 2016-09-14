package model;

public class ReserveResourceModel {

	private String id;
	private String netid;
	private String resourcename;
	private String reservationdate;
	private String reservationtime;

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

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}

	public String getReservationtime() {
		return reservationtime;
	}

	public void setReservationtime(String reservationtime) {
		this.reservationtime = reservationtime;
	}

	public ReserveResourceModel(String id, String netid, String resourcename,
			String reservationdate, String reservationtime) {
		super();
		this.id = id;
		this.netid = netid;
		this.resourcename = resourcename;
		this.reservationdate = reservationdate;
		this.reservationtime = reservationtime;
	}

}
