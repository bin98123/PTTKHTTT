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

import dao.AccountDao;
import model.AccountDetails;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		private String accountID;
		String accountName = request.getParameter("accountName");
		String password = request.getParameter("password");
		String fullName = request.getParameter("lastName") + " " + request.getParameter("firstName");
		String birthdayText = request.getParameter("birthday");
//		String str;
		StringTokenizer tokenizer = new StringTokenizer(birthdayText, "/");
//		for (int i = 0; i < tokenizer.countTokens(); i++) {
		String dateText = tokenizer.nextToken();
		String monthText = tokenizer.nextToken();
		String yearText = tokenizer.nextToken();
		int date = Integer.parseInt(dateText);
		int month = Integer.parseInt(monthText);
		int year = Integer.parseInt(yearText);
//		}
		Date birthday = new Date(year - 1900, month - 1, date);
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
//		AccountDetails1 accountDetails = new AccountDetails1(null, accountName, password, fullName, birthday, email,
//				phoneNumber);
		AccountDetails accountDetails = new AccountDetails(null, accountName, password, fullName, birthday, email,
				phoneNumber);
		AccountDao accountDao = new AccountDao();
//		int a = accountDao.getCount();
		try {
//			accountDao.registerUser(accountDetails);
			if (accountDao.registerUser(accountDetails) > 0) {
				request.getRequestDispatcher("./RegisterSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("./signup.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
