<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Noto Sans', 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #eef2f3, #8e9eab); /* 부드러운 그라데이션 배경 */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #333;
}

/* 폼 컨테이너 스타일 */
.form-container {
    background: white;
    padding: 40px;
    border-radius: 20px; /* 부드러운 곡선 */
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15); /* 부드러운 그림자 */
    width: 100%;
    max-width: 450px; /* 최대 너비 제한 */
    text-align: center;
}

/* 제목 스타일 */
h2 {
    font-size: 2.4rem;
    margin-bottom: 30px;
    color: #444;
    font-weight: 700;
    text-transform: uppercase; /* 대문자로 변환 */
    letter-spacing: 1px;
}

/* 테이블 스타일 */
table {
    margin: 0 auto;
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 15px;
    text-align: left;
    font-size: 1.1rem;
    vertical-align: middle;
}

th {
    width: 30%;
    background-color: #007BFF; /* 통일된 파란색 */
    color: white;
    border-radius: 5px 0 0 5px; /* 왼쪽 둥근 테두리 */
    font-weight: bold;
    text-transform: capitalize;
}

td {
    font-size: 1rem;
    background-color: #f9f9f9;
    border-radius: 0 5px 5px 0; /* 오른쪽 둥근 테두리 */
}

/* 입력 필드 스타일 */
input[type="text"], input[type="password"], input[type="email"] {
    width: 100%;
    padding: 14px;
    font-size: 1rem;
    border: 1px solid #ddd;
    border-radius: 8px; /* 부드러운 모서리 */
    margin-top: 8px;
    margin-bottom: 15px;
    box-sizing: border-box;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

input[type="text"]:focus, 
input[type="password"]:focus, 
input[type="email"]:focus {
    border-color: #007BFF; /* 통일된 파란색 */
    box-shadow: 0 5px 10px rgba(0, 123, 255, 0.2);
    outline: none;
}

/* 버튼 스타일 (가입 버튼) */
button {
    width: 100%;
    padding: 15px;
    background-color: #007BFF; /* 통일된 파란색 */
    color: white;
    border: none;
    border-radius: 10px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
    font-weight: bold;
}

button:hover {
    background-color: #0056b3; /* 통일된 호버 색상 */
    transform: translateY(-3px); /* 살짝 위로 이동 */
    box-shadow: 0 8px 20px rgba(0, 123, 255, 0.4); /* 강한 그림자 */
}

button:focus {
    outline: none;
}

/* 취소 버튼 스타일 */
a button {
    width: 100%;
    padding: 15px;
    background-color: #ff4d4d; /* 강렬한 빨간색 */
    border: none;
    color: white;
    border-radius: 10px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
    margin-top: 10px;
}

a button:hover {
    background-color: #d11a1a; /* hover 시 어두운 빨간색 */
    transform: translateY(-3px); /* 살짝 위로 이동 */
    box-shadow: 0 8px 20px rgba(209, 26, 26, 0.4); /* 강한 그림자 */
}

/* 홈으로 링크 버튼 스타일 */
a.home-link {
    display: inline-block;
    margin-top: 30px;
    padding: 12px 20px;
    background-color: #ff4d4d; /* 홈 버튼 색상 */
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

</style>
<body>
<div class="form-container">

    <h2>회원 가입</h2>
    
    <form action="/ReserveSeat/regist.do" method="post">
        <table border="1">
            <tr>
                <th>학번</th>
                <td>
                    <input type="text" name="user_id" required />
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" required />
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="password" required />
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="email" name="email"/>
                </td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td>
                    <input type="text" name="nickname" required />
                </td>
            </tr>
        </table>
        <br>
        <button type="submit">가입하기</button>
        <a href="/ReserveSeat/index.jsp" class="home-link">취소</a>
    </form>
        </div>
</body>
</html>
