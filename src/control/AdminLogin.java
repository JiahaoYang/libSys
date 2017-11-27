package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		request.setCharacterEncoding("utf8");
		
		String adminId = request.getParameter("adminId").trim();
		String password = request.getParameter("password").trim();
		System.out.println(adminId + password);
		
		AdminDao adminDao = new AdminDao();
		boolean success = adminDao.checkAdmin(adminId, password);
		if (success) {
			HttpSession session = request.getSession(true);
			session.setAttribute("adminId", adminId);
			response.sendRedirect(request.getContextPath() + "/admin/main.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp?flag=error");
		}
	}

}
