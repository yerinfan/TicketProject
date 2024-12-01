package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

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
	public MemberVO validateUser(String userId, String password) {
	    return memberDAO.findMemberByCredentials(userId, password); // 사용자 정보를 반환
	}
	
	public boolean registerMember(MemberVO member) {
		  try {
	            memberDAO.insertMember(member);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
}
