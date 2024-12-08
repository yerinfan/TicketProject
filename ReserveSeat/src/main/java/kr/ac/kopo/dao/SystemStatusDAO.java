package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.SystemStatusVO;

public class SystemStatusDAO {

	private SqlSession session;

	public SystemStatusDAO() {
		session = new MyConfig().getInstance();
	}

	public void updateStatus(SystemStatusVO vo) {
		session.update("Status.updateStatus", vo);
	}
}
