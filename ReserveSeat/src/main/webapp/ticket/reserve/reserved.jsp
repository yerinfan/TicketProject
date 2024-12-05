<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>예약 완료</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
    text-align: center; /* 텍스트 중앙 정렬 */
}

/* 제목 스타일 */
h1 {
    color: #0044cc;
    font-size: 2.5rem;
    margin-top: 100px;
    font-weight: bold;
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
<body>
	<h1>${message}</h1>

    <a href="/ReserveSeat/index.jsp">홈으로</a>
</body>
</html>
