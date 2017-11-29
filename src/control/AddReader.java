package control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReaderDao;
import entity.Reader;

/**
 * Servlet implementation class AddReader
 */
@WebServlet("/addReader")
public class AddReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReader() {
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
		
		String readerId = request.getParameter("readerId").trim();
		String password = request.getParameter("password").trim();
		String readerType = request.getParameter("readerType").trim();
		LocalDate today = LocalDate.now();
		String readerName = request.getParameter("readerName").trim();
		String gender = request.getParameter("gender").trim();
		String phone = request.getParameter("phone")==null ? "" : request.getParameter("phone").trim();
		String email = request.getParameter("email")==null ? "" : request.getParameter("email").trim();
		
		Reader reader = new Reader();
		reader.setEmail(email);
		reader.setGender(gender);
		reader.setPassword(password);
		reader.setPhone(phone);
		reader.setReaderId(readerId);
		reader.setReaderName(readerName);
		reader.setReaderType(readerType);
		reader.setRegisterDate(today);
		
		ReaderDao readerDao = new ReaderDao();
		boolean success = readerDao.addReader(reader);
		if (success)
			response.sendRedirect(request.getContextPath() + "/admin/success.html");
		else
			response.sendRedirect(request.getContextPath() + "/admin/fail.html");
	}

}
