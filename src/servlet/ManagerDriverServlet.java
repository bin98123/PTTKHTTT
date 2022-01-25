package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusDAO;
import dao.DriverDAO;

/**
 * Servlet implementation class ManagerDriverServlet
 */
@WebServlet("/ManagerDriver")
public class ManagerDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
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
			session.setAttribute("id", unitID);
			request.getRequestDispatcher("/editDriver.jsp").forward(request, response);
//			DriverDAO dao = new DriverDAO();
//dao.edit(driverDetails, driverID)
		} else if (submit.equals("rollback")) {
			DriverDAO dao = new DriverDAO();
			try {
				dao.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ManagerDriver.jsp").forward(request, response);
		} else if (submit.equals("delete")) {
			String unitID = request.getParameter("unitID");
			DriverDAO dao = new DriverDAO();
			try {
				if (dao.deleteDriver(unitID) == true) {
					session.setAttribute("valueDriver", null);
					request.getRequestDispatcher("/ManagerDriver.jsp").forward(request, response);

				} else {
					session.setAttribute("valueDriver", "error");
					request.getRequestDispatcher("/ManagerDriver.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (submit.equals("deleteAll")) {
			DriverDAO dao = new DriverDAO();
			try {
				if (dao.deleteAll()) {
					session.setAttribute("valueDriver", null);
					request.getRequestDispatcher("/ManagerDriver.jsp").forward(request, response);

				} else {
					session.setAttribute("valueDriver", "error");
					request.getRequestDispatcher("/ManagerDriver.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (submit.equals("add")) {

		}

	}

}
