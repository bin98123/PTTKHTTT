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
import dao.DriverDAO;

/**
 * Servlet implementation class ManagerBusStopServlet
 */
@WebServlet("/ManagerBusStop")
public class ManagerBusStopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerBusStopServlet() {
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
			String serial = request.getParameter("serial");
			session.setAttribute("idBusStop", unitID);
			session.setAttribute("serialBusStop", serial);
			request.getRequestDispatcher("/editBusStop.jsp").forward(request, response);
//		if (submit.equals("edit")) {
//			String unitID = request.getParameter("unitID");
//			session.setAttribute("id", unitID);
//			request.getRequestDispatcher("/editDriver.jsp").forward(request, response);
////			DriverDAO dao = new DriverDAO();
////dao.edit(driverDetails, driverID)
		} else if (submit.equals("rollback")) {
			BusStopDAO dao = new BusStopDAO();
			try {
				dao.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ManagerBusStop.jsp").forward(request, response);
		} else if (submit.equals("delete")) {
			String unitIDTxt = request.getParameter("unitID");
			String serialTxt = request.getParameter("serial");
			double unitID0 = Double.parseDouble(unitIDTxt);
//			int unitID = Integer.parseInt(unitIDTxt);
			int serial = Integer.parseInt(serialTxt);
			int unitID = (int) unitID0;
			BusStopDAO dao = new BusStopDAO();
			try {
				if (dao.delete(unitID, serial)) {
					session.setAttribute("valueStop", null);
					request.getRequestDispatcher("/ManagerBusStop.jsp").forward(request, response);

				} else {
					session.setAttribute("valueStop", "error");
					request.getRequestDispatcher("/ManagerBusStop.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (submit.equals("deleteAll")) {
			BusStopDAO dao = new BusStopDAO();
			try {
				if (dao.deleteAll()) {
					session.setAttribute("valueStop", null);
					request.getRequestDispatcher("/ManagerBusStop.jsp").forward(request, response);

				} else {
					session.setAttribute("valueStop", "error");
					request.getRequestDispatcher("/ManagerBusStop.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (submit.equals("add")) {

		}

	}

}