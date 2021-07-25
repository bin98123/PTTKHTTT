package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusDAO;
import model.BusDetails;

/**
 * Servlet implementation class BusServlet
 */
@WebServlet("/Bus")
public class BusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// routeID
		String str = request.getParameter("des");
		int routeID = Integer.parseInt(str);

		// busID
		String busID = request.getParameter("busID");

		// giấy phép lái xe
		String license = request.getParameter("license");

		// loại xe
		String kind = request.getParameter("kind");

		// ngày sản xuất
		String dayManuText = request.getParameter("manu");
		StringTokenizer tokenizer0 = new StringTokenizer(dayManuText, "/");
		String dateText0 = tokenizer0.nextToken();
		String monthText0 = tokenizer0.nextToken();
		String yearText0 = tokenizer0.nextToken();
		int date0 = Integer.parseInt(dateText0);
		int month0 = Integer.parseInt(monthText0);
		int year0 = Integer.parseInt(yearText0);
		Date manuDay = new Date(year0 - 1900, month0 - 1, date0);

		// ngày bảo hành gần đây
		String dayGuaText = request.getParameter("gua");
		StringTokenizer tokenizer1 = new StringTokenizer(dayGuaText, "/");
		String dateText1 = tokenizer1.nextToken();
		String monthText1 = tokenizer1.nextToken();
		String yearText1 = tokenizer1.nextToken();
		int date1 = Integer.parseInt(dateText1);
		int month1 = Integer.parseInt(monthText1);
		int year1 = Integer.parseInt(yearText1);
		Date guaDay = new Date(year1 - 1900, month1 - 1, date1);

		BusDetails unitDetails = new BusDetails(busID, license, kind, manuDay, guaDay, routeID);
		BusDAO dao = new BusDAO();
		try {
			dao.add(unitDetails);
			request.getRequestDispatcher("./ManagerBus.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
