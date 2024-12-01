package kr.ac.kopo.service;

import kr.ac.kopo.dao.ReserveDAO;

public class ReserveService {

    private ReserveDAO reserveDAO;

    public ReserveService() {
        reserveDAO = new ReserveDAO();
    }

    public boolean reserveSeat(String userId, String classNo, String regTime, int seatRow, int seatCol) {
        return reserveDAO.reserveSeat(userId, classNo, regTime, seatRow, seatCol);
    }
}
