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
<head>
<title>강의실 ${roomId} 좌석 상세 정보</title>
<style>
.available {
	background-color: lightgreen;
}

.reserved {
	background-color: lightcoral;
}

.broken {
	background-color: lightgray;
}

.seat {
	padding: 10px;
	border: 1px solid black;
	display: inline-block;
	margin: 5px;
}

/* 링크(홈으로) 스타일 */
a {
    text-decoration: none;
    display: inline-block;
    margin-top: 20px;
    padding: 12px 20px;
    background-color: #0044cc;
    color: white;
    font-size: 1.2rem;
    border-radius: 5px;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
}

a:hover {
    background-color: #00BFFF;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}
</style>
<script>
	function confirmReservation(roomId, seatId) {
		console.log("seatId:", seatId); // seatId 값 출력
		console.log("roomId:", roomId); // roomId 값 출력
		if (confirm("좌석을 선점하시겠습니까?")) {
			const url = `/ReserveSeat/reserve/confirm.do?roomId=${roomId}&seatId=${seatId}`;
			console.log("Generated URL:", url); // 디버깅용
			location.href = url;
		}
	}
</script>
</head>
<body>

	<h1>프로그래밍 실습실 좌석 상세 정보</h1>

	<c:if test="${not empty errorMessage}">
		<div style="color: red;">
			<strong>Error:</strong> ${errorMessage}
		</div>
	</c:if>

	<c:if test="${empty errorMessage}">
		<div>
			<c:forEach var="seat" items="${seatList}">
				<div class="seat ${seat.status}">
					좌석 ID: ${seat.seatId} <br> 위치: ${seat.rowNumber}행,
					${seat.columnNumber}열 <br>
					<c:if test="${seat.status == 'available'}">
					상태: 예약 가능 <br>
						<form action="/ReserveSeat/reserve/confirm.do" method="post"
							style="display: inline;">
							<input type="hidden" name="seatId" value="${seat.seatId}">
							<input type="hidden" name="roomId" value="${roomId}">
							<button type="submit">선점하기</button>
						</form>
					</c:if>
				</div>
			</c:forEach>

		</div>
	</c:if>

	<a href="/ReserveSeat/index.jsp" class="home-link">홈으로</a>
</body>
</html>
