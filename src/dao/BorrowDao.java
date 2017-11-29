package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;

import db.DbUtil;
import entity.Book;
import entity.Reader;

public class BorrowDao {
	@Test
	public void test() {
		int count = getOverTimeCnt("15090128");
		System.out.println(count);
	}
	
	public int overTime(int bookId) {
		String sql = "select back_time from borrow where book_id=? ";
		int days = 0;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bookId);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					LocalDate backTime = LocalDate.parse(rs.getString("back_time"));
					LocalDate today = LocalDate.now();
					if (backTime.isBefore(today)) {
						days = backTime.until(today).getDays();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return days;
	}
	
	public boolean returnBook(int bookId) {
		String sql = "delete from borrow where book_id=? ";
		boolean flag = false;
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
	
	public String getReader(int bookId) {
		String sql = "select reader_id from borrow where book_id=? ";
		String readerId = null;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bookId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					readerId = rs.getString("reader_id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return readerId;
	}
	
	public boolean borrow(Book book, Reader reader) {
		String sql = "insert borrow values(?,?,?,?,?)";
		boolean flag = false;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, book.getBookId());
			ps.setString(2, reader.getReaderId());
			ps.setString(3, LocalDate.now().toString());
			ps.setString(4, LocalDate.now().plusMonths(1).toString());
			ps.setBoolean(5, false);
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int getBorrowedCnt(String readerId) {
		int cnt = 0;
		String sql = "select COUNT(book_id) from borrow where reader_id=? AND is_backed=false ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, readerId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					cnt = rs.getInt("COUNT(book_id)");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int getOverTimeCnt(String readerId) {
		int cnt = 0;
		String sql = "select back_time from borrow where reader_id=? AND is_backed=false ";
		LocalDate today = LocalDate.now();
		LocalDate backTime = null;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, readerId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					backTime = LocalDate.parse(rs.getString("back_time"));
					if (backTime.isBefore(today))
						cnt++;
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
