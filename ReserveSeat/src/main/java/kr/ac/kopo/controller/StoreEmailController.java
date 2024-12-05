package kr.ac.kopo.controller;

import java.io.BufferedReader;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class StoreEmailController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        JSONObject json = new JSONObject(sb.toString());
        String email = json.getString("email");

        // 이메일 정보를 세션에 저장
        session.setAttribute("naverEmail", email);

        // 응답
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": true}");
        return null; // 별도 JSP로 이동하지 않음
    }
}
