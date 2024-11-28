package kr.ac.kopo.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.MemberService;

public class LoginController implements Controller {
	
	private MemberService memberService;
	
	public LoginController() {
		memberService = new MemberService();
	}
	
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        
        boolean isValidUser = memberService.validateUser(userId, password);

        if (isValidUser) {
            request.getSession().setAttribute("userId", userId);
            return "/index.jsp"; // 로그인 성공 후 메인 페이지로 이동
        } else {
            request.setAttribute("errorMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/ticket/member/loginForm.jsp"; // 로그인 실패 시 로그인 페이지로 다시 이동
        }
    }
}
