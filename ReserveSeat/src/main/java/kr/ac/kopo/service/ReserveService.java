package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.ReserveDAO;
import kr.ac.kopo.vo.ReservationVO;

public class ReserveService {

    private ReserveDAO reserveDAO;

    public ReserveService() {
        reserveDAO = new ReserveDAO();
    }

    public boolean reserveSeat(String userId, String classNo, String regTime, int seatRow, int seatCol) {
        return reserveDAO.reserveSeat(userId, classNo, regTime, seatRow, seatCol);
    }
    
    public List<ReservationVO> getReservationsByUserId(int userId) {
        return reserveDAO.getReservationsByUserId(userId);
    }
    
    public boolean cancelReservation(int reservationId, int userId) {
        return reserveDAO.cancelReservation(reservationId, userId);
    }

}
