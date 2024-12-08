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
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* 로그인 폼 컨테이너 스타일 */
.login-container {
    background: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 400px;
    text-align: center;
}

h1 {
    font-size: 2rem;
    margin-bottom: 30px;
    color: #333;
    font-weight: bold;
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
    padding: 12px;
    font-size: 1rem;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-top: 5px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 12px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
}

button:hover {
    background-color: #0056b3;
}

button:focus {
    outline: none;
}

/* 네이버 로그인 버튼 스타일 */
#naver_id_login {
    margin-top: 20px;
    text-align: center;
}

/* 회원 등록 및 네이버 로그인 스타일 */
.register-button {
    display: block;
    margin-top: 20px;
    text-decoration: none;
    color: #007BFF;
    font-size: 1.2rem;
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
    margin-top: 20px;
    padding: 12px 20px;
    background-color: #28a745; /* 홈 버튼 색상 */
    color: white;
    text-decoration: none;
    font-size: 1.2rem;
    border-radius: 5px;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
}

a.home-link:hover {
    background-color: #218838; /* hover 시 색상 변화 */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
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
  <a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>

  <a href="/ReserveSeat/regist.do" class="register-button">회원 등록<br></a>
		<a href="/ReserveSeat/index.jsp" class="home-link">홈으로</a>
	</div>
</body>
</html>
