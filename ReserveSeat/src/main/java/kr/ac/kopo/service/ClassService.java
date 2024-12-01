package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.ClassDAO;
import kr.ac.kopo.vo.ClassVO;

public class ClassService {

    private ClassDAO classDAO;

    public ClassService() {
        classDAO = new ClassDAO();
    }

    public List<ClassVO> getSeatInfo(String classNo, String regTime) {
        return classDAO.getSeatInfo(classNo, regTime);
    }
}
