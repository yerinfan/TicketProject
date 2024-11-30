package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReserveSeatController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // reserve/list.do에서 오는 요청 처리
        String classNo = request.getParameter("classNo");
        String time = request.getParameter("time");

        if (classNo == null || time == null) {
            throw new IllegalArgumentException("강의실 정보와 시간은 필수입니다.");
        }

        // 강의실 정보 저장
        request.setAttribute("classNo", classNo);
        request.setAttribute("time", time);

        // 강의실 상세 페이지로 이동
        return "/ticket/reserve/detail.jsp";
    }
}
