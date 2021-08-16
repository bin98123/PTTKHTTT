package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UnitDAO;

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
		HttpSession session = request.getSession();
		String submit = request.getParameter("submit");
		if (submit.equals("edit")) {
			String unitID = request.getParameter("unitID");
			session.setAttribute("unitID", unitID);
			request.getRequestDispatcher("/editUnit.jsp").forward(request, response);
		} else if (submit.equals("rollback")) {
			UnitDAO dao = new UnitDAO();
			try {
				dao.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);
		} else if (submit.equals("delete")) {
			String unitID = request.getParameter("unitID");
			UnitDAO dao = new UnitDAO();
			try {
				if (dao.deleteUnit(unitID) == true) {
					session.setAttribute("valueUnit", null);
					request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);

				} else {
					session.setAttribute("valueUnit", "error");
					request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
