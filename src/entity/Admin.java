package entity;

public class Admin {
	private int jobId;
	private String password;
	private String adminName;
	
	public Admin() {}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [jobId=" + jobId + ", password=" + password + ", adminName=" + adminName + "]";
	}
	
	
}
