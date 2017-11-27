package entity;

import java.time.LocalDate;

public class Borrow {
	
	private int bookId;
	private String readerId;
	private LocalDate borrowTime;
	private LocalDate backTime;
	private boolean isBccked;
	
	public Borrow() {}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public LocalDate getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(LocalDate borrowTime) {
		this.borrowTime = borrowTime;
	}

	public LocalDate getBackTime() {
		return backTime;
	}

	public void setBackTime(LocalDate backTime) {
		this.backTime = backTime;
	}

	public boolean isBccked() {
		return isBccked;
	}

	public void setBccked(boolean isBccked) {
		this.isBccked = isBccked;
	}

	@Override
	public String toString() {
		return "Borrow [bookId=" + bookId + ", readerId=" + readerId + ", borrowTime=" + borrowTime + ", backTime="
				+ backTime + ", isBccked=" + isBccked + "]";
	}
	
	
}
