<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.json.JSONObject"%>
<%@ page import="kr.ac.kopo.service.MemberService"%>
<%@ page import="kr.ac.kopo.vo.MemberVO"%>
<%
    String clientId = "B9AWK_9qoqbmaucJFSO1"; // 네이버 앱 Client ID
    String clientSecret = "XKfbL3E8tR"; // 네이버 앱 Client Secret
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8080/ReserveSeat/test.jsp", "UTF-8");

    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
        + "&client_id=" + clientId
        + "&client_secret=" + clientSecret
        + "&redirect_uri=" + redirectURI
        + "&code=" + code
        + "&state=" + state;

    String accessToken = "";
    try {
        // Access Token 요청
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(
            responseCode == 200 ? con.getInputStream() : con.getErrorStream()));
        StringBuilder res = new StringBuilder();
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            res.append(inputLine);
        }
        br.close();

        if (responseCode == 200) {
            JSONObject tokenResponse = new JSONObject(res.toString());
            accessToken = tokenResponse.getString("access_token");

            // 사용자 정보 요청
            String userInfoURL = "https://openapi.naver.com/v1/nid/me";
            URL userInfoEndpoint = new URL(userInfoURL);
            HttpURLConnection userInfoCon = (HttpURLConnection) userInfoEndpoint.openConnection();
            userInfoCon.setRequestMethod("GET");
            userInfoCon.setRequestProperty("Authorization", "Bearer " + accessToken);
            int userInfoResponseCode = userInfoCon.getResponseCode();

            BufferedReader userInfoBr = new BufferedReader(new InputStreamReader(
                userInfoResponseCode == 200 ? userInfoCon.getInputStream() : userInfoCon.getErrorStream()));
            StringBuilder userInfoRes = new StringBuilder();
            while ((inputLine = userInfoBr.readLine()) != null) {
                userInfoRes.append(inputLine);
            }
            userInfoBr.close();

            if (userInfoResponseCode == 200) {
                JSONObject userInfoResponse = new JSONObject(userInfoRes.toString());
                JSONObject userResponse = userInfoResponse.getJSONObject("response");
                String email = userResponse.getString("email");
                String nickname = userResponse.getString("nickname");

                // DB 처리
                MemberService memberService = new MemberService();
                MemberVO member = memberService.findByEmail(email);

                if (member != null) {
                    // 회원이 존재하면 로그인 처리
                    session.setAttribute("user", member);
                    response.sendRedirect("/ReserveSeat/index.jsp");
                } else {
                    // 회원가입 진행
                    request.setAttribute("email", email);
      				request.setAttribute("nickname", nickname);
      				request.getRequestDispatcher("/ReserveSeat/registerForm.jsp").forward(request, response);
                    
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("/ReserveSeat/error.jsp");
    }
%>
