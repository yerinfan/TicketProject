package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.ClassVO;

public class ClassDAO {

	private SqlSession session;

	public ClassDAO() {
		session = new MyConfig().getInstance();
	}

	public List<ClassVO> getClassDetails(Map<String, Object> params) {
		// MyBatis 쿼리 호출
		session.clearCache();
		return session.selectList("class.getClassDetails", params);
	}

	public List<ClassVO> getClassDetails(String classNo, String regTime) {
		session.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("classNo", classNo);
		params.put("regTime", regTime);

//	    System.out.println("Fetc	hing data with params: " + params);

		List<ClassVO> result = session.selectList("class.getClassDetails", params);
//	    System.out.println(result);

		if (result == null || result.isEmpty()) {
			System.out.println("좌석 데이터가 존재하지 않습니다.");
		} else {
			for (ClassVO seat : result) {
//	            System.out.println("Fetched Seat Data: " + seat);
			}
		}
		return result;
	}

	public Map<String, ClassVO> mapSeatsByRowCol(List<ClassVO> seatList) {
		Map<String, ClassVO> seatMap = new HashMap<>();
		if (seatList == null || seatList.isEmpty()) {
			System.out.println("seatList가 비어 있습니다.");
			return seatMap;
		}

		for (ClassVO seat : seatList) {
			if (seat == null) {
				System.out.println("좌석 정보가 null입니다.");
				continue; // null 데이터를 무시
			}
			String key = seat.getSeatRow() + "-" + seat.getSeatCol();
			System.out.println("Mapping seat: " + key + " -> " + seat);
			seatMap.put(key, seat);
		}

		return seatMap;
	}

	public ClassVO getSeat(String seatKey, String classNo, String regTime) {
		session.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("seatKey", seatKey);
		params.put("classNo", classNo);
		params.put("regTime", regTime);
		System.out.println(params);

		return session.selectOne("class.selectSeat", params);
	}

	public boolean reserveSeat(String seatKey, String classNo, String regTime, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("seatKey", seatKey);
		params.put("classNo", classNo);
		params.put("regTime", regTime);
	    params.put("reservedBy", userId); // 사용자 ID 추가

		System.out.println(params);

		params.put("isEmpty", "N");
		int rowsAffected = session.update("class.reserveSeat", params);
		
	    session.commit();
		return rowsAffected > 0;
	}

	public List<ClassVO> getReservedSeats(String userId) {
		session.clearCache();
		System.out.println("getReservedSeats userId : " + userId);
	    return session.selectList("class.getReservedSeats", userId);
	}

	
}
