package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class RegisterController implements Controller {
    private MemberService memberService;

    public RegisterController() {
        memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");

        MemberVO user = memberService.findByEmail(email);

        HttpSession session = request.getSession();
        if (user != null) {
            // 네이버 로그인 사용자 정보 세션에 저장
            session.setAttribute("user", user);
            return "/index.jsp"; // 메인 페이지로 이동
        } else {
            // 회원 가입 유도
            request.setAttribute("email", email);
            request.setAttribute("nickname", nickname);
            return "/ticket/member/register.jsp"; // 회원 가입 페이지로 이동
        }
    }
}
