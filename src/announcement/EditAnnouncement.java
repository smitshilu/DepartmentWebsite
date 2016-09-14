package announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditAnnouncement
 */
@WebServlet("/EditAnnouncement")
public class EditAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnnouncement() {
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
		HttpSession session = request.getSession();

		String netid = (String) session.getAttribute("netid");
		String id = request.getParameter("id");
		String announcement = request.getParameter("announcement");
		String type = request.getParameter("type");
		String email = request.getParameter("email");
		String link = request.getParameter("link");
		
		FactoryAnnouncement fa = new FactoryAnnouncement(type);
		
		try {
			if(fa.editAnnouncement(id, netid, announcement, type, email, link)) {
				response.sendRedirect("ViewAnnouncement.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
