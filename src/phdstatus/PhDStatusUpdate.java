package phdstatus;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;

/**
 * Servlet implementation class PhDStatusUpdate
 */
@WebServlet("/PhDStatusUpdate")
public class PhDStatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhDStatusUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String netidstudent = request.getParameter("netidstudent");
		String numberofsemester = request.getParameter("numberofsemester");
		String status = request.getParameter("status");
		
		System.out.println("here" +netidstudent);
		
		DAO dao = new DAO();
		try {
			if(dao.updateStudentStatus(netidstudent, numberofsemester, status)) {
				response.sendRedirect("EditStatus.jsp?netid="+netidstudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
