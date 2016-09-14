package course;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;

/**
 * Servlet implementation class CreateCourse
 */
@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCourse() {
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
		String coursenumber = request.getParameter("coursenumber");
		String coursename = request.getParameter("coursename");
		String instructor = "null";
		String courseinfo = "null";
		String term = request.getParameter("term");

		DAO dao = new DAO();
		try {
			if (!dao.checkCourseIDAvailble(coursenumber, term)) {
				if (dao.createCourse(coursenumber, coursename, instructor,
						"null", courseinfo, term)) {
					response.sendRedirect("ViewCourses.jsp");
				}
			} else {
				request.setAttribute("error_course",
						"Course with this ID already Exist");
				RequestDispatcher rd = request
						.getRequestDispatcher("/ViewCourses.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
