package kr.ac.kopo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.SeatService;
import kr.ac.kopo.vo.SeatVO;

public class SeatDetailController implements Controller {

    private SeatService seatService;

    public SeatDetailController() {
        seatService = new SeatService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String roomIdParam = request.getParameter("roomId");

        if (roomIdParam == null) {
            System.out.println("필수 파라미터가 누락되었습니다. roomId: " + roomIdParam);
            request.setAttribute("errorMessage", "필수 파라미터가 누락되었습니다.");
            return "/error.jsp";
        }

        int roomId;
        try {
            roomId = Integer.parseInt(roomIdParam);
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 roomId: " + roomIdParam);
            request.setAttribute("errorMessage", "유효하지 않은 강의실 번호입니다.");
            return "/error.jsp";
        }

        List<SeatVO> seatList = seatService.getSeatsByRoomId(roomId);
        if (seatList == null || seatList.isEmpty()) {
            System.out.println("좌석 데이터가 없습니다. roomId: " + roomId);
            request.setAttribute("errorMessage", "좌석 데이터를 로드할 수 없습니다.");
            return "/error.jsp";
        }

        // 좌석 정보를 행-열로 매핑
        Map<String, SeatVO> seatMap = seatList.stream()
                .collect(Collectors.toMap(
                        seat -> seat.getRowNumber() + "-" + seat.getColumnNumber(),
                        seat -> seat
                ));

        request.setAttribute("seatMap", seatMap);
        request.setAttribute("seatList", seatList); // 전체 좌석 리스트도 전달
        request.setAttribute("roomId", roomId);

        // 강의실에 따라 다른 JSP로 이동
        switch (roomId) {
            case 1:
                return "/ticket/reserve/classDetailA.jsp";
            case 2:
                return "/ticket/reserve/classDetailB.jsp";
            case 3:
                return "/ticket/reserve/classDetailC.jsp";
            default:
                throw new IllegalArgumentException("잘못된 강의실 번호입니다.");
        }
    }
}
