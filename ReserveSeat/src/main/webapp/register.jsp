<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <script>
        // 해시(fragment) 처리 및 서버로 리다이렉트
        if (window.location.hash) {
            const hash = window.location.hash.substring(1); // # 뒤의 문자열 가져오기
            const params = new URLSearchParams(hash);

            const accessToken = params.get("access_token");
            const state = params.get("state");

            if (accessToken) {
                // Redirect 방식으로 서버로 전달
                const redirectUrl = '/ReserveSeat/naverCallback.do?access_token=' + 
                    encodeURIComponent(accessToken) + '&state=' + 
                    encodeURIComponent(state);

                // 서버로 리다이렉트
                window.location.href = redirectUrl;
            } else {
                alert("로그인 실패: 액세스 토큰을 찾을 수 없습니다.");
                window.location.href = "/ReserveSeat/ticket/member/loginForm.jsp"; // 로그인 페이지로 이동
            }
        } else {
            alert("해시 정보가 없습니다.");
            window.location.href = "/ReserveSeat/ticket/member/loginForm.jsp"; // 로그인 페이지로 이동
        }
    </script>
</head>
<body>
    <!-- JS가 처리 중이므로 아무 내용도 표시하지 않아도 됩니다. -->
</body>
</html>
