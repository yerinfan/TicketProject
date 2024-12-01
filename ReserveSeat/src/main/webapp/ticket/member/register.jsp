<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
    <h1>회원 가입</h1>
    <form action="/ReserveSeat/registerProcess.do" method="post">
        <input type="hidden" name="userId" value="${sessionScope.googleUser.userId}" />
        <input type="hidden" name="email" value="${sessionScope.googleUser.email}" />
        <label>이름: </label>
        <input type="text" name="name" value="${sessionScope.googleUser.name}" required /><br/>
        <label>추가 정보(닉네임): </label>
        <input type="text" name="nickname" required /><br/>
        <button type="submit">회원가입 완료</button>
    </form>
</body>
</html>
