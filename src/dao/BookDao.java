package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import entity.Book;

public class BookDao {
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
}
