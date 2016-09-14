package discussionboard;

import database.DAO;
import interfaces.DiscussionBoard;

public class Answer implements DiscussionBoard {

	DAO dao = new DAO();

	@Override
	public boolean postDiscussionBoard(String id, String netid, String title,
			String content, String parentid, String datetime) throws Exception {

		return dao.postContent(id, netid, title, content, parentid, datetime);

	}

	@Override
	public boolean deleteDiscussionBoard(String id) throws Exception {
		return dao.deleteContent(id);
	}

}
