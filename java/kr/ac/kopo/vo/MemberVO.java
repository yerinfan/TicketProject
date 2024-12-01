package kr.ac.kopo.vo;

public class MemberVO {
	private String userId;
	private String name;
	private String password;
	private String nickname;
	private String regDate;
	private String email;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String userId, String name, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public MemberVO(String userID, String name, String password, String email ,String nickname) {
		super();
		this.userId = userID;
		this.name = name;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
	}
	
	public MemberVO(String userID, String name, String password, String nickname) {
		super();
		this.userId = userID;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.regDate = regDate;
	}

	public MemberVO(String userId, String name, String password, String nickname, String regDate, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.regDate = regDate;
		this.email = email;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
