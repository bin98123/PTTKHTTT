/**package servlet;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class LoginServlet
 */
/**
@WebServlet("/home")
public class LoginView extends HttpServlet {
//	private User user;
	private AccountDao accountDao;
	private LoginDAO loginDAO;
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
		loginDAO = new LoginDAO();
		loginDAO.setUserName(userName);
		loginDAO.setUserPassword(userPassword);

		if (userName != null && userPassword != null || userName != "" && userPassword != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				accountDao = new AccountDao();
				System.out.println(accountDao.checkLoginAccount(userName));
				if (accountDao.checkLoginAccount(userName) == 1) {
					System.out.println(loginDAO.getUserName());
					boolean login = accountDao.getLogin(loginDAO.getUserName(), loginDAO.getUserPassword());

					LocalDate date = java.time.LocalDate.now();
					long currentTime = System.currentTimeMillis();
					long totalSeconds = currentTime / 1000;

					long currentSecond = totalSeconds % 60;

					long totalMinutes = totalSeconds / 60;

					long currentMinutes = (totalMinutes % 60);

					long totalHour = totalMinutes / 60;

					long currentHour = totalHour % 24 - 6;
					LocalTime time = java.time.LocalTime.of((int) (currentHour + 1), (int) (currentMinutes + 1) + 5,
							(int) (currentSecond + 1));
					LocalTime time1 = java.time.LocalTime.of((int) (currentHour + 1), (int) (currentMinutes + 1),
							(int) (currentSecond + 1));
					Date dateSql = new Date();
					Time timeSql = new Time(currentTime);
					java.sql.Date sqlDate = java.sql.Date.valueOf(date);
					java.sql.Time sqlTime = java.sql.Time.valueOf(time);
					java.sql.Time sqlTimeUpdate = java.sql.Time.valueOf(time1);

					System.out.println("Thời hạn so với hiện tại là: " + sqlTime.compareTo(sqlTimeUpdate));

					System.out.println(sqlTime);
					System.out.println(time);
					System.out.println(sqlDate);
					System.out.println(date);
//					System.out.println(dateSql);
//					System.out.println(timeSql);
//					System.out.println(time);
//					System.out.println(date);
					if (login == true) {
						accountDao.loginUser(userName);
						Chuyen c = new Chuyen();
						List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
						chuyens = c.getChuyens();
//					System.out.println(chuyens);
						request.setAttribute("list", c.getChuyens());
						session.setAttribute("currentUser", userName);
//					System.out.println(c.getChuyens());
//					request.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
						AccountDetails accountDetails = new AccountDetails();
						accountDetails = accountDao.getAccount(userName, userPassword);
//					session.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
						session.setAttribute("user", accountDetails);
						session.setAttribute("accountID", accountDetails.getAccountID());
						accountDao.setExpireTimeUser(userName, sqlTime, sqlDate);
						request.getRequestDispatcher("/home.jsp").forward(request, response);
					} else {
						// username: 'Khanh'
						// password: '12345'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
//					String userDetails = "Invalid Username or Password.";
						String userDetails = "Tên đăng nhập hoặc mật khẩu không hợp lệ.";
						session.setAttribute("Invalid", userDetails);
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						session.invalidate();

					}
				} else {
					String userDetails = "Tài khoản đã có người đang đăng nhập.";
					session.setAttribute("Invalid", userDetails);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					session.invalidate();
				}
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}**/
package servlet;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/home")
public class LoginView extends HttpServlet {
//	private User user;
	private AccountDao accountDao;
	private LoginDAO loginDAO;
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
		loginDAO = new LoginDAO();
		loginDAO.setUserName(userName);
		loginDAO.setUserPassword(userPassword);

