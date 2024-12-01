package kr.ac.kopo.controller;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.ClassDAO;
import kr.ac.kopo.vo.ClassVO;

public class ClassDetailController implements Controller {
    private ClassDAO classDAO;

    public ClassDetailController() {
        classDAO = new ClassDAO();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String classNo = request.getParameter("classNo");
        String regTime = request.getParameter("regTime");

        if (classNo == null || regTime == null) {
            System.out.println("필수 파라미터가 누락되었습니다. classNo: " + classNo + ", regTime: " + regTime);
            request.setAttribute("errorMessage", "필수 파라미터가 누락되었습니다.");
            return "/error.jsp";
        }

        List<ClassVO> seatList = classDAO.getClassDetails(classNo, regTime);
        if (seatList == null || seatList.isEmpty()) {
            System.out.println("좌석 데이터가 없습니다. classNo: " + classNo + ", regTime: " + regTime);
            request.setAttribute("errorMessage", "좌석 데이터를 로드할 수 없습니다.");
            return "/error.jsp";
        }

        Map<String, ClassVO> seatMap = classDAO.mapSeatsByRowCol(seatList);
        request.setAttribute("seatMap", seatMap);
        request.setAttribute("classNo", classNo);
        request.setAttribute("regTime", regTime);

        // 강의실에 따라 다른 JSP로 이동
        switch (classNo) {
            case "A":
                return "/ticket/reserve/classDetailA.jsp";
            case "B":
                return "/ticket/reserve/classDetailB.jsp";
            case "C":
                return "/ticket/reserve/classDetailC.jsp";
            default:
                throw new IllegalArgumentException("잘못된 강의실 번호입니다.");
        }
    }

   
  //  @Override
  /*  public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String classNo = request.getParameter("classNo");
        String regTime = request.getParameter("regTime");

        if (classNo == null || regTime == null) {
            throw new IllegalArgumentException("필수 데이터가 누락되었습니다.");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("classNo", classNo);
        params.put("regTime", regTime);

        List<ClassVO> seatList = classDAO.getClassDetails(params);
        request.setAttribute("seatList", seatList);
        request.setAttribute("classNo", classNo);
        request.setAttribute("regTime", regTime);
        Map<String, ClassVO> seatMap = classDAO.mapSeatsByRowCol(seatList);
        request.setAttribute("seatMap", seatMap);

        // 강의실에 따라 다른 JSP로 이동
        switch (classNo) {
            case "A":
                return "/ticket/reserve/classDetailA.jsp";
            case "B":
                return "/ticket/reserve/classDetailB.jsp";
            case "C":
                return "/ticket/reserve/classDetailC.jsp";
            default:
                throw new IllegalArgumentException("잘못된 강의실 번호입니다.");
        }
    }*/
}
