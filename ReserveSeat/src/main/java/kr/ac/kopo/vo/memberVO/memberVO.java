package kr.ac.kopo.vo.memberVO;

public class memberVO {
	private int userID;
	private String user;
	private String password;
	private String nickname;
	private String regDate;
	
	public memberVO(int userID, String user, String password, String nickname, String regDate) {
		super();
		this.userID = userID;
		this.user = user;
		this.password = password;
		this.nickname = nickname;
		this.regDate = regDate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
