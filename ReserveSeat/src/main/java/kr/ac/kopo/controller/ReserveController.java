package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.ReserveService;

public class ReserveController implements Controller {

    private ReserveService reserveService;

    public ReserveController() {
        reserveService = new ReserveService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userId = (String) request.getSession().getAttribute("userId");
            String classNo = request.getParameter("classNo");
            String regTime = request.getParameter("regTime");
            int seatRow = Integer.parseInt(request.getParameter("seatRow"));
            int seatCol = Integer.parseInt(request.getParameter("seatCol"));

            if (userId == null || classNo == null || regTime == null) {
                throw new IllegalArgumentException("필수 데이터가 누락되었습니다.");
            }

            // 예약 처리
            boolean isReserved = reserveService.reserveSeat(userId, classNo, regTime, seatRow, seatCol);

            if (isReserved) {
                request.setAttribute("classNo", classNo);
                request.setAttribute("seatNo", seatRow + "-" + seatCol);
                request.setAttribute("user", userId);
                return "/ticket/reserve/reserved.jsp";
            } else {
                request.setAttribute("errorMsg", "해당 좌석은 이미 예약되었습니다.");
                return "/error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "예약 처리 중 오류가 발생했습니다: " + e.getMessage());
            return "/error.jsp";
        }
    }
}
