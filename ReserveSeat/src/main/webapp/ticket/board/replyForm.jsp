<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>답글 작성</title>
</head>
<body>
    <h2>답글 작성</h2>
    <form action="/ReserveSeat/board/reply.do" method="post">
        <!-- 부모 게시글 번호는 숨겨서 전송 -->
        <input type="hidden" name="whoseNo" value="${param.no}" />

        <table border="1">
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" placeholder="답글 제목" required />
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" name="writer" value ="${sessionScope.user.name}"readonly ></p>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" rows="5" cols="50" placeholder="답글 내용" required></textarea>
                </td>
            </tr>
        </table>

        <br />
        <button type="submit">답글 등록</button>
        <a href="/ReserveSeat/board/list.do">
            <button type="button">취소</button>
        </a>
    </form>
</body>
</html>
