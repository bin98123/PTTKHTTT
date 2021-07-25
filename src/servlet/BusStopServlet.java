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

import dao.BusStopDAO;
import model.BusStopDetails;
import model.BusUnitManagerDetails;

/**
 * Servlet implementation class BusStopServlet
 */
@WebServlet("/BusStop")
public class BusStopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusStopServlet() {
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

		// des
		String str = request.getParameter("des");
		int routeID = Integer.parseInt(str);

		// stt
		String serialTxt = request.getParameter("name");
		int serial = Integer.parseInt(serialTxt);

		// trạm
		String busStopTxt = request.getParameter("busStop");
		String busStop = URLDecoder.decode(busStopTxt, "UTF-8");

		BusStopDetails unitDetails = new BusStopDetails(routeID, serial, busStop);
		BusStopDAO dao = new BusStopDAO();
		try {
			dao.add(unitDetails);
			request.getRequestDispatcher("./ManagerBusStop.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
