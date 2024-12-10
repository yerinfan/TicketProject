<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>


<!DOCTYPE html>
<html>
<head>
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
	width: 60%;
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
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		<c:choose>
			<c:when test="${boardList != null && !boardList.isEmpty()}">
				<c:forEach items="${boardList}" var="boardVO">
					<tr>
						<td>${boardVO.no}</td>
						<td><a href="/ReserveSeat/board/detail.do?no=${boardVO.no}">
								<c:out value="${boardVO.title}" />
						</a></td>
						<td>${boardVO.writer}</td>
						<td>${boardVO.regDate}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">등록된 게시글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<a href="/ReserveSeat/board/writeForm.do">
		<button>등록</button>
	</a>
	<a href="/ReserveSeat/index.jsp">
		<button>홈</button>
	</a>
</body>
</html>
