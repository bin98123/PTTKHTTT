package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChuyenDetails;
import dao.SearchDAO;
import model.BusRouteDetails;

/**
 * Servlet implementation class ManagerSearchRouteServlet
 */
@WebServlet("/ManagerSearchRouteServlet")
public class ManagerSearchRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchRouteServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
		ChuyenDetails chuyens = new ChuyenDetails();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String txtSearch = request.getParameter("txtSearch");
			SearchDAO searchDAO = new SearchDAO();
			List<BusRouteDetails> listChuyens = new ArrayList<BusRouteDetails>();
			listChuyens = searchDAO.getSearcRoute(txtSearch);

			System.out.println(searchDAO.getSearcRoute(txtSearch));
			request.setAttribute("listManaRoute", searchDAO.getSearcRoute(txtSearch));
			request.setAttribute("none", "visibleBus");
			request.getRequestDispatcher("/ManagerRoute.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
