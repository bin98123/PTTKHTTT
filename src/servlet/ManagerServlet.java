package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// home
		String home = request.getParameter("home");
		if (home.equals("exit")) {
//		request.getRequestDispatcher("./login.jsp");
			session.invalidate();
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if (home.equals("findPath")) {
			request.getRequestDispatcher("./findPath.jsp").forward(request, response);
		}
		// search
//		String search = request.getParameter("search");
		else if (home.equals("search-bus-router")) {
			request.getRequestDispatcher("./BusManager2.jsp").forward(request, response);
		}
		else if (home.equals("search-bus")) {
			request.getRequestDispatcher("./Bus.jsp").forward(request, response);
		}
		else if (home.equals("search-bus-driver")) {
			request.getRequestDispatcher("./Driver.jsp").forward(request, response);
		}
		else if (home.equals("search-unit")) {
			request.getRequestDispatcher("./Unit.jsp").forward(request, response);
		}
	}
}
