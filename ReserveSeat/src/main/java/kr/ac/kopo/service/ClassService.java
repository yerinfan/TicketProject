package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.ClassDAO;
import kr.ac.kopo.vo.SeatVO;

public class ClassService {

    private ClassDAO classDAO;

    public ClassService() {
        classDAO = new ClassDAO();
    }

    public List<SeatVO> getSeat(String seatKey, int classNo) {
        return classDAO.getSeat(seatKey, classNo);
    }
}
