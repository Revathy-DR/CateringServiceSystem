package catering_service.entity;

public class Staff {
	
	private int staffId;
	private String staffName;
	private String staffPhone;
	private String staffAddress;
	public Staff(int staffId, String staffName, String staffPhone, String staffAddress) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPhone = staffPhone;
		this.staffAddress = staffAddress;
	}
	public Staff() {
		super();
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	
}
