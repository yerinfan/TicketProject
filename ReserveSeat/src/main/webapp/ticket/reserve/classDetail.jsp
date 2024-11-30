<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>좌석 선택</title>
    <style>
        .seat { width: 30px; height: 30px; text-align: center; }
        .empty { background-color: green; color: white; }
        .reserved { background-color: red; color: white; }
    </style>
</head>
<body>
    <h2>좌석 선택</h2>
    <form action="/ReserveSeat/reserve/reserv.do" method="post">
        <table border="1">
            <c:forEach var="row" begin="1" end="${seatRow}">
                <tr>
                    <c:forEach var="col" begin="1" end="${seatCol}">
                        <td class="seat ${seatStatus[row-1][col-1] == 'Y' ? 'empty' : 'reserved'}">
                            <input type="radio" name="seatNo" value="${row}-${col}" ${seatStatus[row-1][col-1] == 'N' ? 'disabled' : ''}>
                            ${row}-${col}
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="classNo" value="${classNo}">
        <input type="hidden" name="time" value="${time}">
        <br>
        <button type="submit">예약</button>
    </form>
</body>
</html>
