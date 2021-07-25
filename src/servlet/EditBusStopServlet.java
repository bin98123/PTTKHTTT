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
import model.BusStopDetails;

/**
 * Servlet implementation class EditBusStopServlet
 */
@WebServlet("/EditBusStop")
public class EditBusStopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBusStopServlet() {
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

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// name
		String name = request.getParameter("nameBusStopInput");
		// id
//		String fullNameTxt = request.getParameter("name");
//		String fullName = URLDecoder.decode(fullNameTxt, "UTF-8");
		String idBusStopTxt = (String) session.getAttribute("idBusStop");
		int idBusStop = (int) Double.parseDouble(idBusStopTxt);
		// serial
		String serialTxt = (String) session.getAttribute("serialBusStop");
		int serial = (int) Double.parseDouble(serialTxt);
		BusStopDetails unitDetails = new BusStopDetails(0, 0, name);
		BusStopDAO dao = new BusStopDAO();
		try {
//			dao.add(driverDetails);
			dao.edit(unitDetails, idBusStop, serial);
			request.getRequestDispatcher("./ManagerBusStop.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
