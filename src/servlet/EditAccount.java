package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DriverDAO;
import model.DriverDetails;

/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAccount() {
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

		// busID
		String id = (String) session.getAttribute("id");

		// fullname
		String fullNameTxt = request.getParameter("name");
		String fullName = URLDecoder.decode(fullNameTxt, "UTF-8");

		// birthday
		String birthdayText = request.getParameter("birthday");
		StringTokenizer tokenizer = new StringTokenizer(birthdayText, "/");
		String dateText = tokenizer.nextToken();
		String monthText = tokenizer.nextToken();
		String yearText = tokenizer.nextToken();
		int date = Integer.parseInt(dateText);
		int month = Integer.parseInt(monthText);
		int year = Integer.parseInt(yearText);
		Date birthday = new Date(year - 1900, month - 1, date);

		// male
		String maleTxt = request.getParameter("male");
		if (maleTxt == null) {
			maleTxt = "Nữ";
		} else {

			maleTxt = "Nam";
		}
		System.out.println(maleTxt);
		boolean male = false;
		if (maleTxt.equals("Nam")) {
			male = true;
		}
		// address
		String addressTxt = request.getParameter("address");
		String address = URLDecoder.decode(addressTxt, "UTF-8");

		// country
		String countryTxt = request.getParameter("country");
		String country = URLDecoder.decode(countryTxt, "UTF-8");

		// dayBegin
		String dayBeginText = request.getParameter("dayBegin");
		StringTokenizer tokenizer0 = new StringTokenizer(dayBeginText, "/");
		String dateText0 = tokenizer0.nextToken();
		String monthText0 = tokenizer0.nextToken();
		String yearText0 = tokenizer0.nextToken();
		int date0 = Integer.parseInt(dateText0);
		int month0 = Integer.parseInt(monthText0);
		int year0 = Integer.parseInt(yearText0);
		Date dayBegin = new Date(year0 - 1900, month0 - 1, date0);

		System.out.println(birthday);
		System.out.println(dayBegin);
		System.out.println(id);
		System.out.println(fullName);
		System.out.println(address);
		System.out.println(country);

		// salary
		int salary = Integer.parseInt(request.getParameter("salary"));
		System.out.println(salary);
		// license
		String licenseTxt = request.getParameter("license");
		String license = URLDecoder.decode(licenseTxt, "UTF-8");
		System.out.println(license);

		// busID
		String str = request.getParameter("des");
		if (str != null) {
			System.out.println("You have selected " + str);
		}
		DriverDetails driverDetails = new DriverDetails(null, fullName, birthday, male, address, country, dayBegin,
				salary, license, str);
		DriverDAO dao = new DriverDAO();
		try {
//			dao.add(driverDetails);
			dao.edit(driverDetails, id);
			request.getRequestDispatcher("./ManagerDriver.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("male", maleTxt);
	}

}
