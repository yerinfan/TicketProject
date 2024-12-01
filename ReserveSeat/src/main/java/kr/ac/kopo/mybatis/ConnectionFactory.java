package kr.ac.kopo.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection 인스턴스를 생성하여 반환하거나 제거하는 기능을 선언된 클래스
//=> JDBC프로그램 작성에 필요한 공통적인 명령들을 메소드 제공
//=> 프로그램의 생산성이 향상 및 유지보수 효율성 증가
public class ConnectionFactory {
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Connection인스턴스를 생성할 수 없습니다.");
		}
		return con;
	}

	public static void close(Connection con, Statement stmt, ResultSet rs) {

		try {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {

		}

	}

}