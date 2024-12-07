<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
}

/* 제목 스타일 */
h2 {
    text-align: center;
    color: #0044cc;
    font-size: 2.5rem;
    margin-top: 40px;
    font-weight: bold;
}

/* 폼 스타일 */
form {
    width: 80%;
    max-width: 800px;
    margin: 30px auto;
    padding: 30px;
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* 입력 요소 스타일 */
p {
    font-size: 1.2rem;
    margin-bottom: 20px;
}

input[type="text"], textarea {
    width: 100%;
    padding: 12px;
    font-size: 1rem;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-top: 8px;
    margin-bottom: 15px;
    box-sizing: border-box;
}

/* textarea 스타일 */
textarea {
    resize: vertical;
}

/* 버튼 스타일 */
button {
    padding: 12px 25px;
    font-size: 1.2rem;
    background-color: #87CEEB;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
    margin-top: 20px;
    width: 100%;
}

button:hover {
    background-color: #00BFFF;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

/* 링크 스타일 */
a {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #0044cc;
    color: white;
    text-decoration: none;
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
	<h2>게시글 등록</h2>
	<form action="/ReserveSeat/board/add.do" method="post">
		<p>제목: <input type="text" name="title" required></p>
		<p>작성자: <input type="text" name="writer" value ="${sessionScope.user.nickname}"readonly ></p>
		<p>내	용:</p>
		<p><textarea name="content" rows="10" cols="50" required></textarea></p>
		<button onclick="registerPost()">등록</button>
	</form>
	<br>
	<a href="/ReserveSeat/board/list.do">목록으로</a>
</body>
</html>
