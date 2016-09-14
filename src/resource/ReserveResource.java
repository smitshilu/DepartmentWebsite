package resource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAO;

/**
 * Servlet implementation class ReserveResource
 */
@WebServlet("/ReserveResource")
public class ReserveResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveResource() {
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
		
		String resourcename = request.getParameter("reourcename");
		String reourcedate = request.getParameter("reourcedate");
		String resourcetime = request.getParameter("resourcetime");
		String netid = (String) session.getAttribute("netid");
		
		Date dt = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ID = (sdf.format(dt)).replace("-", "").replace(" ", "").replace(":", "");
		
		DAO dao = new DAO();
		if(dao.reserveResource(ID, netid, resourcename, reourcedate, resourcetime)) {
			response.sendRedirect("ReserveResource.jsp");
		}
		
		
	}

}
