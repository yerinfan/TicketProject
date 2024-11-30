<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<body>
    <h2>회원 가입</h2>
    
    <form action="/ReserveSeat/regist.do" method="post">
        <table border="1">
            <tr>
                <th>학번</th>
                <td>
                    <input type="text" name="user_id" required />
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" required />
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="password" required />
                </td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td>
                    <input type="text" name="nickname" required />
                </td>
            </tr>
        </table>
        <br>
        <button type="submit">가입하기</button>
        <a href="/login.do">
            <button type="button">취소</button>
        </a>
    </form>
</body>
</html>
