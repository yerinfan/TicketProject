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
    	String userIdParam = request.getParameter("userId");
        String password = request.getParameter("password");

     // 유효성 검사
        if (userIdParam == null || userIdParam.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMsg", "아이디와 비밀번호를 입력해주세요.");
            return "/ticket/member/loginForm.jsp"; // 에러 페이지로 포워딩
        }
        
        int userId;
        userId = Integer.parseInt(userIdParam);
        MemberVO user = memberService.validateUser(userId, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // 일반 사용자 정보 저장
            return "/index.jsp"; // 메인 페이지로 이동
        } else {
            request.setAttribute("errorMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/ticket/member/loginForm.jsp"; // 로그인 실패 시
        }
    }
}
