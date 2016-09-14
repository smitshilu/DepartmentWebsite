package resource;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;

/**
 * Servlet implementation class CreateResource
 */
@WebServlet("/CreateResource")
public class CreateResource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateResource() {
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

		String resourcename = request.getParameter("resourcename");
		String resourcetype = request.getParameter("resourcetype");
		String resourcedetails = request.getParameter("resourcedetails");

		DAO dao = new DAO();

		if (!dao.checkResourceNameAvailble(resourcename)) {
			if (dao.createResource(resourcename, resourcetype, resourcedetails)) {
				response.sendRedirect("CreateResource.jsp");
			}
		} else {
			request.setAttribute("error_resource",
					"This resource already exist");
			RequestDispatcher rd = request
					.getRequestDispatcher("/CreateResource.jsp");
			rd.forward(request, response);
		}

	}

}