		if (userName != null && userPassword != null || userName != "" && userPassword != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				accountDao = new AccountDao();
				System.out.println(accountDao.checkLoginAccount(userName));
				// Lấy time hiện tại
				LocalDate date0 = java.time.LocalDate.now();
				long currentTime0 = System.currentTimeMillis();
				long totalSeconds0 = (currentTime0 + 1000) / 1000;

				long currentSecond0 = totalSeconds0 % 60;

				long totalMinutes0 = (totalSeconds0 + 60) / 60;

				long currentMinutes0 = (totalMinutes0) % 60;

				long totalHour0 = (totalMinutes0) / 60;

				long currentHour0 = totalHour0 % 24;
//				if (currentHour0 == 23 && currentMinutes0 >= 55) {
//					currentHour0 = 0;
//				}
				LocalTime time0 = java.time.LocalTime.of((int) (currentHour0), (int) (currentMinutes0),
						(int) currentSecond0);
				Date dateSql0 = new Date();
				Time timeSql0 = new Time(currentTime0);
				java.sql.Date sqlDate0 = java.sql.Date.valueOf(date0);
				java.sql.Time sqlTime0 = java.sql.Time.valueOf(time0);
				java.sql.Time sqlTimeCurrent0 = java.sql.Time.valueOf(time0);

				// Thiết lập thời hạn sau khi đăng nhập
				LocalDate date = java.time.LocalDate.now();
				long currentTime = System.currentTimeMillis();
				long totalSeconds = (currentTime + 1000) / 1000;

				long currentSecond = totalSeconds % 60;

				long totalMinutes = (totalSeconds + 60 + 3 * 60) / 60;

				long currentMinutes = (totalMinutes) % 60;

				long totalHour = (totalMinutes) / 60;

				long currentHour = totalHour % 24;
//				if (currentHour == 23 && currentMinutes >= 55) {
//					currentHour = 0;
//				}
				LocalTime time = java.time.LocalTime.of((int) (currentHour), (int) (currentMinutes),
						(int) currentSecond);
				LocalTime time1 = java.time.LocalTime.of((int) (currentHour), (int) (currentMinutes),
						(int) (currentSecond));
				Date dateSql = new Date();
				Time timeSql = new Time(currentTime);
				java.sql.Date sqlDate = java.sql.Date.valueOf(date);
				java.sql.Time sqlTime = java.sql.Time.valueOf(time);
				java.sql.Time sqlTimeCurrent = java.sql.Time.valueOf(time1);
				//
				java.sql.Time sqlTimeExpire = accountDao.getExpireTime(userName);
				java.sql.Date sqlDateExpire = accountDao.getExpireDate(userName);
				System.out.println("Thời hạn sử dụng: " + sqlTimeExpire);
				System.out.println("Thời gian hiện tại: " + sqlTimeCurrent0);
				System.out.println("Thời gian hiện tại: " + sqlTimeCurrent);
				System.out.println("Ngày hết thời hạn sử dụng: " + sqlDateExpire);
				System.out.println("Ngày hôm nay: " + sqlDate);
				if (sqlDateExpire == null || sqlDateExpire.compareTo(sqlDate) < 0) {
					System.out.println(" : " + loginDAO.getUserName());
					boolean login = accountDao.getLogin(loginDAO.getUserName(), loginDAO.getUserPassword());

					System.out.println("Thời hạn so với hiện tại là: " + sqlTimeCurrent.compareTo(sqlTimeCurrent));

					System.out.println(sqlTime);
					System.out.println(time);
					System.out.println(sqlDate);
					System.out.println(date);
//					System.out.println(dateSql);
//					System.out.println(timeSql);
//					System.out.println(time);
//					System.out.println(date);
					if (login == true) {
						accountDao.loginUser(userName);
						Chuyen c = new Chuyen();
						List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
						chuyens = c.getChuyens();
//					System.out.println(chuyens);
						request.setAttribute("list", c.getChuyens());
						session.setAttribute("currentUser", userName);
//					System.out.println(c.getChuyens());
//					request.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
						AccountDetails accountDetails = new AccountDetails();
						accountDetails = accountDao.getAccount(userName, userPassword);
//					session.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
						session.setAttribute("user", accountDetails);
						session.setAttribute("accountID", accountDetails.getAccountID());
						accountDao.setExpireTimeUser(userName, sqlTime, sqlDate);
						request.getRequestDispatcher("/home.jsp").forward(request, response);
					} else {
						// username: 'Khanh'
						// password: '12345'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
//					String userDetails = "Invalid Username or Password.";
						String userDetails = "Tên đăng nhập hoặc mật khẩu không hợp lệ.";
						session.setAttribute("Invalid", userDetails);
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						session.invalidate();

					}
				} else if (sqlDateExpire.compareTo(sqlDate) == 0) {
					if (sqlTimeExpire == null || sqlTimeExpire.compareTo(sqlTimeCurrent0) < 0) {
						System.out.println(" : " + loginDAO.getUserName());
						boolean login = accountDao.getLogin(loginDAO.getUserName(), loginDAO.getUserPassword());

						System.out.println("Thời hạn so với hiện tại là: " + sqlTimeCurrent.compareTo(sqlTimeCurrent));

						System.out.println(sqlTime);
						System.out.println(time);
						System.out.println(sqlDate);
						System.out.println(date);
//					System.out.println(dateSql);
//					System.out.println(timeSql);
//					System.out.println(time);
//					System.out.println(date);
						if (login == true) {
							accountDao.loginUser(userName);
							Chuyen c = new Chuyen();
							List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
							chuyens = c.getChuyens();
//					System.out.println(chuyens);
							request.setAttribute("list", c.getChuyens());
							session.setAttribute("currentUser", userName);
//					System.out.println(c.getChuyens());
//					request.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
							AccountDetails accountDetails = new AccountDetails();
							accountDetails = accountDao.getAccount(userName, userPassword);
//					session.setAttribute("user",
//							new AccountDetails(null, userName, userPassword, null, null, null, null));
							session.setAttribute("user", accountDetails);
							session.setAttribute("accountID", accountDetails.getAccountID());
							accountDao.setExpireTimeUser(userName, sqlTime, sqlDate);
							request.getRequestDispatcher("/home.jsp").forward(request, response);
						} else {
							// username: 'Khanh'
							// password: '12345'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
//					String userDetails = "Invalid Username or Password.";
							String userDetails = "Tên đăng nhập hoặc mật khẩu không hợp lệ.";
							session.setAttribute("Invalid", userDetails);
							request.getRequestDispatcher("/login.jsp").forward(request, response);
							session.invalidate();

						}
					} else {
						String userDetails = "Tài khoản đã có người đang đăng nhập.";
						session.setAttribute("Invalid", userDetails);
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						session.invalidate();
					}
				} else {
					String userDetails = "Tài khoản đã có người đang đăng nhập.";
					session.setAttribute("Invalid", userDetails);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					session.invalidate();
				}
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}