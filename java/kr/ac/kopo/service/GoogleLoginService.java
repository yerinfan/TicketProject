package kr.ac.kopo.service;

import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class GoogleLoginService {
    private static final String CLIENT_ID = "416895645323-2igtu9i3f66khm4t4avdaapqp1q5f012.apps.googleusercontent.com";

    public static String verifyGoogleToken(String idTokenString) throws Exception {
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                jsonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // 사용자 정보 추출
            String userId = payload.getSubject();
            String email = payload.getEmail();
            String name = (String) payload.get("name");

            // 이메일 인증 여부 확인
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());

            System.out.println("Google ID: " + userId);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

            return email;
        } else {
            throw new Exception("Invalid ID token.");
        }
    }
}
