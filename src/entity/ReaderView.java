package entity;

public class ReaderView {
	private String readerId;
	private String readerName;
	private String readerType;
	private int totalCnt;
	private int backCnt;
	private int overTimeCnt;
	
	public ReaderView() {}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderType() {
		return readerType;
	}

	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getBackCnt() {
		return backCnt;
	}

	public void setBackCnt(int backCnt) {
		this.backCnt = backCnt;
	}

	public int getOverTimeCnt() {
		return overTimeCnt;
	}

	public void setOverTimeCnt(int overTimeCnt) {
		this.overTimeCnt = overTimeCnt;
	}

	@Override
	public String toString() {
		return "ReaderView [readerId=" + readerId + ", readerName=" + readerName + ", readerType=" + readerType
				+ ", totalCnt=" + totalCnt + ", backCnt=" + backCnt + ", overTimeCnt=" + overTimeCnt + "]";
	}
	
	
}
