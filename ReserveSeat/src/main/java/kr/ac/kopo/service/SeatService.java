package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.SeatDAO;
import kr.ac.kopo.vo.SeatSummaryVO;
import kr.ac.kopo.vo.SeatVO;

public class SeatService {

    private SeatDAO seatDAO;

    public SeatService() {
        seatDAO = new SeatDAO();
    }

    public List<SeatSummaryVO> getSeatSummaries() {
        return seatDAO.getSeatSummaries();
    }
    
    public List<SeatVO> getSeatsByRoomId(int roomId) {
        return seatDAO.getSeatsByRoomId(roomId);
    }
    
    public boolean isDuplicateReservation(int userId, int roomId) {
        return seatDAO.isDuplicateReservation(userId, roomId);
    }
    
    public boolean reserveSeat(int seatId, int userId, int roomId) {
        return seatDAO.updateSeatStatusToReserved(seatId, userId, roomId);
    }
}
