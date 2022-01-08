package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/Manager")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
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
		AccountDao dao = new AccountDao();
		// home
		String home = request.getParameter("action");
		if (home.equals("exit")) {
//		request.getRequestDispatcher("./login.jsp");
			try {
				LocalDate date = java.time.LocalDate.now();
				long currentTime = System.currentTimeMillis();
				long totalSeconds = (currentTime + 1000) / 1000;

				long currentSecond = totalSeconds % 60;

				long totalMinutes = (totalSeconds + 60) / 60;

				long currentMinutes = (totalMinutes) % 60;

				long totalHour = (totalMinutes) / 60;

				long currentHour = totalHour % 24;
//				if (currentHour == 23 && currentMinutes >= 55) {
//					currentHour = 0;
//				}
				LocalTime time = java.time.LocalTime.of((int) (currentHour), (int) (currentMinutes),
						(int) currentSecond);
				java.sql.Date sqlDate = java.sql.Date.valueOf(date);
				java.sql.Time sqlTimeCurrent = java.sql.Time.valueOf(time);
				String userName = (String) session.getAttribute("currentUser");
				dao.setExpireTimeUser(userName, sqlTimeCurrent, sqlDate);
				dao.logoutUser((String) session.getAttribute("currentUser"));
				// dao.logoutUser();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((String) session.getAttribute("currentUser"));
			session.invalidate();
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if (home.equals("findPath")) {
			request.getRequestDispatcher("./findPath.jsp").forward(request, response);
		}
		// search
//		String search = request.getParameter("search");
		else if (home.equals("exitGuess")) {
//		request.getRequestDispatcher("./login.jsp");
			session.invalidate();
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
		// search
//		String search = request.getParameter("search");

		// Trạm
		else if (home.equals("search-busStop")) {
			request.getRequestDispatcher("./BusManager2.jsp").forward(request, response);
			// Xe
		} else if (home.equals("search-bus")) {
			request.getRequestDispatcher("./Bus.jsp").forward(request, response);
			// Tài xế
		} else if (home.equals("search-bus-driver")) {
			request.getRequestDispatcher("./Driver.jsp").forward(request, response);
			// Tuyến xe
		} else if (home.equals("search-bus-router")) {
			request.getRequestDispatcher("./BusRoute.jsp").forward(request, response);
			// Đơn vị
		} else if (home.equals("search-unit")) {
			request.getRequestDispatcher("./Unit.jsp").forward(request, response);
			// -------------------------------------
			// Thống kê
		} else if (home.equals("statistic")) {
			request.getRequestDispatcher("./statistic.jsp").forward(request, response);
			// -------------------------------------
			// Quản lý
			// Đơn vị
		} else if (home.equals("manager-unit")) {
			request.getRequestDispatcher("./ManagerUnit.jsp").forward(request, response);
			// Trạm
		} else if (home.equals("manager-stop")) {
			request.getRequestDispatcher("./ManagerBusStop.jsp").forward(request, response);
			// Tài xế
		} else if (home.equals("manager-driver")) {
			request.getRequestDispatcher("./ManagerDriver.jsp").forward(request, response);
			// Xe
		} else if (home.equals("manager-bus")) {
			request.getRequestDispatcher("./ManagerBus.jsp").forward(request, response);
			// Tuyến xe
		} else if (home.equals("manager-route")) {
			request.getRequestDispatcher("./ManagerRoute.jsp").forward(request, response);
		}
	}
}
