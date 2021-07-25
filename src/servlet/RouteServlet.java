package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RouteDAO;
import dao.UnitDAO;
import model.BusRouteDetails;
import model.BusUnitManagerDetails;

/**
 * Servlet implementation class RouteServlet
 */
@WebServlet("/Route")
public class RouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RouteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// routeID
		int id = Integer.parseInt(request.getParameter("routeID"));

		// unitID
		String unitID = request.getParameter("des");

		// routeName
		String routeName = request.getParameter("des0");

		// timeStart
		String timeStart = request.getParameter("start");

		// timeEnd
		String timeEnd = request.getParameter("end");

		// timeBreak
		double timeBreak = Double.parseDouble(request.getParameter("break"));

		// startLocation
		String startLocation = request.getParameter("go");

		// endLocation
		String endLocation = request.getParameter("back");

		// kindRoute
		String kindRoute = request.getParameter("kind");

		BusRouteDetails unitDetails = new BusRouteDetails(id, unitID, routeName, timeStart, timeEnd, timeBreak,
				startLocation, endLocation, kindRoute);
		RouteDAO dao = new RouteDAO();
		try {
			dao.add(unitDetails);
			request.getRequestDispatcher("./BusRoute.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
