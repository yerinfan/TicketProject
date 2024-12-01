package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.ReserveService;

public class ReservController implements Controller {
    private ReserveService reserveService = new ReserveService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String classNo = request.getParameter("classNo");
        String seatNo = request.getParameter("seatNo");
        String user = request.getParameter("user");

        if (classNo == null || seatNo == null || user == null) {
            throw new IllegalArgumentException("강의실 정보, 좌석 번호, 사용자 정보가 필요합니다.");
        }

        reserveService.reserveSeat(classNo, seatNo, user);

        // 예약 결과 페이지로 이동
        return "/ticket/reserve/reserved.jsp";
    }
}
