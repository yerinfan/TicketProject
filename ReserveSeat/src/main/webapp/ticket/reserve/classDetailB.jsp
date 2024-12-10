<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>강의실 A - 좌석 선택</title>

<style>

body {
    font-family: 'Noto Sans', 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
    color: #333; /* 기본 텍스트 색상 */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    height: 100vh;
}

/* 전체 테이블 컨테이너 스타일 */
.tables-container {
    display: flex; /* 가로 정렬 */
    justify-content: center; /* 중앙 정렬 */
    align-items: flex-start; /* 상단 정렬 */
    gap: 50px; /* 두 테이블 간 간격 */
    margin-top: 20px;
}

/* 개별 테이블 래퍼 스타일 */
.table-wrapper {
    display: flex;
    flex-direction: column; /* 세로 정렬 */
    align-items: center;
}

/* 테이블 스타일 */
table {
    border-collapse: collapse;
    margin: auto;
}

td {
    border: 1px solid black;
    text-align: center;
    padding: 10px;
    width: 50px;
    height: 50px;
}

/* 각 칸의 상태에 따른 색상 */
.reserved {
    background-color: red;
    color: white;
}

.available {
    background-color: green;
    color: white;
    cursor: pointer;
}

/* 헤더와 레이블 스타일 */
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
	<h2 style="text-align: center;">ai iot 실습실 좌석 현황</h2>
		 <h3 style="text-align: center;">칠판</h3>
	<table>
		<c:forEach var="row" begin="1" end="6">
			<tr>
				<td class="row-label">행 ${row}</td>
				<c:forEach var="col" begin="1" end="5">
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
