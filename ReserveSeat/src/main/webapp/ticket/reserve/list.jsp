<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>자리 선점하기</title>
</head>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f7fc; /* 부드러운 배경색 */
    color: #333;
}

/* 제목 스타일 */
h2 {
    text-align: center;
    color: #0044cc;
    font-size: 2rem;
    margin-top: 40px;
}

/* 폼 스타일 */
form {
    width: 80%;
    max-width: 600px;
    margin: 40px auto;
    padding: 20px;
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* 라벨 및 입력 요소 스타일 */
label {
    font-size: 1.2rem;
    margin-bottom: 10px;
    display: block;
    color: #333;
}

/* 라디오 버튼 및 셀렉트 박스 스타일 */
input[type="radio"], select {
    margin-top: 10px;
    margin-bottom: 20px;
    padding: 10px;
    font-size: 1rem;
    border-radius: 5px;
    border: 1px solid #ddd;
    width: 100%;
}

/* 버튼 스타일 */
button {
    padding: 12px 20px;
    font-size: 1.2rem;
    background-color: #0044cc;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
    width: 100%;
    margin-top: 20px;
}

button:hover {
    background-color: #00BFFF;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}
/* 라디오 버튼 스타일 */
label {
    font-size: 1.2rem;
    margin-bottom: 10px;
    display: block;
    color: #333;
}

input[type="radio"] {
    margin-right: 10px; /* 오른쪽 여백을 추가하여 간격을 조정 */
    display: inline-block; /* 라디오 버튼들을 가로로 정렬 */
    width: auto; /* 기본 크기로 설정 */
}

/* 시간 선택 그룹 정렬 */
.radio-group {
    display: flex;
    justify-content: center; /* 라디오 버튼들을 가로로 중앙 정렬 */
    gap: 20px; /* 라디오 버튼들 사이 간격 */
    margin-bottom: 20px;
}
/* 홈으로 링크 버튼 스타일 */
a.home-link {
    display: inline-block;
    margin-top: 30px;
    padding: 12px 20px;
    background-color: #28a745; /* 홈 버튼 색상 */
    color: white;
    text-decoration: none;
    font-size: 1.1rem;
    border-radius: 8px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

a.home-link:hover {
    background-color: #218838; /* hover 시 색상 변화 */
    transform: translateY(-2px); /* 살짝 위로 이동 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

</style>
<body>
    <h2>자리 선점하기</h2>

    <!-- 에러 메시지 출력 -->
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">
            <strong>Error:</strong> ${errorMessage}
        </div>
    </c:if>

    <!-- 강의실 선택 폼 -->
    <c:if test="${empty errorMessage}">
        <form action="/ReserveSeat/reserve/detail.do" method="get">
            <label for="roomId">강의실 선택:</label>
            <select name="roomId" id="roomId" required>
                <c:if test="${not empty seatSummaries}">
                    <c:forEach var="summary" items="${seatSummaries}">
                        <option value="${summary.roomId}">
                            ${summary.className} (잔여 좌석: ${summary.remainingSeats != null ? summary.remainingSeats : 0}/${summary.totalSeats != null ? summary.totalSeats : 0})
                        </option>
                    </c:forEach>
                </c:if>
                <c:if test="${empty seatSummaries}">
                    <option value="">강의실 데이터가 없습니다</option>
                </c:if>
            </select>		
            <br><br>
            <button type="submit">좌석 확인</button>
        </form>
    </c:if>

    <!-- 홈으로 이동 -->
<a href="/ReserveSeat/index.jsp" class="home-link">홈으로</a>
</body>

</html>
