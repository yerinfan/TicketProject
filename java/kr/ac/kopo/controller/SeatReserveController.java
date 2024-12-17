package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.SeatService;
import kr.ac.kopo.vo.MemberVO;

public class SeatReserveController implements Controller {

    private SeatService seatService;

    public SeatReserveController() {
        seatService = new SeatService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user"); // 로그인 사용자 정보 가져오기

        if (user == null) {
            request.setAttribute("errorMessage", "로그인이 필요합니다.");
            return "/ticket/member/loginForm.jsp";
        }

        String seatIdParam = request.getParameter("seatId");
        String roomIdParam = request.getParameter("roomId");

        if (seatIdParam == null || roomIdParam == null) {
            request.setAttribute("errorMessage", "좌석 또는 강의실 정보가 누락되었습니다.");
            return "/error.jsp";
        }

        int seatId, roomId;
        try {
            seatId = Integer.parseInt(seatIdParam);
            roomId = Integer.parseInt(roomIdParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "유효하지 않은 좌석 또는 강의실 정보입니다.");
            return "/error.jsp";
        }
        
        // 동일 강의실 중복 예약 확인
        boolean isDuplicate = seatService.isDuplicateReservation(user.getUserId(), roomId);
        if (isDuplicate) {
            request.setAttribute("errorMessage", "같은 강의실에서 두 좌석 이상 예약할 수 없습니다.");
            return "/error.jsp";
        }
        
        System.out.println("선택된 Seat ID: " + seatId + ", Room ID: " + roomId);

        boolean isReserved = seatService.reserveSeat(seatId, user.getUserId(), roomId);
        if (!isReserved) {
            request.setAttribute("errorMessage", "좌석 선점에 실패했습니다. 다른 좌석을 선택해 주세요.");
            return "/error.jsp";
        }

        // 선점 성공 시 정보를 전달
        request.setAttribute("seatId", seatId);
        request.setAttribute("roomId", roomId);
        request.setAttribute("userName", user.getName());
        request.setAttribute("userNickname", user.getNickname());
        return "/ticket/reserve/reserveSuccess.jsp";
    }
}
