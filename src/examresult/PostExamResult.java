package examresult;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAO;

/**
 * Servlet implementation class PostExamResult
 */
@WebServlet("/PostExamResult")
public class PostExamResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostExamResult() {
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

		String examname = request.getParameter("examname");
		String result = request.getParameter("result");
		String netid = (String) session.getAttribute("netid");

		DAO dao = new DAO();
		try {
			if (dao.postExamResult(examname, result, netid)) {
				response.sendRedirect("PostResult.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
