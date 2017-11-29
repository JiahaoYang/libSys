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
import dao.ReaderDao;
import entity.Book;
import entity.Reader;

/**
 * Servlet implementation class Borrow
 */
@WebServlet("/borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrow() {
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
		
		String bookId = request.getParameter("bookId").trim();
		String readerId = request.getParameter("readerId").trim();
		
		BookDao bookDao = new BookDao();
		ReaderDao readerDao = new ReaderDao();
		Book book = bookDao.getById(Integer.parseInt(bookId));
		Reader reader = readerDao.getById(readerId);

		
		if (book == null)
			response.sendRedirect(request.getContextPath() + "/admin/borrow.jsp?flag=noBook");
		else if (reader == null)
			response.sendRedirect(request.getContextPath() + "/admin/borrow.jsp?flag=noReader");
		else {
			BorrowDao borrowDao = new BorrowDao();
			BorrowHistoryDao borrowHistoryDao = new BorrowHistoryDao(); 
			
			boolean success = bookDao.borrow(book) && 
					borrowDao.borrow(book, reader) && borrowHistoryDao.addHistory(book, reader);
			if (success)
				response.sendRedirect(request.getContextPath() + "/admin/borrow.jsp?flag=success");
			else
				response.sendRedirect(request.getContextPath() + "/admin/borrow.jsp?flag=fail");
		}
	}

}
