package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Reader implements Serializable{
	
	private static final long serialVersionUID = 2073400348486442555L;

	
	private String readerId;
	private String password;
	private String readerType;
	private String readerName;
	private LocalDate registerDate;
	private String gender;
	private String phone;
	private String email;
	
	public Reader() {}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReaderType() {
		return readerType;
	}

	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", password=" + password + ", readerType=" + readerType
				+ ", readerName=" + readerName + ", registerDate=" + registerDate + ", gender=" + gender + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
}
