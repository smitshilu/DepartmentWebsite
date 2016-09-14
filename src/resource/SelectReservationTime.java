package resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReserveResourceModel;
import database.DAO;

/**
 * Servlet implementation class SelectReservationTime
 */
@WebServlet("/SelectReservationTime")
public class SelectReservationTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectReservationTime() {
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
		String resourcedate = request.getParameter("resourcedate");

		

		DAO dao = new DAO();
		ArrayList<ReserveResourceModel> reserve = dao
				.getResourceReservationDetails(resourcename, resourcedate);

		ArrayList<String> timeslot = new ArrayList<>();

		for (int i = 7; i <= 16; i++) {
			timeslot.add(i + " - " + (i + 1));
		}

		for (int j = 0; j < timeslot.size(); j++) {
			for (int i = 0; i < reserve.size(); i++) {
				if ((timeslot.get(j)).equals((reserve.get(i)
						.getReservationtime()))) {
					timeslot.remove(j);
				}
			}
		}

		String[] timeslots = new String[timeslot.size()];
		for (int i = 0; i < timeslot.size(); i++) {
			timeslots[i] = timeslot.get(i);
		}

		request.setAttribute("resourcename", resourcename);
		request.setAttribute("resourcetime", timeslots);
		request.setAttribute("resourcedate", resourcedate);
		RequestDispatcher rd = request.getRequestDispatcher("/SelectTime.jsp");
		rd.forward(request, response);

	}

}
