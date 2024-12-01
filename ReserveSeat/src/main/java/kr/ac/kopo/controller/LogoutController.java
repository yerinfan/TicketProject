package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 세션 무효화
        request.getSession().invalidate();
        // 로그인 페이지로 이동
        return "/ticket/member/loginForm.jsp";
    }
}
