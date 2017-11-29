package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import db.DbUtil;
import entity.Book;
import entity.Reader;

public class BorrowHistoryDao {
	
	public boolean updateHistory(String readerId, int bookId, float fine) {
		String sql = "update borrow_history set back_time=?, fine=? where reader_id=? and book_id=? ";
		boolean flag = false;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, LocalDate.now().toString());
			ps.setFloat(2, fine);
			ps.setString(3, readerId);
			ps.setInt(4, bookId);
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean addHistory(Book book, Reader reader) {
		String sql = "insert borrow_history(book_id, book_name, reader_id, reader_name, borrow_time) "
				+ "values(?,?,?,?,?) ";
		boolean flag = false;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, reader.getReaderId());
			ps.setString(4, reader.getReaderName());
			ps.setString(5, LocalDate.now().toString());
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
