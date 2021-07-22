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
import controller.User;
import dao.AccountDao;
import dao.ChuyenDetails;
import dao.loginDAO;
import model.AccountDetails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/home")
public class LoginView extends HttpServlet {
//	private User user;
	private AccountDao accountDao;
	private loginDAO loginDAO;
	private static final long serialVersionUID = 1L;
//	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Shop;user=sa;password=root";
//	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public LoginView() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok = false;
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("Password");
//		user = new User();
		loginDAO = new loginDAO();
		loginDAO.setUserName(userName);
		loginDAO.setUserPassword(userPassword);

		if (userName != null && userPassword != null || userName != "" && userPassword != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				accountDao = new AccountDao();
				boolean login = accountDao.getLogin(loginDAO.getUserName(), loginDAO.getUserPassword());

				if (login == true) {
					Chuyen c = new Chuyen();
					List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
					chuyens = c.getChuyens();
//					System.out.println(chuyens);
					request.setAttribute("list", c.getChuyens());
//					System.out.println(c.getChuyens());
//					request.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
					AccountDetails accountDetails = new AccountDetails();
					accountDetails = accountDao.getAccount(userName, userPassword);
//					session.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
					session.setAttribute("user", accountDetails);
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				} else {
					// username: 'Khanh'
					// password: '12345'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
//					String userDetails = "Invalid Username or Password.";
					String userDetails = "Tên đăng nhập hoặc mật khẩu không hợp lệ.";
					session.setAttribute("Invalid", userDetails);
					request.getRequestDispatcher("/login.jsp").forward(request, response);

				}
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
