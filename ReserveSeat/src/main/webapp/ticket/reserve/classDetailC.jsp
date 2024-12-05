<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>강의실 A - 좌석 선택</title>

<style>
table {
	border-collapse: collapse;
	margin: auto;
	width: 50%;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 10px;
	width: 50px;
	height: 50px;
}

.reserved {
	background-color: red;
	color: white;
}

.available {
	background-color: green;
	color: white;
	cursor: pointer;
}

.header {
	background-color: #f0f0f0;
	font-weight: bold;
}

.row-label, .col-label {
	background-color: #e0e0e0;
}
</style>
</head>

<body>
	<h2 style="text-align: center;">ai 제어 실습실 좌석 현황</h2>
	<table>
		<c:forEach var="row" begin="1" end="8">
			<tr>
				<td class="row-label">행 ${row}</td>
				<c:forEach var="col" begin="1" end="7">
					<c:set var="key" value="${row}-${col}" />
					<c:choose>
						<c:when test="${seatMap[key] != null}">
							<c:set var="seat" value="${seatMap[key]}" />
							<td class="${seat.isEmpty == 'Y' ? 'available' : 'reserved'}">
								<c:if test="${seat.isEmpty == 'Y'}">

									<form action="/ReserveSeat/reserve/reserv.do" method="POST">
										<input type="hidden" name="seatKey" value="${key}" /> <input
											type="hidden" name="classNo" value="${classNo}" /> <input
											type="hidden" name="regTime" value="${regTime}" />
										<button type="submit">예약하기</button>
									</form>
								</c:if> <c:if test="${seat.isEmpty != 'Y'}">

									<button disabled>예약 완료</button>
								</c:if>
							</td>
						</c:when>
						<c:otherwise>

							<td class="empty">-</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
