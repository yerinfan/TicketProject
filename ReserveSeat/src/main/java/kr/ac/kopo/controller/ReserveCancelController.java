package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.ReserveService;
import kr.ac.kopo.vo.MemberVO;

public class ReserveCancelController implements Controller {

    private ReserveService reservationService;

    public ReserveCancelController() {
        reservationService = new ReserveService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user");

        if (user == null) {
            request.setAttribute("errorMessage", "로그인이 필요합니다.");
            return "/ticket/member/loginForm.jsp";
        }

        String reservationIdParam = request.getParameter("reservationId");
        if (reservationIdParam == null) {
            request.setAttribute("errorMessage", "예약 ID가 필요합니다.");
            return "/error.jsp";
        }

        int reservationId;
        try {
            reservationId = Integer.parseInt(reservationIdParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "유효하지 않은 예약 ID입니다.");
            return "/error.jsp";
        }

        boolean isCancelled = reservationService.cancelReservation(reservationId, user.getUserId());
        if (!isCancelled) {
            request.setAttribute("errorMessage", "예약 취소에 실패했습니다.");
            return "/error.jsp";
        }

        return "/mypage/reservationCancelled.jsp"; // 예약 취소 성공 페이지
    }
}
