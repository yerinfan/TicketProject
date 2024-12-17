<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f7fc;
    color: #333;
    margin: 0;
    padding: 0;
    text-align: center;
}

/* 제목 스타일 */
h2 {
    font-size: 2.5rem;
    color: #0044cc;
    margin-top: 50px;
    font-weight: bold;
}

/* 예약 정보 스타일 */
p {
    font-size: 1.1rem;
    margin: 10px 0;
    color: #333;
}

strong {
    font-weight: bold;
    color: #0044cc; /* 예약자 이름 강조 */
}

/* 테이블 스타일 */
table {
    border-collapse: collapse;
    margin: 40px auto;
    width: 80%;
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

th, td {
    border: 1px solid #ddd;
    text-align: center;
    padding: 12px;
    font-size: 1.1rem;
}

th {
    background-color: #0044cc;
    color: white;
}

td {
    background-color: #f9f9f9;
}

/* 테이블 행 호버 효과 */
tr:hover {
    background-color: #f1f1f1;
}

/* "예약된 좌석이 없습니다" 메시지 스타일 */
p {
    font-size: 1.2rem;
    color: #888;
}
/* 링크(홈으로) 스타일 */
a {
    text-decoration: none;
    display: inline-block;
    margin-top: 20px;
    padding: 12px 20px;
    background-color: #0044cc;
    color: white;
    font-size: 1.2rem;
    border-radius: 5px;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
}

a:hover {
    background-color: #00BFFF;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}
</style>
<head>
    <title>선점 성공</title>
</head>
<body>
    <h1>좌석 선점 완료</h1>
    <p>강의실 ID: ${roomId}</p>
    <p>좌석 ID: ${seatId}</p>
    <p>예약자: ${userName}</p>
    <p>선점이 완료되었습니다. 즐거운 하루 되세요!</p>
   <a href="/ReserveSeat/index.jsp" class="home-link">홈으로</a>
</body>
</html>
