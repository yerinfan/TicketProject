<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>내 예약 좌석 정보</title>
    <style>
        table {
            border-collapse: collapse;
            margin: auto;
            width: 60%;
        }
        th, td {
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">내 예약 좌석 정보</h2>

    <c:if test="${not empty reservedSeats}">
        <table>
            <thead>
                <tr>
                    <th>좌석 번호</th>
                    <th>강의실</th>
                    <th>예약 시간대</th>
                    <th>행</th>
                    <th>열</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="seat" items="${reservedSeats}">
                    <tr>
                        <td>${seat.seatNo}</td>
                        <td>${seat.classNo}</td>
                        <td>${seat.regTime}</td>
                        <td>${seat.seatRow}</td>
                        <td>${seat.seatCol}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty reservedSeats}">
        <p style="text-align: center;">예약된 좌석이 없습니다.</p>
    </c:if>
</body>
</html>
