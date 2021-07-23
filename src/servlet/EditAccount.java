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

import dao.AccountDao;
import dao.DriverDAO;
import model.AccountDetails;
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

		// fullname
		String fullNameTxt = request.getParameter("name_in");
		String fullName = URLDecoder.decode(fullNameTxt, "UTF-8");

		// birthday
		String birthdayText = request.getParameter("birthday_in");
		StringTokenizer tokenizer = new StringTokenizer(birthdayText, "/");
		String dateText = tokenizer.nextToken();
		String monthText = tokenizer.nextToken();
		String yearText = tokenizer.nextToken();
		int date = Integer.parseInt(dateText);
		int month = Integer.parseInt(monthText);
		int year = Integer.parseInt(yearText);
		Date birthday = new Date(year - 1900, month - 1, date);

		// email
		String emailTxt = request.getParameter("email_in");
		String email = URLDecoder.decode(emailTxt, "UTF-8");

		// phoneNumber
		String phoneNumberTxt = request.getParameter("phoneNumber_in");
		String phoneNumber = URLDecoder.decode(phoneNumberTxt, "UTF-8");

		System.out.println(birthday);
		System.out.println(fullName);

		try {
			AccountDao accountDao = new AccountDao();
			String id = (String) session.getAttribute("accountID");
			System.out.println(id);
			AccountDetails account = new AccountDetails(null, null, null, fullName, birthday, email, phoneNumber);
			accountDao.editAccount(account, id);
//			dao.add(driverDetails);

			request.getRequestDispatcher("./homeTest.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		session.setAttribute("male", maleTxt);
	}

}
