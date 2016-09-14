package exam;

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
 * Servlet implementation class PostExamDetails
 */
@WebServlet("/PostExamDetails")
public class PostExamDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostExamDetails() {
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
		String examname = request.getParameter("examname");
		String examdate = request.getParameter("examdate");
		String details = request.getParameter("details");
		
		DAO dao = new DAO();
		HttpSession session = request.getSession();
		
		try {
			if(dao.postExamDetails((String) session.getAttribute("netid"), examname, examdate, details)) {
				response.sendRedirect("Exam.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
