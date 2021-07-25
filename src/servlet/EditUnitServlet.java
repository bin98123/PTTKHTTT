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

import dao.UnitDAO;
import model.BusUnitManagerDetails;

/**
 * Servlet implementation class EditUnitServlet
 */
@WebServlet("/EditUnit")
public class EditUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUnitServlet() {
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

		// unitID
		String id = (String) session.getAttribute("unitID");
		// fullname
		String fullNameTxt = request.getParameter("name");
		String fullName = URLDecoder.decode(fullNameTxt, "UTF-8");

		// phoneNumber
		String phoneNumberTxt = request.getParameter("phoneNumber");
		String phoneNumber = URLDecoder.decode(phoneNumberTxt, "UTF-8");

		// email
		String emailTxt = request.getParameter("email");
		String email = URLDecoder.decode(emailTxt, "UTF-8");

		BusUnitManagerDetails unitDetails = new BusUnitManagerDetails(null, fullName, phoneNumber, email);
		UnitDAO dao = new UnitDAO();
		try {
//			dao.add(driverDetails);
			dao.edit(unitDetails, id);
			request.getRequestDispatcher("./ManagerUnit.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
