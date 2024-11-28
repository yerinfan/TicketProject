<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form action="/ReserveSeat/board/add.do" method="post">
		<p>제목: <input type="text" name="title" required></p>
		<p>작성자: <input type="text" name="writer" required></p>
		<p>내용:</p>
		<p><textarea name="content" rows="10" cols="50" required></textarea></p>
		<button type="submit">등록</button>
	</form>
	<br>
	<a href="/ReserveSeat/board/list.do">목록으로</a>
</body>
</html>
