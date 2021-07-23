package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Chuyen;
import dao.AccountDao;
import dao.ChuyenDetails;
import dao.LoginDAO;
import model.AccountDetails;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok = false;
		HttpSession session = request.getSession();
		String currentPass = request.getParameter("current_pass");
		String pass = request.getParameter("new_pass");
		String pass_con = request.getParameter("new_pass_con");
		AccountDao accountDao;
//		user = new User();
//		LoginDAO = new LoginDAO();
//		LoginDAO.setUserName(userName);
//		LoginDAO.setUserPassword(userPassword);

		if (currentPass != null && pass != null || currentPass != "" && pass != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				accountDao = new AccountDao();
				String id = (String) session.getAttribute("accountID");
				boolean check = accountDao.checkPassword(currentPass, id);

				if (check == true) {
//					Chuyen c = new Chuyen();
//					List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
//					chuyens = c.getChuyens();
//					System.out.println(chuyens);
//					request.setAttribute("list", c.getChuyens());
//					System.out.println(c.getChuyens());
//					request.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
//					AccountDetails accountDetails = new AccountDetails();
//					accountDetails = accountDao.getAccount(userName, userPassword);
//					session.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
//					session.setAttribute("user", accountDetails);
					accountDao.changePassword(pass, id);
					System.out.println(accountDao.checkPassword(currentPass, id));
					System.out.println(id);
					request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
				} else {
					// username: 'Khanh'
					// password: '12345'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
//					String userDetails = "Invalid Username or Password.";
//					String userDetails = "Tên đăng nhập hoặc mật khẩu không hợp lệ.";
//					session.setAttribute("Invalid", userDetails);
					request.getRequestDispatcher("/changePassword.jsp").forward(request, response);

				}
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
