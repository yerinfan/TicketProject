<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="kr.ac.kopo.vo.ClassVO" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의실 상세</title>
</head>
<body>
    <h2>강의실 상세 정보</h2>
    <table>
        <thead>
            <tr>
                <th>좌석 번호</th>
                <th>행</th>
                <th>열</th>
                <th>상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="seat" items="${seatList}">
                <tr>
                    <td>${seat.seatNo}</td>
                    <td>${seat.seatRow}</td>
                    <td>${seat.seatCol}</td>
                    <td>${seat.isEmpty}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
