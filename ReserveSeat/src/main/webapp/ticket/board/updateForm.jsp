<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Noto Sans', 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #eef2f3, #8e9eab); /* 부드러운 그라데이션 배경 */
    color: #333;
}

/* 제목 스타일 */
h2 {
    text-align: center;
    color: #007BFF; /* 포인트 컬러 */
    font-size: 2.5rem;
    margin-top: 40px;
    font-weight: bold;
    text-transform: uppercase; /* 대문자 */
    letter-spacing: 1px;
}

/* 폼 스타일 */
form {
    width: 90%;
    max-width: 700px; /* 적절한 최대 너비 */
    margin: 30px auto;
    padding: 30px;
    background-color: white;
    border-radius: 15px; /* 부드러운 곡선 */
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 */
    animation: fadeIn 0.6s ease-in-out; /* 부드러운 등장 효과 */
}

/* 입력 요소 스타일 */
p {
    font-size: 1.2rem;
    margin-bottom: 20px;
}

input[type="text"], textarea {
    width: 100%;
    padding: 12px 15px;
    font-size: 1rem;
    border: 1px solid #ddd;
    border-radius: 8px; /* 부드러운 곡선 */
    margin-top: 8px;
    margin-bottom: 15px;
    box-sizing: border-box;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

/* 포커스 상태에서 효과 */
input[type="text"]:focus, textarea:focus {
    border-color: #007BFF;
    box-shadow: 0 5px 10px rgba(0, 123, 255, 0.2);
    outline: none;
}

/* textarea 스타일 */
textarea {
    resize: vertical;
    font-family: 'Noto Sans', 'Arial', sans-serif;
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 12px 15px;
    text-align: left;
    font-size: 1rem;
    border: 1px solid #ddd;
}

th {
    background-color: #007BFF;
    color: white;
    font-weight: bold;
    text-transform: capitalize;
}

td {
    background-color: #f9f9f9;
}

/* 버튼 스타일 */
button {
    padding: 14px 20px;
    font-size: 1.2rem;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 10px; /* 부드러운 곡선 */
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
    font-weight: bold;
    width: 100%; /* 버튼 전체 너비 */
    margin-top: 20px;
}

button:hover {
    background-color: #0056b3;
    transform: translateY(-3px); /* 살짝 위로 이동 */
    box-shadow: 0 8px 20px rgba(0, 123, 255, 0.4);
}

button:focus {
    outline: none;
}

/* 취소 버튼 스타일 */
a button {
    background-color: #FF6B6B; /* 빨간색 취소 버튼 */
}

a button:hover {
    background-color: #d11a1a; /* hover 시 어두운 빨간색 */
    box-shadow: 0 8px 20px rgba(209, 26, 26, 0.4); /* 강한 그림자 */
}

/* 애니메이션 */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(10px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* 링크 스타일 */
a {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #007BFF;
    color: white;
    text-decoration: none;
    font-size: 1rem;
    border-radius: 8px;
    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
}

a:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
    box-shadow: 0 5px 15px rgba(0, 123, 255, 0.4);
}

</style>
<body>
    <h2>게시글 수정</h2>
    <form action="/ReserveSeat/board/update.do" method="post">
        <!-- 게시글 번호는 숨겨서 전송 -->
        <input type="hidden" name="no" value="${board.no}" />

        <table border="1">
            <tr>
                <th>번호</th>
                <td>${board.no}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" value="${board.title}" required />
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" name="writer" value="${board.writer}" readonly />
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" rows="5" cols="50" required>${board.content}</textarea>
                </td>
            </tr>
        </table>

        <br />
        <button type="submit">수정 완료</button>
        <a href="/ReserveSeat/board/detail.do?no=${board.no}" class="cancel-button">취소</a>
    </form>
</body>
</html>
