package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;

import db.DbUtil;

public class BorrowDao {
	@Test
	public void test() {
		int count = getOverTimeCnt("15090128");
		System.out.println(count);
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
