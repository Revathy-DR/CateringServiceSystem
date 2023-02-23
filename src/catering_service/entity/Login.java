package catering_service.entity;

public class Login {
	
	private int loginId;
	private String userNAme;
	private String password;
	
	public Login() {
		super();
	}
	
	public Login(int loginId, String userNAme, String password) {
		super();
		this.loginId = loginId;
		this.userNAme = userNAme;
		this.password = password;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserNAme() {
		return userNAme;
	}

	public void setUserNAme(String userNAme) {
		this.userNAme = userNAme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
