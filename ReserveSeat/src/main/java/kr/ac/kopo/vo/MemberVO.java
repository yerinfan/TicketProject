package kr.ac.kopo.vo;

public class MemberVO {
	private String userId;
	private String name;
	private String password;
	private String nickname;
	private String regDate;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String userID, String name, String password, String nickname) {
		super();
		this.userId = userID;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
	}
	
	public MemberVO(String userID, String name, String password, String nickname, String regDate) {
		super();
		this.userId = userID;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.regDate = regDate;
	}

	public String getUserID() {
		return userId;
	}

	public void setUserID(String userID) {
		this.userId = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
