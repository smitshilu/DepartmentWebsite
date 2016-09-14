package interfaces;

public interface DiscussionBoard {
	public boolean postDiscussionBoard(String id, String netid, String title,
			String content, String parentid, String datetime) throws Exception;

	public boolean deleteDiscussionBoard(String id) throws Exception;
}
