package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import entity.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
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
		
		String bookName = request.getParameter("bookName").trim();
		String bookKind = request.getParameter("bookKind").trim();
		String press = request.getParameter("press").trim();
		String author = request.getParameter("author").trim();
		String isbn = request.getParameter("isbn").trim();
		String position = request.getParameter("position").trim();
		String translator = request.getParameter("translator")==null ? "" : request.getParameter("translator").trim();
		String price = request.getParameter("price")==null ? "" : request.getParameter("price").trim();
		
		Book book = new Book();
		book.setAuthor(author);
		book.setBookKind(bookKind);
		book.setBookName(bookName);
		book.setBorrowed(false);
		book.setIsbn(isbn);
		book.setPosition(position);
		book.setPress(press);
		book.setPrice(Integer.parseInt(price));
		book.setTranslator(translator);
		
		BookDao bookDao = new BookDao();
		boolean success = bookDao.addBook(book);
		if (success)
			response.sendRedirect(request.getContextPath() + "/admin/success.html");
		else
			response.sendRedirect(request.getContextPath() + "/admin/fail.html");
	}

}
