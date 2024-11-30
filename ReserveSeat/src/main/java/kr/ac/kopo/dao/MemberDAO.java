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

	public void insertMember(MemberVO member) throws Exception {
        session.insert("member.insertMember", member);
        session.commit();
	}
}
