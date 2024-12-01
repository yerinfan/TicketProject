package kr.ac.kopo.framework;

import java.io.IOException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class CallbackServlet extends HttpServlet {

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CLIENT_ID = "416895645323-2igtu9i3f66khm4t4avdaapqp1q5f012.apps.googleusercontent.com";

    private MemberDAO memberDAO = new MemberDAO();
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Google에서 반환된 ID 토큰 가져오기
        String idTokenString = request.getParameter("id_token");

        if (idTokenString == null || idTokenString.isEmpty()) {
            response.sendRedirect("/ReserveSeat/ticket/member/loginForm.jsp");
            return;
        }

        try {
            // Google ID Token 검증기 생성
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JSON_FACTORY)
                    .setAudience(Collections.singletonList(CLIENT_ID))
                    .build();

            // ID 토큰 검증
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                // 사용자 정보 가져오기
                String userId = payload.getSubject(); // 고유 사용자 ID
                String email = payload.getEmail(); // 이메일 주소
                String name = (String) payload.get("name");

                // 사용자 정보 저장/확인
                MemberVO member = memberDAO.findMemberByGoogleId(userId);
                if (member == null) {
                    // 신규 사용자라면 회원가입 페이지로 리다이렉트
                    request.getSession().setAttribute("googleUser", new MemberVO(userId, name, email));
                    response.sendRedirect("/ReserveSeat/ticket/member/register.jsp");
                } else {
                    // 기존 사용자라면 세션에 저장 후 메인 페이지로 이동
                    request.getSession().setAttribute("user", member);
                    response.sendRedirect("/ReserveSeat/index.jsp");
                }
            } else {
                // ID 토큰이 유효하지 않음
                response.sendRedirect("/ReserveSeat/ticket/member/loginForm.jsp?error=invalid_token");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ReserveSeat/ticket/member/loginForm.jsp?error=exception");
        }
    }
}
