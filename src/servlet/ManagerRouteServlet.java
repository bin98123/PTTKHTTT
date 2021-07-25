package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusStopDAO;
import dao.RouteDAO;
import model.BusRouteDetails;

/**
 * Servlet implementation class ManagerRouteServlet
 */
@WebServlet("/ManagerRoute")
public class ManagerRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerRouteServlet() {
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
		HttpSession session = request.getSession();
		String submit = request.getParameter("submit");
		if (submit.equals("edit")) {
			String unitID = request.getParameter("unitID");
			session.setAttribute("idRoute", unitID);
			request.getRequestDispatcher("/editBusRoute.jsp").forward(request, response);
//		if (submit.equals("edit")) {
//			String unitID = request.getParameter("unitID");
//			session.setAttribute("id", unitID);
//			request.getRequestDispatcher("/editDriver.jsp").forward(request, response);
////			DriverDAO dao = new DriverDAO();
////dao.edit(driverDetails, driverID)
		} else if (submit.equals("rollback")) {
			RouteDAO dao = new RouteDAO();
			try {
				dao.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ManagerRoute.jsp").forward(request, response);
		} else if (submit.equals("delete")) {
			String unitID = request.getParameter("unitID");
//			int unitID = Integer.parseInt(unitIDTxt);
			RouteDAO dao = new RouteDAO();
			try {
				if (dao.delete(unitID)) {
					request.getRequestDispatcher("/ManagerRoute.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/ManagerRoute.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (submit.equals("add")) {

		}

	}

}