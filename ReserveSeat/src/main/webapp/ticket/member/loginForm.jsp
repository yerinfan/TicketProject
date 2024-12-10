<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Noto Sans', 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #eef2f3, #8e9eab); /* 그라데이션 배경 */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #333;
}

/* 로그인 폼 컨테이너 스타일 */
.login-container {
    background: white;
    padding: 40px;
    border-radius: 15px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15); /* 그림자 개선 */
    width: 100%;
    max-width: 400px; /* 적절한 너비 */
    text-align: center;
}

h1 {
    font-size: 2.2rem;
    margin-bottom: 30px;
    color: #444;
    font-weight: 700;
    letter-spacing: 1px; /* 약간의 자간 추가 */
}

/* 입력 필드 스타일 */
.input-group {
    margin-bottom: 20px;
    text-align: left;
}

label {
    font-size: 1.1rem;
    color: #333;
    display: block;
    margin-bottom: 5px;
}

input[type="text"], input[type="password"] {
    width: 100%;
    padding: 12px 15px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 8px; /* 더 부드러운 모서리 */
    margin-top: 5px;
    box-sizing: border-box;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

input[type="text"]:focus, input[type="password"]:focus {
    border-color: #007BFF;
    box-shadow: 0 4px 8px rgba(0, 123, 255, 0.2);
    outline: none;
}

/* 로그인 버튼 스타일 */
button {
    width: 100%;
    padding: 14px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
    background-color: #0056b3;
    transform: translateY(-2px); /* 살짝 위로 이동 */
    box-shadow: 0 6px 12px rgba(0, 123, 255, 0.2);
}

button:focus {
    outline: none;
}

/* 네이버 로그인 버튼 스타일 */
#naver_id_login {
    margin-top: 20px;
    text-align: center;
}

a img {
    margin-top: 20px;
    border-radius: 8px;
    transition: transform 0.2s ease, box-shadow 0.2s ease;
}

a img:hover {
    transform: scale(1.05); /* 크기 확대 */
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

/* 회원 등록 및 네이버 로그인 스타일 */
.register-button {
    display: block;
    margin-top: 20px;
    text-decoration: none;
    color: #007BFF;
    font-size: 1rem;
    font-weight: 500;
    transition: color 0.3s ease;
}

.register-button:hover {
    color: #0056b3;
}

a {
    text-decoration: none;
    color: #007BFF;
    font-size: 1rem;
}

a:hover {
    color: #0056b3;
}

/* 홈으로 링크 버튼 스타일 */
a.home-link {
    display: inline-block;
    margin-top: 30px;
    padding: 12px 20px;
    background-color: #28a745; /* 홈 버튼 색상 */
    color: white;
    text-decoration: none;
    font-size: 1.1rem;
    border-radius: 8px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

a.home-link:hover {
    background-color: #218838; /* hover 시 색상 변화 */
    transform: translateY(-2px); /* 살짝 위로 이동 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

/* 반응형 디자인 */
@media (max-width: 768px) {
    .login-container {
        padding: 30px;
        width: 90%;
    }

    button {
        font-size: 1rem;
        padding: 12px;
    }

    a.home-link {
        font-size: 1rem;
        padding: 10px 15px;
    }
}
	
</style>
<link rel="stylesheet" href="/ReserveSeat/ticket/member/style.css">
</head>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<body>
	<div class="login-container">
		<h1>로그인</h1>
		<form action="/ReserveSeat/login.do" method="post" class="login-form">
			<div class="input-group">
				<label for="userId">아이디:</label> <input type="text" name="userId"
					id="userId" required />
			</div>
			<div class="input-group">
				<label for="password">비밀번호:</label> <input type="password"
					name="password" id="password" required />
			</div>
			<button type="submit" class="login-button">로그인</button>
		</form>

  <%
    String clientId = "B9AWK_9qoqbmaucJFSO1";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8080/ReserveSeat/test.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
         + "&client_id=" + clientId
         + "&redirect_uri=" + redirectURI
         + "&state=" + state;
    session.setAttribute("state", state);	
 %>

  <a href="/ReserveSeat/regist.do" class="register-button">회원 등록<br></a>
    <a href="<%=apiURL%>" ><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/><br></a>
		<a href="/ReserveSeat/index.jsp" class="home-link">홈으로</a>
	</div>
</body>
</html>
