package kr.ac.kopo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NaverCallbackController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getParameter("access_token"); // 네이버에서 제공한 액세스 토큰
        if (token == null || token.isEmpty()) {
            request.setAttribute("errorMsg", "로그인 실패: 액세스 토큰을 찾을 수 없습니다.");
            return "/error.jsp"; // 에러 페이지
        }

        // 사용자 프로필 요청
        String apiURL = "https://openapi.naver.com/v1/nid/me";
        HttpURLConnection con = (HttpURLConnection) new URL(apiURL).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + token);

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            br.close();

            // 프로필 정보 파싱
            JSONObject jsonResponse = new JSONObject(responseBuilder.toString());
            JSONObject profile = jsonResponse.getJSONObject("response");

            String email = profile.getString("email");
            String nickname = profile.getString("nickname");

            // 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("nickname", nickname);

            // 메인 페이지로 리다이렉트
            return "redirect:/index.jsp";
        } else {
            request.setAttribute("errorMsg", "로그인 실패: 네이버 프로필 정보를 가져올 수 없습니다.");
            return "/error.jsp"; // 에러 페이지
        }
    }
}
