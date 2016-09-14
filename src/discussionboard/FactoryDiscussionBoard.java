package discussionboard;

import interfaces.DiscussionBoard;

public class FactoryDiscussionBoard {

	public boolean postContent(String id, String netid, String title,
			String content, String parentid, String datetime) throws Exception {

		if (parentid.equals("0")) {
			DiscussionBoard db = new Question();
			return db.postDiscussionBoard(id, netid, title, content, parentid,
					datetime);
		} else {
			DiscussionBoard db = new Answer();
			return db.postDiscussionBoard(id, netid, title, content, parentid,
					datetime);
		}
	}

	public boolean deleteContent(String id, String parentid) throws Exception {
		if (parentid.equals("0")) {
			DiscussionBoard db = new Question();
			return db.deleteDiscussionBoard(id);
		} else {
			DiscussionBoard db = new Answer();
			return db.deleteDiscussionBoard(id);
		}
	}

}
