package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import entity.Reader;

public class ReaderDao {
	public List<Reader> getAllReaders() {
		List<Reader> readers = new ArrayList<>();
		String sql = "select * from reader order by reader_type, reader_id ";
		Reader reader = null;
		
		try (Connection conn = DbUtil.getConnection();
				Statement st = conn.createStatement()) {
			try (ResultSet rs = st.executeQuery(sql)) {
				while (rs.next()) {
					reader = new Reader();
					reader.setEmail(rs.getString("email"));
					reader.setGender(rs.getString("gender"));
					reader.setPhone(rs.getString("phone"));
					reader.setReaderId(rs.getString("reader_id"));
					reader.setReaderName(rs.getString("reader_name"));
					reader.setReaderType(rs.getString("reader_type"));
					reader.setRegisterDate(LocalDate.parse(rs.getString("register_date")));
					
					readers.add(reader);
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return readers;
	}
	
	public boolean deleteReader(String readerId) {
		boolean flag = false;
		String sql = "delete from reader where reader_id=? ";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, readerId);
			
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return flag;
	}
}
