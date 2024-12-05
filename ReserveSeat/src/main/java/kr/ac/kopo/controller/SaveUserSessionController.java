package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SaveUserSessionController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");

        if (email != null && !email.isEmpty()) {
            // 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            session.setAttribute("userNickname", nickname);

            response.getWriter().write("SUCCESS");
        } else {
            response.getWriter().write("ERROR");
        }

        return null; // Ajax 요청이므로 뷰를 반환하지 않음
    }
}
