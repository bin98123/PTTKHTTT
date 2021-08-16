package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.BusUnitManagerDetails;

/**
 * Servlet implementation class ManagerSearchUnitServlet
 */
@WebServlet("/ManagerSearchUnitServlet")
public class ManagerSearchUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusUnitManagerDetails chuyens;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchUnitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		chuyens = new BusUnitManagerDetails();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String txtSearch = request.getParameter("txtSearch");
			SearchDAO searchDAO = new SearchDAO();
			List<BusUnitManagerDetails> listChuyens = new ArrayList<BusUnitManagerDetails>();
			listChuyens = searchDAO.getSearchUnit(txtSearch);

			System.out.println(searchDAO.getSearchUnit(txtSearch));
			request.setAttribute("listManaBusUnit", searchDAO.getSearchUnit(txtSearch));
			request.setAttribute("none", "visibleUnit");
			request.getRequestDispatcher("/ManagerUnit.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
