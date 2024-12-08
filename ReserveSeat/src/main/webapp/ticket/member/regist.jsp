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
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* 폼 컨테이너 스타일 */
.form-container {
    background: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 400px;
    text-align: center;
}

/* 제목 스타일 */
h2 {
    font-size: 2rem;
    margin-bottom: 30px;
    color: #333;
    font-weight: bold;
}

/* 테이블 스타일 */
table {
    margin: 0 auto;
    width: 100%;
    border-collapse: collapse;
    background-color: white;
}

th, td {
    padding: 12px;
    text-align: left;
    font-size: 1.1rem;
}

th {
    width: 30%;
    background-color: #0044cc;
    color: white;
}

td {
    font-size: 1rem;
}

/* 입력 필드 스타일 */
input[type="text"], input[type="password"], input[type="email"] {
    width: 100%;
    padding: 12px;
    font-size: 1rem;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-top: 5px;
    margin-bottom: 15px;
    box-sizing: border-box;
}

/* 버튼 스타일 */
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

/* 취소 버튼 스타일 */
a button {
    background-color: #ff4d4d;
}

a button:hover {
    background-color: #d11a1a;
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
        <a href="/login.do">
            <button type="button">취소</button>
        </a>
    </form>
        </div>
</body>
</html>
