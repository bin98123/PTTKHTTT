package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Chuyen;
import dao.ChuyenDetails;
import dao.ChuyenXeDB;

/**
 * Servlet implementation class FindPathServlet
 */
@WebServlet("/find")
public class FindPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPathServlet() {
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
		boolean ok = false;
		Chuyen c = new Chuyen();
		List<String> chuyens = new ArrayList<String>();

		HttpSession session = request.getSession();
		String startText = request.getParameter("start");
		String start = URLDecoder.decode(startText, "UTF-8");
		String desText = request.getParameter("des");
		String des = URLDecoder.decode(desText, "UTF-8");
		chuyens = c.getList();
		if (chuyens.contains(start) && chuyens.contains(des)) {
			ok = true;
		}
		if (ok == true) {
			dao.ChuyenXeDB findPath = new ChuyenXeDB();
			try {
				List<String> path = findPath.search(start, des);
				System.out.println(start + " " + des);

				session.setAttribute("desInput", des);
				session.setAttribute("startInput", start);
				session.setAttribute("path", path);
				request.getRequestDispatcher("./findPath.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//			String path = "Không tìm được đường đi!!!";
//			session.setAttribute("path", path);
//			request.getRequestDispatcher("./pathResult.jsp").forward(request, response);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			session.setAttribute("desInput", des);
			session.setAttribute("startInput", start);
			List<String> path1 = new ArrayList<String>();
			String error = "Điểm đi: '" + start + "' hoặc điểm đến: '" + des + "' không có trong dữ liệu!!!!";
			path1.add(error);
			session.setAttribute("path", path1);
			request.getRequestDispatcher("./findPath.jsp").forward(request, response);
		}
	}

}
