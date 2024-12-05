package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class CheckMemberController implements Controller {
    private MemberService memberService;

    public CheckMemberController() {
        memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");

        MemberVO existingMember = memberService.findByEmail(email);

        if (existingMember != null) {
            // 이미 회원인 경우 로그인 처리
            HttpSession session = request.getSession();
            session.setAttribute("user", existingMember);
            return "/ReserveSeat/index.jsp"; // 메인 페이지로 이동
        } else {
            // 회원이 아닌 경우 회원가입 페이지로 이동
            request.setAttribute("email", email);
            request.setAttribute("nickname", nickname);
            return "/ReserveSeat/ticket/member/registerForm.jsp"; // 회원가입 페이지로 이동
        }
    }
}
