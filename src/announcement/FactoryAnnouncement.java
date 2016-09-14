package announcement;

import interfaces.Announcement;

public class FactoryAnnouncement {

	Announcement announce;

	public FactoryAnnouncement(String type) {
		if (type.equals("job")) {
			announce = new JobAnnouncement();
		} else if (type.equals("event")) {
			announce = new EventAnnouncement();
		} else {
			announce = new NewsAnnouncement();
		}
	}

	public boolean postAnnouncement(String netid, String announcement,
			String type, String email, String link) throws Exception {

		if (announce.postAnnouncement(netid, announcement, type, email, link)) {
			return true;
		}

		return false;

	}

	public boolean editAnnouncement(String id, String netid,
			String announcement, String type, String email, String link)
			throws Exception {

		if (announce.editAnnouncement(id, netid, announcement, type, email,
				link)) {
			return true;
		}

		return false;

	}

	public boolean deleteAnnouncement(String id) throws Exception {

		if (announce.deleteAnnouncement(id)) {
			return true;
		}

		return false;

	}

}
