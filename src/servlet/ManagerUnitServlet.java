package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDAO;

/**
 * Servlet implementation class ManagerUnitServlet
 */
@WebServlet("/ManagerUnit")
public class ManagerUnitServlet extends HttpServlet {
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
		String submit = request.getParameter("submit");
		if (submit.equals("edit")) {
			String unitID = request.getParameter("unitID");

		} else if (submit.equals("rollback")) {
			BusDAO dao = new BusDAO();
			try {
				dao.rollback();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);
		} else if (submit.equals("delete")) {
			String unitID = request.getParameter("unitID");
			BusDAO dao = new BusDAO();
			try {
				if (dao.deleteUnit(unitID)) {
					request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
