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
import model.BusDetails;

/**
 * Servlet implementation class ManagerSearchBusServlet
 */
@WebServlet("/ManagerSearchBusServlet")
public class ManagerSearchBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChuyenDetails chuyens;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchBusServlet() {
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
		chuyens = new ChuyenDetails();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String txtSearch = request.getParameter("txtSearch");
			SearchDAO searchDAO = new SearchDAO();
			List<BusDetails> listChuyens = new ArrayList<BusDetails>();
			listChuyens = searchDAO.getSearchBus(txtSearch);

			System.out.println(searchDAO.getSearchBus(txtSearch));
			request.setAttribute("listManaBus", searchDAO.getSearchBus(txtSearch));
			request.setAttribute("none", "visibleBus");
			request.getRequestDispatcher("/ManagerBus.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
