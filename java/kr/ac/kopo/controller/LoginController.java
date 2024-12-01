package kr.ac.kopo.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class LoginController implements Controller {
    
    private MemberService memberService;
    
    public LoginController() {
        memberService = new MemberService();
    }
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println("1");

        // 사용자가 유효한지 검증
        MemberVO user = memberService.validateUser(userId, password); // validateUser가 MemberVO 반환
        if (user != null) {
            System.out.println("로그인 성공");
            
            // 세션에 사용자 정보를 저장
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // user 객체를 세션에 저장
            
            return "/index.jsp"; // 로그인 성공 후 메인 페이지로 이동
        } else {
            System.out.println("로그인 실패");
            request.setAttribute("errorMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/ticket/member/loginForm.jsp"; // 로그인 실패 시 로그인 페이지로 이동
        }
    }
}
