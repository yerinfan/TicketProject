package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.MemberService;

public class LinkAccountController implements Controller {
    private MemberService memberService;

    public LinkAccountController() {
        memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String linkUserId = request.getParameter("linkUserId");
        String linkPassword = request.getParameter("linkPassword");
        String email = request.getParameter("email");

        boolean isLinked = memberService.linkAccount(linkUserId, linkPassword, email);

        if (isLinked) {
            request.setAttribute("message", "계정 연동 성공!");
        } else {
            request.setAttribute("message", "계정 연동 실패. 정보를 확인하세요.");
        }

        return "/ticket/member/linkResult.jsp";
    }
}
