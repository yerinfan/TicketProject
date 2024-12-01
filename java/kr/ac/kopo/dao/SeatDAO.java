package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.SeatVO;

public class SeatDAO {
	
	private SqlSession session;

	public SeatDAO() {
		session = new MyConfig().getInstance();
	}
	
	   // 좌석 정보 가져오기
    public SeatVO getSeat(String seatKey) {
        return session.selectOne("Seat.selectSeat", seatKey);
    }

    // 좌석 상태 업데이트
    public boolean reserveSeat(String seatKey) {
        int rowsAffected = session.update("Seat.updateSeat", seatKey);
        return rowsAffected > 0; // 업데이트 성공 여부 반환
    }
}
