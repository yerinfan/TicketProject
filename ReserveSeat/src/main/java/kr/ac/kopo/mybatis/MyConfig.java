package kr.ac.kopo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {
	// myBatis를 설정함 (sqlSession 객체 생성 후 넘기기)
	private SqlSession session;

	public MyConfig() {
		String resource = "/kr/ac/kopo/mybatis/mybatis-config.xml";
		System.out.println("1");
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			System.out.println("2");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("3");
			session = sqlSessionFactory.openSession();
			System.out.println("4");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public SqlSession getInstance() {
		return session;
	}
}
