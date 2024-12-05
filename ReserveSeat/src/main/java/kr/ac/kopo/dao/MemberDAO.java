package kr.ac.kopo.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.util.MyBatisConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {
	private SqlSession session;
	private SqlSessionFactory sqlSessionFactory;

	public MemberDAO() {
		System.out.println("MemberDAO 생성자 호출");
		session = new MyConfig().getInstance();
		System.out.println("session호출");
		this.sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		System.out.println("sessionfactory호출");
	}

	/**
	 * 데이터베이스에서 사용자 확인
	 * 
	 * @param paramMap
	 * @return boolean
	 */
	public boolean checkLogin(Map<String, String> paramMap) {
		SqlSession session = null;
		boolean isValidUser = false;

		try {
			session = sqlSessionFactory.openSession();
			int count = session.selectOne("member.checkLogin", paramMap);
			System.out.println(paramMap);
			System.out.println(count);
			isValidUser = count > 0; // count가 1 이상이면 유효한 사용자
			System.out.println("멤버 다오 속 :" + isValidUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return isValidUser;
	}

    public MemberVO findByEmail(String email) {
        return session.selectOne("member.findByEmail", email);
    }
	
	public MemberVO findMemberByGoogleId(String userId) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne("member.findByGoogleId", userId);
		}
	}

    public MemberVO findMemberByCredentials(String userId, String password) {
        MemberVO params = new MemberVO();
        params.setUserId(userId);
        params.setPassword(password);
        return session.selectOne("member.findByCredentials", params);
    }

	public void insertMember(MemberVO member) throws Exception {
		session.insert("member.insertMember", member);
		session.commit();
	}

	public boolean insertMember2(MemberVO member) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int rows = session.insert("member.insertMember", member);
			session.commit();
			return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MemberVO findMemberByEmail(String email) {
		return session.selectOne("member.findByEmail", email);
	}

    public int updateMemberEmail(String userId, String email) {
        MemberVO params = new MemberVO();
        params.setUserId(userId);
        params.setEmail(email);
        return session.update("member.updateEmail", params);
    }
}
