package alumni;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;

/**
 * Servlet implementation class DeleteAlumniInfo
 */
@WebServlet("/DeleteAlumniInfo")
public class DeleteAlumniInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAlumniInfo() {
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

		String alumniid = request.getParameter("alumniid");

		DAO dao = new DAO();
		try {
			if (dao.deleteAlumniInfo(alumniid)) {
				response.sendRedirect("viewAlumniInfo.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
