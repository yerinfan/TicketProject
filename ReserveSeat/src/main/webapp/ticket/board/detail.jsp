<%@page import="kr.ac.kopo.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%
String loggedInUserId = null;
if (session.getAttribute("user") != null) {
	loggedInUserId = ((kr.ac.kopo.vo.MemberVO) session.getAttribute("user")).getUserId();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 배경색 */
}

/* 제목 스타일 */
h2 {
    text-align: center;
    color: #333;
    font-size: 2rem;
    margin-top: 40px;
}

/* 테이블 스타일 */
table {
    width: 80%;
    margin: 30px auto;
    border-collapse: collapse;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    background-color: white;
    border-radius: 10px;
    overflow: hidden;
}

th, td {
    padding: 15px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #0044cc;
    color: white;
    font-size: 1.2rem;
}

td {
    font-size: 1rem;
    color: #333;
}

tr:hover {
    background-color: #f1f1f1;
}

/* "등록된 게시글이 없습니다." 텍스트 스타일 */
td[colspan="4"] {
    text-align: center;
    font-size: 1.1rem;
    color: #888;
    padding: 20px;
}

/* 버튼 스타일 */
button {
    padding: 10px 20px;
    font-size: 1.2rem;
    background-color: #87CEEB;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
    margin: 10px;
}

button:hover {
    background-color: #00BFFF;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

/* 버튼을 가운데 정렬 */
a {
    text-decoration: none;
}

</style>
<body>
	<h2>게시글 상세보기</h2>
	<table border="1">

		<tr>
			<th>번호</th>
			<td><c:out value="${board.no}" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><c:out value="${board.title}" /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${board.writer}" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><c:out value="${board.content}" /></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><c:out value="${board.regDate}" /></td>
		</tr>
	</table>


	<c:choose>
		<c:when test="${board.writer == loggedInUserId}">
			<br>
			<a href="/ReserveSeat/board/updateForm.do?no=${board.no}">
				<button>수정</button>
			</a>
			<a href="/ReserveSeat/board/delete.do?no=${board.no}"
				onclick="return confirm('삭제하시겠습니까?')">
				<button>삭제</button>
			</a>

		</c:when>

	</c:choose>
	<a href="/ReserveSeat/board/replyForm.do?no=${board.no}">
		<button>답글</button>
	</a>
	<a href="/ReserveSeat/board/list.do">
		<button>목록</button>
	</a>
</body>
</html>
