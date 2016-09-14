package interfaces;

public interface Announcement {

	public boolean postAnnouncement(String netid, String announcement, String type, String email, String link) throws Exception;
	public boolean editAnnouncement(String id, String netid, String announcement, String type, String email, String link) throws Exception;
	public boolean deleteAnnouncement(String id) throws Exception;
}
