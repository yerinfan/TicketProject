package kr.ac.kopo.controller;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.GoogleLoginService;

public class GoogleLoginController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String idToken = request.getParameter("idToken");

            // ID 토큰 검증
            String email = GoogleLoginService.verifyGoogleToken(idToken);

            // 사용자 DB에 있는지 확인 및 세션 설정
            if (email != null) {
                request.getSession().setAttribute("user", email);
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("success", true);
                jsonResponse.put("name", email);

                response.setContentType("application/json");
                response.getWriter().write(jsonResponse.toString());
                return null;
            } else {
                throw new Exception("Invalid Google User.");
            }
        } catch (Exception e) {
            e.printStackTrace();

            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", false);
            jsonResponse.put("message", "Google 로그인 실패: " + e.getMessage());

            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
            return null;
        }
    }
}
