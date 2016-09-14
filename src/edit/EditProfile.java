package edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAO;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfile() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		String role = (String) session.getAttribute("type");
		String major = request.getParameter("major");
		String advisorname = request.getParameter("advisorname");
		String advisornumber = request.getParameter("advisornumber");
		String advisoremail = request.getParameter("advisoremail");
		String year = "null";
		String program = "null";
		if (role.equals("1")) {
			year = request.getParameter("year");
			program = request.getParameter("program");
		}

		DAO dao = new DAO();

		try {
			if (role.equals("1")) {
				if (dao.updateStudentProfile(netid, password, fname, lname,
						year, program, major, advisorname, advisornumber, advisoremail)) {
					response.sendRedirect("EditProfile.jsp");
				}
			} else if (role.equals("2")) {
				if (dao.updateFacultyProfile(netid, password, fname, lname)) {
					response.sendRedirect("EditProfile.jsp");
				}
			} else {
				if (dao.updateStaffProfile(netid, password, fname, lname)) {
					response.sendRedirect("EditProfile.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
