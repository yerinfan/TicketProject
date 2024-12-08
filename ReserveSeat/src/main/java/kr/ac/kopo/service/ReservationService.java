package kr.ac.kopo.service;

import kr.ac.kopo.dao.SystemStatusDAO;
import kr.ac.kopo.vo.SystemStatusVO;

public class ReservationService {
    private final SystemStatusDAO dao = new SystemStatusDAO();

    public void updateReservationStatus(String status) {
        SystemStatusVO vo = new SystemStatusVO();
        vo.setId(1); // 시스템 상태 ID
        vo.setReserveStatus(status);
        dao.updateStatus(vo);
    }
}
