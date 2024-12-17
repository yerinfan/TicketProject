package kr.ac.kopo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class ProcessTokenController implements Controller {

    private MemberService memberService;

    public ProcessTokenController() {
        memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // JSON 파라미터 추출
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        JSONObject json = new JSONObject(sb.toString());
        String accessToken = json.getString("accessToken");

        // 네이버 사용자 정보 API 호출
        URL url = new URL("https://openapi.naver.com/v1/nid/me");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responseBuffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();

            // 사용자 정보 JSON 파싱
            JSONObject userInfo = new JSONObject(responseBuffer.toString());
            String email = userInfo.getJSONObject("response").getString("email");

            // 이메일로 회원 여부 확인
            MemberVO member = memberService.findByEmail(email);
            if (member != null) {
                // 로그인 성공 처리
                request.getSession().setAttribute("user", member);
                response.setContentType("application/json");
                response.getWriter().write(new JSONObject().put("success", true).toString());
            } else {
                // 회원 등록 필요
                response.setContentType("application/json");
                response.getWriter().write(new JSONObject().put("success", false).put("message", "register").toString());
            }
        } else {
            // API 호출 실패
            response.setContentType("application/json");
            response.getWriter().write(new JSONObject().put("success", false).put("message", "api_error").toString());
        }

        return null; // 이 경우 JSP로 이동하지 않고 JSON 응답만 반환
    }
}
