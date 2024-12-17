package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
	}

	/**
	 * 로그인 유효성 검사
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public MemberVO validateUser(int userId, String password) {
		return memberDAO.findMemberByCredentials(userId, password); // 사용자 정보를 반환
	}

    public boolean isMember(String email) {
        return memberDAO.findByEmail(email) != null;
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
	
	

    public boolean isMemberByEmail(String email) {
        return memberDAO.findByEmail(email) != null;
    }
    
    public boolean linkAccount(int userId, String password, String email) {
        MemberVO existingMember = memberDAO.findMemberByCredentials(userId, password);
        if (existingMember != null) {
            return memberDAO.updateMemberEmail(userId, email) > 0;
        }
        return false;
    }

	public MemberVO findByEmail(String email) {
		return memberDAO.findByEmail(email);
	}
}
