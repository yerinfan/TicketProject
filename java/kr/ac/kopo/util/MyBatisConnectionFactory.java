package kr.ac.kopo.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // MyBatis 설정 파일 읽기
            String resource = "/kr/ac/kopo/mybatis/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            
            // SqlSessionFactory 빌드
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("MyBatis 설정 파일 로드 중 오류 발생");
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
