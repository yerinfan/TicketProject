package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.SeatService;
import kr.ac.kopo.vo.SeatSummaryVO;

public class SeatListController implements Controller {

    private SeatService seatService;

    public SeatListController() {
        seatService = new SeatService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<SeatSummaryVO> seatSummaries = seatService.getSeatSummaries();
        System.out.println(seatSummaries.toString());
        
        if (seatSummaries == null || seatSummaries.isEmpty()) {
            request.setAttribute("errorMessage", "강의실 데이터를 불러올 수 없습니다.");
            return "/error.jsp";
        }

        request.setAttribute("seatSummaries", seatSummaries);
        return "/ticket/reserve/list.jsp";
    }
}
