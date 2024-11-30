<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>자리 선점하기</title>
</head>
<body>
    <h2>자리 선점하기</h2>
    <form action="/ReserveSeat/reserve/detail.do" method="get">
        <label>
            시간 선택:
            <input type="radio" name="time" value="morning" required> 오전
            <input type="radio" name="time" value="afternoon"> 오후
        </label>
        <br><br>
        <label>
            강의실 선택:
            <select name="classNo" required>
                <option value="A">강의실 A</option>
                <option value="B">강의실 B</option>
                <option value="C">강의실 C</option>
            </select>
        </label>
        <br><br>
        <button type="submit">좌석 확인</button>
    </form>
</body>
</html>
