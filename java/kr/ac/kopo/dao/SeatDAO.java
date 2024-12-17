package kr.ac.kopo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.SeatSummaryVO;
import kr.ac.kopo.vo.SeatVO;

public class SeatDAO {

	private SqlSession session;

	public SeatDAO() {
		session = new MyConfig().getInstance();
	}

	// 좌석 정보 가져오기
	public List<SeatVO> getSeatsByRoomId(int roomId) {
		session.clearCache();
		return session.selectList("seat.getSeatsByRoomId", roomId);
	}

	// 좌석 상태 업데이트
	public boolean reserveSeat(String seatKey) {
		int rowsAffected = session.update("seat.updateSeat", seatKey);
		return rowsAffected > 0; // 업데이트 성공 여부 반환
	}

	public List<SeatSummaryVO> getSeatSummaries() {
		session.clearCache();
		return session.selectList("seat.getSeatSummaries");
	}

	public boolean updateSeatStatusToReserved(int seatId, int userId, int roomId) {
		int rowsUpdated = session.update("seat.updateSeatStatusToReserved", Map.of("seatId", seatId, "roomId", roomId));
		int rowsInserted = session.insert("seat.reserveSeat", Map.of("seatId", seatId, "userId", userId));
		session.commit();
		return rowsUpdated > 0 && rowsInserted > 0;
	}

	public boolean isDuplicateReservation(int userId, int roomId) {
		int count = session.selectOne("seat.checkDuplicateReservation", Map.of("userId", userId, "roomId", roomId));
		return count > 0;
	}

}
