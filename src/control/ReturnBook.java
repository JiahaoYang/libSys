package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BorrowDao;
import dao.BorrowHistoryDao;


/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/returnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
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
		
		int bookId = Integer.parseInt(request.getParameter("bookId").trim());
		
		BookDao bookDao = new BookDao();
		BorrowDao borrowDao = new BorrowDao();
		String readerId = borrowDao.getReader(bookId);

		
		if (readerId == null)
			response.sendRedirect(request.getContextPath() + "/admin/return.jsp?flag=noReader");
		else {
			BorrowHistoryDao borrowHistoryDao = new BorrowHistoryDao(); 
			int overTime = borrowDao.overTime(bookId);
			float fine = (float) (overTime * 0.1);
			
			boolean success = bookDao.returnBook(bookId) && borrowDao.returnBook(bookId) 
								&& borrowHistoryDao.updateHistory(readerId, bookId, fine);
			if (success)
				response.sendRedirect(request.getContextPath() + "/admin/finishReturn.jsp?fine=" + fine);
			else
				response.sendRedirect(request.getContextPath() + "/admin/return.jsp?flag=fail");
		}
	}

}
