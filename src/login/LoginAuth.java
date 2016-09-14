package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAO;

/**
 * Servlet implementation class LoginAuth
 */
@WebServlet("/LoginAuth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAuth() {
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
		String password = request.getParameter("password");

		DAO dao = new DAO();
		LoginCheck lc = new LoginCheck(netid);
		int type = 0;

		try {
			type = lc.LoginDetailsCheck(netid, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (type == 0) {
			request.setAttribute("login_error", "Invalid Details");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("netid", netid);
			session.setAttribute("type", Integer.toString(type));
			if (type == 1) {
				String program = dao.getProgram(netid);
				session.setAttribute("program", program);
				if (program.equals("PhD")) {
					session.setAttribute("phd_status", dao.getPhdStatus(netid));
				}
			}
			response.sendRedirect("HomePage.jsp");

		}

	}

}
