package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import entity.Book;

public class BookDao {
	
	public boolean returnBook(int bookId) {
		boolean flag = false;
		String sql = "update book set is_borrowed=false where book_id=? ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bookId);
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean borrow(Book book) {
		String sql = "update book set is_borrowed=true where book_id=? ";
		boolean flag = false;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, book.getBookId());
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public Book getById(int bookId) {
		String sql = "select * from book where book_id=? ";
		Book book = null;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bookId);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					book = new Book();
					book.setAuthor(rs.getString("author"));
					book.setBookId(rs.getInt("book_id"));
					book.setBookKind(rs.getString("book_kind"));
					book.setBookName(rs.getString("book_name"));
					book.setIsbn(rs.getString("isbn"));
					book.setPosition(rs.getString("position"));
					book.setPress(rs.getString("press"));
					book.setPrice(rs.getFloat("price"));
					book.setTranslator(rs.getString("translator"));
					book.setBorrowed(rs.getBoolean("is_borrowed"));
					
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return book;
	}
	
	public boolean addBook(Book book) {
		String sql = " insert book(book_name, book_kind, author, "
				+ "translator, isbn, price, press, position, is_borrowed) "
				+ "values(?,?,?,?,?,?,?,?,?) ";
		boolean flag = false;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookKind());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getTranslator());
			ps.setString(5, book.getIsbn());
			ps.setFloat(6, book.getPrice());
			ps.setString(7, book.getPress());
			ps.setString(8, book.getPosition());
			ps.setBoolean(9, book.isBorrowed());
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean deleteBook(int bookId) {
		boolean flag = false;
		String sql = "delete from book where book_id=? ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bookId);
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return flag;
	}
	public List<Book> searchByName(String keyword) {
		List<Book> books = new ArrayList<>();
		Book book = null;
		String sql = "select * from book where book_name=? ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, keyword);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					book = new Book();
					book.setAuthor(rs.getString("author"));
					book.setBookId(rs.getInt("book_id"));
					book.setBookKind(rs.getString("book_kind"));
					book.setBookName(rs.getString("book_name"));
					book.setIsbn(rs.getString("isbn"));
					book.setPosition(rs.getString("position"));
					book.setPress(rs.getString("press"));
					book.setPrice(rs.getFloat("price"));
					book.setTranslator(rs.getString("translator"));
					book.setBorrowed(rs.getBoolean("is_borrowed"));
					
					books.add(book);
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return books;
	}
	
	public List<Book> searchByIsbn(String keyword) {
		String sql = "select * from book where isbn=? ";
		Book book = null;
		List<Book> books = new ArrayList<>();
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, keyword);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					book = new Book();
					book.setAuthor(rs.getString("author"));
					book.setBookId(rs.getInt("book_id"));
					book.setBookKind(rs.getString("book_kind"));
					book.setBookName(rs.getString("book_name"));
					book.setIsbn(rs.getString("isbn"));
					book.setPosition(rs.getString("position"));
					book.setPress(rs.getString("press"));
					book.setPrice(rs.getFloat("price"));
					book.setTranslator(rs.getString("translator"));
					book.setBorrowed(rs.getBoolean("is_borrowed"));
					
					books.add(book);
				} 
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return books;
	}
	
	public List<Book> searchByPress(String keyword) {
		List<Book> books = new ArrayList<>();
		Book book = null;
		String sql = "select * from book where press=? ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, keyword);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					book = new Book();
					book.setAuthor(rs.getString("author"));
					book.setBookId(rs.getInt("book_id"));
					book.setBookKind(rs.getString("book_kind"));
					book.setBookName(rs.getString("book_name"));
					book.setIsbn(rs.getString("isbn"));
					book.setPosition(rs.getString("position"));
					book.setPress(rs.getString("press"));
					book.setPrice(rs.getFloat("price"));
					book.setTranslator(rs.getString("translator"));
					book.setBorrowed(rs.getBoolean("is_borrowed"));
					
					books.add(book);
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return books;
	}
	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Book book = null;
		String sql = " select * from book ";
		try (Connection conn = DbUtil.getConnection();
				Statement st = conn.createStatement()) {
			try (ResultSet rs = st.executeQuery(sql)) {
				while (rs.next()) {
					book = new Book();
					book.setAuthor(rs.getString("author"));
					book.setBookId(rs.getInt("book_id"));
					book.setBookKind(rs.getString("book_kind"));
					book.setBookName(rs.getString("book_name"));
					book.setBorrowed(rs.getBoolean("is_borrowed"));
					book.setIsbn(rs.getString("isbn"));
					book.setPosition(rs.getString("position"));
					book.setPress(rs.getString("press"));
					book.setPrice(rs.getFloat("price"));
					book.setTranslator(rs.getString("translator"));
					
					books.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
