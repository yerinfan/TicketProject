<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
                        <td>
                            <a href="/ReserveSeat/board/detail.do?no=${boardVO.no}">
                                <c:out value="${boardVO.title}" />
                            </a>
                        </td>
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
