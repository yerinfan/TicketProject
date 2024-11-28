<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
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
        <a href="/ReserveSeat/board/detail.do?no=${board.no}">
            <button type="button">취소</button>
        </a>
    </form>
</body>
</html>
