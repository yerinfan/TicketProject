package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.ClassDAO;
import kr.ac.kopo.vo.ClassVO;
import kr.ac.kopo.vo.MemberVO;

public class ReserveSeatController implements Controller {
	
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String seatKey = request.getParameter("seatKey");
    	String classNo = request.getParameter("classNo");
    	String regTime = request.getParameter("regTime");
        
        // 세션에서 userId 가져오기
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user"); // 세션에서 MemberVO 가져오기
        String userId = user.getUserId();
        
        ClassDAO classDAO = new ClassDAO();
        System.out.println("seatKey: " + seatKey);
        System.out.println("classNo: " + classNo);
        System.out.println("regTime: " + regTime);

        
        ClassVO seat = classDAO.getSeat(seatKey, classNo, regTime);

        if (seat != null && "Y".equals(seat.getIsEmpty())) {
            boolean success = classDAO.reserveSeat(seatKey, classNo, regTime, userId);
            if (success) {
                request.setAttribute("message", "좌석 예약 성공!");
            } else {
                request.setAttribute("message", "좌석 예약 실패: 이미 예약된 좌석입니다.");
            }
        } else {
            request.setAttribute("message", "유효하지 않은 좌석입니다.");
        }

        return "/ticket/reserve/reserved.jsp"; // 결과 페이지로 이동
    }
}
