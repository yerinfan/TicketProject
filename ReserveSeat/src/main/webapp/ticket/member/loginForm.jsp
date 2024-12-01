<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ReserveSeat/ticket/member/style.css">
<script src="https://accounts.google.com/gsi/client" async defer></script>
</head>
<body>
 <div class="login-container">
	<h1>로그인</h1>
	<form action="/ReserveSeat/login.do" method="post" class="login-form">
		<div class="input-group">
                <label for="userId">아이디:</label>
                <input type="text" name="userId" id="userId" required />
            </div>
            <div class="input-group">
                <label for="password">비밀번호:</label>
                <input type="password" name="password" id="password" required />
            </div>
            <button type="submit" class="login-button">로그인</button>
	</form>	
	
<div class="google-login">
	<script src="https://accounts.google.com/gsi/client" async defer></script>
	<div id="g_id_onload"
		data-client_id="416895645323-2igtu9i3f66khm4t4avdaapqp1q5f012.apps.googleusercontent.com"
		data-login_uri="http://localhost:8080/oauth2callback"
		data-auto_prompt="false"></div>
	<div class="g_id_signin" data-type="standard"></div>
	        </div>
	        
		<a href="/ReserveSeat/regist.do" class="register-button">회원 등록<br></a>
		</div>
</body>
</html>
