package discussionboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteContent
 */
@WebServlet("/DeleteContent")
public class DeleteContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteContent() {
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
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String parentid = request.getParameter("pid");

		FactoryDiscussionBoard fdb = new FactoryDiscussionBoard();

		try {
			if (fdb.deleteContent(id, parentid)) {
				response.sendRedirect("DiscussionBoard.jsp");
			} else {
				response.sendRedirect("DiscussionBoard.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
