package kr.ac.kopo.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.util.MyBatisConnectionFactory;

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
			isValidUser = count > 0; // count가 1 이상이면 유효한 사용자
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return isValidUser;
	}
}
