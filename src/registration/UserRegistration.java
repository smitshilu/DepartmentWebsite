package registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
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

		String netid = request.getParameter("netid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String major = request.getParameter("major");
		String email = request.getParameter("email");
		String year = "null";
		String program = "null";
		if (role.equals("student")) {
			year = request.getParameter("year");
			program = request.getParameter("program");
		}

		DAO dao = new DAO();

		if (!dao.checkNetIDAvailble(netid)) {
			FactoryRegistration fr = new FactoryRegistration(role);
			try {
				if (fr.addUser(netid, password, role, fname, lname, email, year,
						program, major)) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("Registration.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Registration.jsp");
		}
	}

}
