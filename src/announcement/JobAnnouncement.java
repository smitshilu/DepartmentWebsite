package announcement;

import java.text.SimpleDateFormat;
import java.util.Date;

import database.DAO;
import interfaces.Announcement;

public class JobAnnouncement implements Announcement {

	@Override
	public boolean postAnnouncement(String netid, String announcement,
			String type, String email, String link) throws Exception {

		Date dt = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datenow = sdf.format(dt);

		String id = datenow.replace("-", "").replace(":", "").replace(" ", "");

		DAO dao = new DAO();

		if (dao.addJobAnnouncement(id, netid, announcement, type, email, link,
				datenow)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean editAnnouncement(String id, String netid,
			String announcement, String type, String email, String link)
			throws Exception {
		Date dt = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datenow = sdf.format(dt);

		DAO dao = new DAO();

		if (dao.editJobAnnouncement(id, netid, announcement, type, email, link,
				datenow)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteAnnouncement(String id) throws Exception {

		DAO dao = new DAO();

		if (dao.deleteAnnouncement(id)) {
			return true;
		}

		return false;
	}

}
