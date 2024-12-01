package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.ReserveService;

public class ConfirmReserveController implements Controller {

    private ReserveService reserveService;

    public ConfirmReserveController() {
        this.reserveService = new ReserveService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String classNo = request.getParameter("classNo");
        String seatRow = request.getParameter("seatRow");
        String seatCol = request.getParameter("seatCol");
        String time = request.getParameter("time");

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            request.setAttribute("error", "로그인이 필요합니다.");
            return "/ticket/member/loginForm.jsp";
        }

        boolean isReserved = reserveService.reserveSeat(userId, classNo, time, seatRow, seatCol);

        if (isReserved) {
            request.setAttribute("classNo", classNo);
            request.setAttribute("seatNo", seatRow + "-" + seatCol);
            request.setAttribute("user", userId);
            return "/ticket/reserve/reserved.jsp"; // 예약 성공 페이지
        } else {
            request.setAttribute("error", "선택한 좌석이 이미 예약되었습니다.");
            return "/error.jsp";
        }
    }
}
