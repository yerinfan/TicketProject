package kr.ac.kopo.service;

import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.dao.MemberDAO;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService() {
		System.out.println("MemberService 생성자 호출");
		memberDAO = new MemberDAO();
	}

	/**
	 * 로그인 유효성 검사
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean validateUser(String userId, String password) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("password", password);

		return memberDAO.checkLogin(paramMap);
	}
}
