package discussionboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostContent
 */
@WebServlet("/PostContent")
public class PostContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String netid = (String) session.getAttribute("netid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String parentid = request.getParameter("pid");
		String datetime = request.getParameter("date");
		String id = datetime.replace(" ", "").replace("-", "").replace("/", "").replace(":", "");

		FactoryDiscussionBoard fdb = new FactoryDiscussionBoard();

		try {
			if(fdb.postContent(id, netid, title, content, parentid, datetime)) {
				response.sendRedirect("DiscussionBoard.jsp");
			}
			else {
				response.sendRedirect("DiscussionBoard.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

}
