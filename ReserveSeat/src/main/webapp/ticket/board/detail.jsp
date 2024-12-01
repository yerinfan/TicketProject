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
