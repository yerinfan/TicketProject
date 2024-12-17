package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.ConnectionFactory;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.ReservationVO;

public class ReserveDAO {

	private SqlSession session;

	public ReserveDAO() {
		session = new MyConfig().getInstance();
	}

	public List<ReservationVO> getReservationsByUserId(int userId) {
		session.clearCache();
		return session.selectList("reserve.getReservationsByUserId", userId);
	}

	// 좌석 예약 가능 여부 확인
	public boolean isSeatAvailable(String classNo, String time, String seatRow, String seatCol) {
		String sql = "SELECT COUNT(*) FROM rs_regist WHERE class_no = ? AND reg_time = ? AND seat_row = ? AND seat_col = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, classNo);
			pstmt.setString(2, time);
			pstmt.setString(3, seatRow);
			pstmt.setString(4, seatCol);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt(1) == 0) {
				return true; // 좌석 사용 가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // 좌석 이미 예약됨
	}

	// 좌석 예약 처리
	public boolean reserveSeat(String userId, String classNo, String regTime, int seatRow, int seatCol) {

		int result = session.insert("reserve.insertReserve", Map.of("userId", userId, "classNo", classNo, "regTime",
				regTime, "seatRow", seatRow, "seatCol", seatCol));
		session.commit();
		return result > 0;

	}

	// 강의실 잔여 좌석 업데이트
	public void updateLeftSeat(String classNo, int change) {
		String sql = "UPDATE rs_class SET left_seat = left_seat + ? WHERE class_no = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, change); // 좌석 수 변경 (예약: -1, 취소: +1)
			pstmt.setString(2, classNo);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
